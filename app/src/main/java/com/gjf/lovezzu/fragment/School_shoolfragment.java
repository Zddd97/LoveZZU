package com.gjf.lovezzu.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.flashview.FlashView;
import com.gc.flashview.constants.EffectConstants;
import com.gc.flashview.listener.FlashViewListener;
import com.gjf.lovezzu.R;
import com.gjf.lovezzu.activity.MainActivity;
import com.gjf.lovezzu.activity.schoolnewsActivity.SchoolNewsSubjectActivity;
import com.gjf.lovezzu.activity.schoolnewsActivity.SchoolNewsWebView;
import com.gjf.lovezzu.entity.SchoolMid;
import com.gjf.lovezzu.entity.SchoolNewsData;
import com.gjf.lovezzu.entity.SchoolNewsResult;
import com.gjf.lovezzu.network.SchoolNewsMethods;
import com.gjf.lovezzu.view.SchoolLastAdapter;
import com.gjf.lovezzu.view.SchoolMidAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;

/**
 * Created by lenovo047 on 2017/3/9.
 */

public class School_shoolfragment extends Fragment {
    @BindView(R.id.last_school_listview)
    ListView lastSchoolListview;
    Unbinder unbinder;
    private View view;
    private FlashView flashView;
    private ArrayList<String> imageUrls = new ArrayList<String>();
    private List<SchoolMid> schoolMidList = new ArrayList<>();
    private List<SchoolNewsResult> schoolNewsResultList = new ArrayList<>();
    private int Page;
    public static final String TAG = "Fragment";
    private RecyclerView recyclerView1;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Subscriber subscriber;
    private GridLayoutManager gridLayoutManager;
    SchoolLastAdapter adapter1;
    private LinearLayoutManager linearLayoutManager;
    private int lastVisibleItem;
    ListView listView;
    String urlString;
    Map<String,String> links=new HashMap<String,String>();;
    ArrayAdapter<String> adapter;
    URLConnection con;
    InputStream inputStream;
    ByteArrayOutputStream outputStream;
    Handler handler;
    String html;
    float x1=0,y1=0,x2=0,y2=0;
    boolean isLastItem=false;   //是不是最后一项
    SwipeRefreshLayout swipeRefreshLayout1; //下拉刷新
    int temp_data_count_page = 0;//临时存放当前加载页对应的pos
    int data_count_page_all = 2;//模拟3页数据

    boolean isLoading=false;    //是否正在加载中
    boolean isComp=false;       //标记一次是否加载完成
    LinearLayout id_rl_loading;
    ProgressBar id_pull_to_refresh_load_progress;
    TextView id_pull_to_refresh_loadmore_text;

    final String pull_Load_More = "拖动加载";
    final String loading_Load_More = "加载中...";
    final String comp_Load_More = "加载完成";

    String nowNormalText = "";//存放当前footview显示的文字

    int page=1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.inchool_school_view, container, false);

//            //初始化所需数据
           initSchoolList();
           showTopImage();
            showCenterImage();
//            showEndImage();
//            onRefresh();
//            doUpResfresh();
//            doDownResfresh();






            listView=(ListView)view.findViewById(R.id.last_school_listview);

            urlString="http://www16.zzu.edu.cn/msgs/vmsgisapi.dll/vmsglist?mtype=m&lan=101,102,103&pn=1";

            init(urlString);

            View listview_footer_view = LayoutInflater.from(getActivity()).inflate(R.layout.listview_footer, null);
            id_rl_loading=(LinearLayout)listview_footer_view.findViewById(R.id.id_rl_loading);
            id_pull_to_refresh_load_progress = (ProgressBar) listview_footer_view.findViewById(R.id.id_pull_to_refresh_load_progress);
            id_pull_to_refresh_load_progress.setVisibility(View.GONE);
            id_pull_to_refresh_loadmore_text = (TextView) listview_footer_view.findViewById(R.id.id_pull_to_refresh_loadmore_text);
            id_pull_to_refresh_loadmore_text.setClickable(false);

            listView.addFooterView(listview_footer_view);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String key=parent.getItemAtPosition(position).toString();
                    Log.i("-----key:",key);
                    String url=links.get(key);
                    Log.i("----url:",url);

                    Intent intent=new Intent();
                    intent.setClass(getActivity(),SchoolNewsWebView.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }
            });











        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            onRefresh();
            doUpResfresh();
        }
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    //下拉刷新操作
    private void onRefresh() {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.last_school_content_flash);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshlast();
            }
        });
    }


    //上拉加载


    private void doUpResfresh() {
        if (recyclerView1 == null) {
            recyclerView1 = (RecyclerView) view.findViewById(R.id.last_school_content);
        }

    }

    private void doDownResfresh() {
        recyclerView1.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter1.getItemCount()) {
                    refreshlast();
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });


    }

    private void refreshlast() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //重新加载数据并更新界面
                try {
                    Thread.sleep(200);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getSchoolNews(Page++);
                        adapter1.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });


            }
        }).start();
    }

    private void initSchoolList() {
        //以下数据为测试数据，真实数据可从服务器中获取,由于要加载的数据过多，可以新建一个线程进行加载数据，并进行数据的初始化
        //首页的新闻总是要更新的，是不是可以写成一个server，在后台进行更新
        //头部轮播图片，从服务器中加载

        imageUrls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-09-17127109_1652837611687612_1425055271046086656_n.jpg");
        imageUrls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-13-17267506_264626920661300_5781854075880472576_n.jpg");
        imageUrls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-13-17267506_264626920661300_5781854075880472576_n.jpg");

        //中间滑动项，从服务器中加载
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
        SchoolMid schoolMid_1 = new SchoolMid(R.drawable.schoolintroduce, intent);
        SchoolMid schoolMid_2 = new SchoolMid(R.drawable.schoolstyle, intent);
        SchoolMid schoolMid_3 = new SchoolMid(R.drawable.schoolfamous, intent);
        SchoolMid schoolMid_4 = new SchoolMid(R.drawable.schoolnews, intent);

        schoolMidList.add(schoolMid_1);
        schoolMidList.add(schoolMid_2);
        schoolMidList.add(schoolMid_3);
        schoolMidList.add(schoolMid_4);

        //结尾新闻项（for循环从服务器读取出SchoolLast对象）

//        SchoolNewsResult schoolNewsResult3 = new SchoolNewsResult(R.drawable.life_play_img1, "新闻标题1234", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult4 = new SchoolNewsResult(R.drawable.life_play_img2, "新闻标题tdrhsf", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult5 = new SchoolNewsResult(R.drawable.life_play_img3, "新闻标题dghllllllllllllll", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult6 = new SchoolNewsResult(R.drawable.life_play_img4, "新闻标题217532", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult7 = new SchoolNewsResult(R.drawable.life_play_img5, "新闻标题1024522", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult8 = new SchoolNewsResult(R.drawable.life_play_img6, "新闻标题455", "新闻详情：http://...");
//        SchoolNewsResult schoolNewsResult9 = new SchoolNewsResult(R.drawable.life_play_img1, "新闻标题555555555555555555555555555", "新闻详情：http://...");
//
//
//        schoolNewsResultList.add(schoolNewsResult3);
//        schoolNewsResultList.add(schoolNewsResult4);
//        schoolNewsResultList.add(schoolNewsResult5);
//        schoolNewsResultList.add(schoolNewsResult6);
//        schoolNewsResultList.add(schoolNewsResult7);
//        schoolNewsResultList.add(schoolNewsResult8);
//        schoolNewsResultList.add(schoolNewsResult9);
        getSchoolNews(Page);

    }

    private void showTopImage() {

        //Log.d(TAG, "onCreateView");
        //头部轮播
        flashView = (FlashView) view.findViewById(R.id.flash_view);
        flashView.setImageUris(imageUrls);
        flashView.setEffect(EffectConstants.DEFAULT_EFFECT);//更改图片切换的动画效果
        flashView.setOnPageClickListener(new FlashViewListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(view.getContext(), "你的点击的是第" + (position + 1) + "张图片！",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), SchoolNewsSubjectActivity.class);
                startActivity(intent);


            }
        });

    }

    private void showCenterImage() {

        //中间部分

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.in_mid_school);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        SchoolMidAdapter adapter = new SchoolMidAdapter(schoolMidList);
        recyclerView.setAdapter(adapter);
    }

    private void showEndImage() {
        //结尾部分
        recyclerView1 = (RecyclerView) view.findViewById(R.id.last_school_content);
        gridLayoutManager = new GridLayoutManager(view.getContext(), 3);
        recyclerView1.setLayoutManager(gridLayoutManager);
        adapter1 = new SchoolLastAdapter(schoolNewsResultList, getContext().getApplicationContext());
        recyclerView1.setAdapter(adapter1);
    }

    private void getSchoolNews(int page) {

        subscriber = new Subscriber<SchoolNewsData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("ggggg", e.getMessage().toString());
            }

            @Override
            public void onNext(SchoolNewsData schoolNewsData) {
                List<SchoolNewsResult> list = schoolNewsData.getResults();

                schoolNewsResultList.addAll(list);
                adapter1.notifyDataSetChanged();

            }
        };
        SchoolNewsMethods.getInstance().getSchoolNews(subscriber, page);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    //加载逻辑
    private void loadMore() {
        id_rl_loading.setVisibility(View.VISIBLE);
        id_pull_to_refresh_loadmore_text.setText(loading_Load_More);
        id_pull_to_refresh_loadmore_text.setClickable(false);
        id_pull_to_refresh_load_progress.setVisibility(View.VISIBLE);
        isLoading = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }, 3 * 1000);
    }

    //模拟加载数据
    private void loadData() {
        isLoading = false;
        Log.i("XXX", "loadData");
        temp_data_count_page=1;
        if (temp_data_count_page < data_count_page_all) {//模拟加载完成了

            page++;
            urlString="http://www16.zzu.edu.cn/msgs/vmsgisapi.dll/vmsglist?mtype=m&lan=101,102,103&tts=&tops=&pn="+page;
            init(urlString);

            temp_data_count_page++;
            id_pull_to_refresh_loadmore_text.setText(nowNormalText);
            isComp = false;
            id_pull_to_refresh_loadmore_text.setClickable(true);
        } else {
            isComp = true;
            id_pull_to_refresh_loadmore_text.setClickable(false);
            id_pull_to_refresh_loadmore_text.setText(comp_Load_More);
        }
        id_pull_to_refresh_load_progress.setVisibility(View.GONE);
        adapter.notifyDataSetChanged();
    }

    private void doConfigLinsenerChange() {

        nowNormalText = pull_Load_More;

        id_pull_to_refresh_loadmore_text.setText(nowNormalText);
    }


    //加载数据
    public void init(String urlString){
        try {
            send(urlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Bundle date=msg.getData();
                byte b[]=date.getByteArray("html");
                try {
                    html=new String(b,"utf-8");
                    // Log.i("--------",html);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                links=getLinks(html,links);
                //Log.i("------links.size:",links.size()+"");
                String []array=new String[links.size()];
                int i=0;
                for(String key:links.keySet()){
                    array[i]=key;
                    i++;
                }
                adapter=new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,array);
                listView.setAdapter(adapter);
            }
        };
    }

    public void send(String urlString) throws IOException {
        URL url = new URL(urlString);
        // 打开连接
        con = url.openConnection();
        new Thread(){
            @Override
            public void run() {
                try {
                    inputStream=con.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;
                outputStream=new ByteArrayOutputStream();
                try {
                    while ((len = inputStream.read(bs)) != -1) {
                        outputStream.write(bs, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte date[]=outputStream.toByteArray();
//                try {
//                    String html=new String(date,"utf-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
                Bundle bundle=new Bundle();
                bundle.putByteArray("html",date);
                //bundle.putString("html",html);
                Message message=new Message();
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }.start();

    }

    public Map<String,String> getLinks(String html,Map<String,String> links){
        Pattern pattern=Pattern.compile("class=\"zzj_5\">(.*)class=\"zzj_4",Pattern.DOTALL);
        Matcher matcher=pattern.matcher(html);
        String doc = null;
        if(matcher.find()){
            doc=matcher.group(1);
        }
        links=new HashMap<String,String>();
        Document doc2= Jsoup.parse(doc);
        Elements hrefs=doc2.select("a[href]");         //获取带有href属性的a标签
        int i=0;
        for(Element link : hrefs){                   //遍历每个链接
            String linkHref=link.attr("href");          //得到href属性的值，即URL地址
            String linkText=link.text();                //获取链接文本
            links.put(linkText, linkHref);
        }
        return links;
    }


}
