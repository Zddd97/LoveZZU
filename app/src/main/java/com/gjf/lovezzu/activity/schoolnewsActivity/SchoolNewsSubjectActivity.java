package com.gjf.lovezzu.activity.schoolnewsActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.gjf.lovezzu.R;

/**
 * Created by BlackBeard丶 on 2017/04/08.
 */

public class SchoolNewsSubjectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_news);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }

        TextView textView =  (TextView)findViewById(R.id.school_news_subject);
        String hrml = "<h2>\n" +
                "            <span class=\"source\">大众网-生活日报</span> <span class=\"time\">04-08 08:10</span> \n" +
                "            <span class=\"reply js-reply\" data-newsapp=\"tie/CHG2NRQF0001875P\" data-stat=\"o-article-post\" data-channel=\"sps_article\">跟贴 154042 条</span>\n" +
                "          </h2>\n" +
                "        <div class=\"article-digest\"></div></div><div class=\"text\"><p>长清大学城某高校大二男生张亮与该校女生李菲相约吃饭时，将事先准备好的“迷药”混入饮料内，对方饮用后，出现头晕、恶心症状。随后，张亮将李菲带入附近出租房内，在李菲意识不清的状态下，强行与其发生性关系。近日，济南中院对该案作出终审裁定，认定被告人张亮行为构成强奸罪，判处其有期徒刑4年。</p>\n" +
                "            <div class=\"photoNews\">\n" +
                "              <div class=\"photo-wrap\" data-newsapp=\"CHG2NRQF0001875P\" data-channel=\"sps_article\" data-stat=\"open-photo\" data-read=\"open-photo\">\n" +
                "                <img class=\"js-img\" src=\"http://dingyue.nosdn.127.net/tELZqWlGyKVXqFaYonUjS8jdT6fFggeLMHIFJYn3N7QUE1491610101978transferflag.png?imageView&amp;thumbnail=690x10000&amp;quality=75\" data-width=\"400\" data-height=\"284\" width=\"690\" height=\"489\">\n" +
                "                <div class=\"tip\">打开网易新闻 查看更多精彩图片 &gt;</div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          <p><b>吃烧烤自带杯子做手脚</b></p><p>据李菲证言，她于2015年6月底与张亮相识。“他让我当他的女朋友，我没有同意。”7月5日下午，张亮约她到学校附近的一家烧烤店吃饭，张亮以烧烤摊杯子不干净为由，从他包里拿出两个杯子，说去刷一下，偷偷将药倒入其中一杯子，回到座位给李菲倒了一杯果粒橙。“我没喝完就觉得恶心、头晕，他说赶紧走。”随后，李菲就失去了意识。待她稍有意识的时候，发现自己躺在学校附近小区一出租屋里，身边还有同宿舍的王雪及其男友万明。</p><p>王雪称，当天李菲曾电话告知，张亮约她外出吃饭，如果10点前她不回来，就让其打电话给她说辅导员查房。当晚10点，王雪打去电话。“她说在常青藤小区，说话迷迷糊糊，听上去像喝了酒，还让我去陪她。”王雪和男友万明来到住处发现她正躺在床上，王雪将其晃醒，想把她带回宿舍，张亮不同意。最后决定，王雪和李菲住一个房间，张亮和万明再开一个房间。</p>\n" +
                "            <div class=\"photoNews\">\n" +
                "              <img class=\"js-img\" src=\"http://img2.cache.netease.com/3g/2015/11/2/20151102141437e4822.png\" data-echo=\"http://dingyue.nosdn.127.net/QmfXD6Ub5XGd6=Vqc7fSzMSYeRRnBAshaaebDSxIFTKTq1491610101978transferflag.png?imageView&amp;thumbnail=690x10000&amp;quality=75\" data-width=\"600\" data-height=\"323\" width=\"690\" height=\"371\">\n" +
                "              <div class=\"photo_mag\" style=\"display:block;\"></div>\n" +
                "            </div>\n" +
                "          <p><b>竟称花了钱就要发生关系</b></p><p>过了一会，张亮给李菲发微信，要跟她谈谈。李菲称，王雪把她叫醒，告知张亮发微信有话要说，她同意后，又睡了过去。就这样，张亮进入李菲所在房间后，王雪去了其男友的房间。据李菲陈述，当晚，张亮强行与其发生了性关系。而张亮交代，他觉得在李菲身上花了钱，就要跟她发生关系。他在地板上躺了二十几分钟，李菲醒来，见他躺在地上，让他上床，“相互亲吻，后发生了关系。”</p><p>次日早7点左右，王雪给李菲打电话，但直到8点多都无人接听。随后，她去敲门，张亮先走出来，李菲状态仍和昨晚差不多。“她说，可能被下药了，在房间里，他将她裤子脱下发生了性关系。她不同意，当时也喊了。”王雪证实，她看见房间垃圾桶里有两个用过的避孕套。</p><p>张亮说，6日，他送李菲回宿舍，李菲还是头晕，他又去事发小区开了房间。“我还想同她发生性关系，她说不行，我就没有继续。”</p>\n" +
                "            <div class=\"photoNews\">\n" +
                "              <img class=\"js-img\" src=\"http://img2.cache.netease.com/3g/2015/11/2/20151102141437e4822.png\" data-echo=\"http://dingyue.nosdn.127.net/iOPfLW1ChQV2nmDrI9v5IdcShTRD0IQQiJEekRngW60Bj1491610101980transferflag.png?imageView&amp;thumbnail=690x10000&amp;quality=75\" data-width=\"450\" data-height=\"257\" width=\"690\" height=\"394\">\n" +
                "              <div class=\"photo_mag\" style=\"display:block;\"></div>\n" +
                "            </div>\n" +
                "          <p><b>男方父亲提出赔偿3000元</b></p><p>8日，李菲让姑姑赵梅接走，还到医院做了相关检查。10日，赵梅和丈夫见到了张亮及其家人。赵梅说，在回去路上，张亮父亲给李菲发了一条短信，提出赔偿3000元，李菲拒绝了。</p><p>张亮交代，2015年5月，他加了一个QQ号，对方向其推荐迷药之类的东西。他问对方，有无让女孩吃了睡着的药。得到肯定回答后，他向对方转账50元，买了一瓶白色粉末，用于作案。</p><p>一审宣判后，原审被告人张亮提出上诉，认为与李菲强行发生性关系的事实不清，证据不足。且系初犯、偶犯，原审量刑过重。济南中院二审依法查明，被告人张亮行为已构成强奸罪。驳回上诉，维持原判。(文中当事人均为化名)</p>\n" +
                "          <div class=\"m-special-info\">\n" +
                "            <div class=\"header\">\n" +
                "              推荐\n" +
                "            </div>\n" +
                "            <div class=\"content\">\n" +
                "              <a target=\"_self\" href=\"http://news.163.com/17/0328/09/CGJRUDBK0001875P.html\"><br>女子和网友去KTV唱歌 遭对方下药后带至宾馆迷奸<br></a><br>一名男子利用网络交友，趁女方不备下迷药实施强奸，最终该男子的这种行为受到法律的严惩。<br>3月20日下午6点左右，安阳市公安局北关分局接到了一个报警电话，受害人的亲属称受害人可能被人下了迷药。\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        <p></p><p>原标题：惊！济南某高校大二男生竟购迷药强奸女同学！吃饭时自带杯子做手脚！</p>\n" +
                "        <div style=\"display: none !important;\"><a href=\"https://c.m.163.com/news/a/CHB6T8SS00018AOR.html\">儿子强奸度假村服务员 其母协助被害人报警</a><a href=\"https://c.m.163.com/news/a/CHBAMTKK00267VA9.html\">女子聚会醉酒遭陌生男子强奸 同一房间室友未听见</a><a href=\"https://c.m.163.com/news/a/CHCPR8P10524ADNS.html\">女生险被强奸左眼失明 残害花季少女嫌疑犯终捉拿归案</a></div>\n" +
                "      </div></article></div>\n" +
                "    <div class=\"m-more\" data-stat=\"docid-all\">\n" +
                "      <span class=\"js-all-article\">展开全文</span>\n" +
                "    </div>\n" +
                "  <div class=\"js-reply-count\" style=\"display:none\">154042</div><div class=\"m-comment\" style=\"display: block;\">\n" +
                "      <div class=\"u-title\"> 热门跟贴 </div>\n" +
                "      <div class=\"comment-list\">\n" +
                "        <div class=\"u-item\">\n" +
                "          <div class=\"item-title\">\n" +
                "            <div class=\"avatar\"></div>\n" +
                "            <div class=\"name\">广西桂林市[努力啊奋斗]</div>\n" +
                "            <div class=\"ding\">16975顶</div>\n" +
                "          </div>\n" +
                "          <div class=\"comment-content\">\n" +
                "            <div class=\"comment-text\">\n" +
                "              花那么大工夫才两次？太差了\n" +
                "            </div>\n" +
                "          </div>\n" +
                "          <div class=\"comment-more\">更多</div>\n" +
                "        </div>\n" +
                "      \n" +
                "        <div class=\"u-item\">\n" +
                "          <div class=\"item-title\">\n" +
                "            <div class=\"avatar\"></div>\n" +
                "            <div class=\"name\">辽宁省[倒霉孩子]</div>\n" +
                "            <div class=\"ding\">12707顶</div>\n" +
                "          </div>\n" +
                "          <div class=\"comment-content\">\n" +
                "            <div class=\"comment-text\">\n" +
                "              卖药的良心啊，竟然是真药\uD83D\uDC8A\n" +
                "            </div>\n" +
                "          </div>\n" +
                "          <div class=\"comment-more\">更多</div>\n" +
                "        </div>\n" +
                "      \n" +
                "        <div class=\"u-item\">\n" +
                "          <div class=\"item-title\">\n" +
                "            <div class=\"avatar\"></div>\n" +
                "            <div class=\"name\">山东省济南市手机网友</div>\n" +
                "            <div class=\"ding\">10742顶</div>\n" +
                "          </div>\n" +
                "          <div class=\"comment-content\">\n" +
                "            <div class=\"comment-text\">\n" +
                "              花也送了，饭也吃了，酒也喝了，NTM却给我说来大姨妈了。\n" +
                "            </div>\n" +
                "          </div>\n" +
                "          <div class=\"comment-more\">更多</div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "      <div class=\"m-down-tie u-hide-in-newsapp\"><a data-newsapp=\"tie/CHG2NRQF0001875P\" data-stat=\"o-docid-post\" data-read=\"docid-post\" data-channel=\"sps_article\"> 打开网易新闻,查看更多跟贴 <span class=\"replyCount\"> (154042)</span></a></div>\n" +
                "    </div><div class=\"m-ad js-ad\"></div><div class=\"m-hotnews\">\n" +
                "        <div class=\"u-title\">大家都在看</div>\n" +
                "        <div class=\"live-wrap\" data-newsapp=\"VCC0RGN6N\" data-channel=\"sps_article\" data-stat=\"o-big-video\">\n" +
                "          <div class=\"live-title\">这款高跟鞋很搞笑，鞋跟就像鸟儿的嘴巴</div>\n" +
                "          <div class=\"cover-wrap\" data-echo-background=\"//s.cimg.163.com/i/vimg2.ws.126.net/image/snapshot/2017/4/R/O/VCGJG80RO.jpg.658x10000.75.auto.jpg\">\n" +
                "            <span class=\"u-video-icon\"></span>\n" +
                "          </div>\n" +
                "          <div class=\"news-tip-wrap\">\n" +
                "            <div class=\"open-btn\">打开应用查看</div>\n" +
                "            <div class=\"reply\"> 132播放</div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      <ul class=\"news-list\">\n" +
                "            <li class=\"single-img\">\n" +
                "              <a data-newsapp=\"CHG4A6DD0529AIP1\" data-channel=\"sps_article\" data-stat=\"hotNews-0\">\n" +
                "                <img data-echo=\"http://dingyue.nosdn.127.net/04XAfNP8xLXdw=TbE6ENERUjoSpHL3yNo17CK4EqGP3RX1491611764202compressflag.jpg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">库里赛季报销! 重演前队友博古特悲剧, 愿伤病远离联盟</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">11小时前</div>\n" +
                "                    \n" +
                "                    <div class=\"open-btn\">打开应用查看</div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a data-newsapp=\"CHG39OM10529AIP1\" data-channel=\"sps_article\" data-stat=\"hotNews-1\">\n" +
                "                <img data-echo=\"http://dingyue.nosdn.127.net/IbihdGWMHKhlssaMPNxNE4ZEaEpyVxZCumA=MB0JIZeQ71491610673016.jpg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">库里因病赛季报销，一个才好一个又伤，主帅无可奈何认倒霉</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">11小时前</div>\n" +
                "                    \n" +
                "                    <div class=\"open-btn\">打开应用查看</div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a data-newsapp=\"CHFBJUVP0521BN0P\" data-channel=\"sps_article\" data-stat=\"hotNews-2\">\n" +
                "                <img data-echo=\"http://nbot-pub.nosdn.127.net/4fd50a1640db5f659e48b8e9d8c03b13.jpeg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">内涵漫画：我会尽力照顾好嫂子的</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">18小时前</div>\n" +
                "                    \n" +
                "                    <div class=\"open-btn\">打开应用查看</div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHGLT8A904268F03.html?spst=0&amp;abtest=1&amp;target=hotNews-3\" data-channel=\"sps_article\" data-stat=\"hotNews-3\">\n" +
                "                <img data-echo=\"http://cms-bucket.nosdn.127.net/6f21b9cd76474813b79357c92820b16720170408134551.jpeg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">绵阳一男子脚踏两只船 两女友识破后联手报复</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">6小时前</div>\n" +
                "                    <div class=\"news-tip\"> 130跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHFCF7PI9001F7PJ.html?spst=0&amp;abtest=1&amp;target=hotNews-4\" data-channel=\"sps_article\" data-stat=\"hotNews-4\">\n" +
                "                <img data-echo=\"http://crawl.nosdn.127.net/nbotreplaceimg/49dc115816087eac67b3eab55e507b87/2227aee512bc15a52dd5f39a5922e852.jpg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">新疆队夺冠之后，两队都忽略了一件事，布泽尔超级尴尬</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">21小时前</div>\n" +
                "                    <div class=\"news-tip\"> 4581跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHGRKRPL051781T5.html?spst=0&amp;abtest=1&amp;target=hotNews-5\" data-channel=\"sps_article\" data-stat=\"hotNews-5\">\n" +
                "                <img data-echo=\"http://dingyue.nosdn.127.net/ZFe0eetclMw9I8t2jp8tqHWFYvX6XQ9nEtCPiqirw7UPn1491636337720compressflag.jpg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">为什么说郑西坡父子为《人民的名义》挽留了最后的尊严</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">4小时前</div>\n" +
                "                    <div class=\"news-tip\"> 506跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHEQHTLS0515AG8N.html?spst=0&amp;abtest=1&amp;target=hotNews-6\" data-channel=\"sps_article\" data-stat=\"hotNews-6\">\n" +
                "                <img data-echo=\"http://dingyue.nosdn.127.net/jIZjWBOPUpdsBfo8MMCm=zc0Txy=dSO6LR7EazLag8mGK1491568034572compressflag.jpg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">海贼王：尾田已埋下伏笔，鹰眼即将被杀死，索隆替师报仇</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">23小时前</div>\n" +
                "                    <div class=\"news-tip\"> 844跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHGF6D3S000887BT.html?spst=0&amp;abtest=1&amp;target=hotNews-7\" data-channel=\"sps_article\" data-stat=\"hotNews-7\">\n" +
                "                <img data-echo=\"http://cms-bucket.nosdn.127.net/b8f19e135af1496d8a1f6660f205aed920170408114822.jpeg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">每日易乐:姑娘文明点要上车就别拽头发 撕逼啊</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">7小时前</div>\n" +
                "                    <div class=\"news-tip\"> 8156跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHG5FIJ30525ABIO.html?spst=0&amp;abtest=1&amp;target=hotNews-8\" data-channel=\"sps_article\" data-stat=\"hotNews-8\">\n" +
                "                <img data-echo=\"http://dingyue.nosdn.127.net/t73zcZm=k=7KU7cSJOgncSxiV9bGNFZEQMUS8nhpha7KV1491612717200.jpg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">这组图每张都有亮点！但能找到的人却没几个</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">10小时前</div>\n" +
                "                    <div class=\"news-tip\"> 559跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHEPB2M705129QAF.html?spst=0&amp;abtest=1&amp;target=hotNews-9\" data-channel=\"sps_article\" data-stat=\"hotNews-9\" data-read=\"hotNews9\">\n" +
                "                <img data-echo=\"http://nbot-pub.nosdn.127.net/c6b2f1891e511aa83e000fc0cfcdd37e.jpg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">东莞有人中了1526万，他拿钱后最想干的事情竟是</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">23小时前</div>\n" +
                "                    <div class=\"news-tip\"> 138跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHGJF9DV04268F03.html?spst=0&amp;abtest=1&amp;target=hotNews-a\" data-channel=\"sps_article\" data-stat=\"hotNews-a\">\n" +
                "                <img data-echo=\"http://cms-bucket.nosdn.127.net/25fdfd131251433290497acf43b3760c20170408130243.png?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">四川广安两女童工地玩耍 误触搅拌机开关一死一伤</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">6小时前</div>\n" +
                "                    <div class=\"news-tip\"> 173跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHGU9JP705269AU1.html?spst=0&amp;abtest=1&amp;target=hotNews-b\" data-channel=\"sps_article\" data-stat=\"hotNews-b\">\n" +
                "                <img data-echo=\"http://dingyue.nosdn.127.net/SPDk5aHrn1otbr9wGuMIDY7YcrofpXj4HW=tKIBcgZimW1491638099921.jpg?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">梦幻西游一把70级简易武器被估价10万 是不是在骗我？</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">3小时前</div>\n" +
                "                    <div class=\"news-tip\"> 136跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHGB9GHN04248E9B.html?spst=0&amp;abtest=1&amp;target=hotNews-c\" data-channel=\"sps_article\" data-stat=\"hotNews-c\">\n" +
                "                <img data-echo=\"http://cms-bucket.nosdn.127.net/catchpic/5/51/517ad816a155a99381f55530818d160f.png?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">\"新加坡旁\"碧桂园停止销售 南京买家退房陷困境</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">9小时前</div>\n" +
                "                    <div class=\"news-tip\"> 819跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHGAIJLG04178D6R.html?spst=0&amp;abtest=1&amp;target=hotNews-d\" data-channel=\"sps_article\" data-stat=\"hotNews-d\">\n" +
                "                <img data-echo=\"http://cms-bucket.nosdn.127.net/8b97ba268e524e21a5bd9495e41b16cd20170408102704.png?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">真学霸！深圳女孩同时被12所世界顶尖名校录取</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">9小时前</div>\n" +
                "                    <div class=\"news-tip\"> 1606跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li class=\"single-img\">\n" +
                "              <a href=\"//c.m.163.com/news/a/CHG4B6G404268F03.html?spst=0&amp;abtest=1&amp;target=hotNews-e\" data-channel=\"sps_article\" data-stat=\"hotNews-e\">\n" +
                "                <img data-echo=\"http://cms-bucket.nosdn.127.net/4241d188586a4575936f6ce2fb99773f20170408083822.png?imageView&amp;thumbnail=160x120&amp;quality=75\" src=\"//img1.cache.netease.com/3g/img11/3gtouch13/imglist.png\">\n" +
                "                <div class=\"news-wrap\">\n" +
                "                  <div class=\"news-title\">泸州发生离奇车祸：小型货车仰翻在道路中央</div>\n" +
                "                  <div class=\"news-tip-wrap\">\n" +
                "                    <div class=\"time-pub\">11小时前</div>\n" +
                "                    <div class=\"news-tip\"> 314跟贴</div>\n" +
                "                    \n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </a>\n" +
                "            </li>\n" +
                "          </ul><ul class=\"video-news-wrap\">\n" +
                "          <li class=\"videos-wrap\">\n" +
                "            <a data-newsapp=\"VCC2OAFM7\" data-channel=\"sps_article\" data-stat=\"video1\">\n" +
                "              <div class=\"cover\" data-echo-background=\"//s.cimg.163.com/i/vimg2.ws.126.net/image/snapshot/2017/4/H/S/VCGJG0DHS.jpg.658x10000.75.auto.jpg\">\n" +
                "                <span class=\"u-video-icon\"></span>\n" +
                "                <span class=\"u-tip-icon\">打开网易新闻播放</span>\n" +
                "              </div>\n" +
                "              <div class=\"news-wrap\">\n" +
                "                <div class=\"news-title\">2016中国BeatBox冠军赛，四分之一决赛删青VS牟彬涛</div>\n" +
                "              </div>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "        \n" +
                "          <li class=\"videos-wrap\" data-read=\"last-video\">\n" +
                "            <a data-newsapp=\"VCC2NV5F7\" data-channel=\"sps_article\" data-stat=\"video2\">\n" +
                "              <div class=\"cover\" data-echo-background=\"//s.cimg.163.com/i/vimg2.ws.126.net/image/snapshot/2017/4/H/D/VCGJG45HD.jpg.658x10000.75.auto.jpg\">\n" +
                "                <span class=\"u-video-icon\"></span>\n" +
                "                <span class=\"u-tip-icon\">打开网易新闻播放</span>\n" +
                "              </div>\n" +
                "              <div class=\"news-wrap\">\n" +
                "                <div class=\"news-title\">央视段子手朱广权的即兴表演相声直逼专业相声演员</div>\n" +
                "              </div>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "        </ul><ul class=\"js-video-last u-hide-in-newsapp\">\n" +
                "          <li class=\"videos-wrap\">\n" +
                "            <a data-newsapp=\"VCC0RVKTG\" data-channel=\"sps_article\" data-stat=\"video3\">\n" +
                "              <div class=\"cover\" data-echo-background=\"//s.cimg.163.com/i/vimg2.ws.126.net/image/snapshot/2017/4/K/2/VCGJG4IK2.jpg.658x10000.75.auto.jpg\">\n" +
                "                <span class=\"u-video-icon\"></span>\n" +
                "                <span class=\"u-tip-icon\">打开网易新闻播放</span>\n" +
                "              </div>\n" +
                "              <div class=\"news-wrap\">\n" +
                "                <div class=\"news-title\">北美冰球联赛：鲨鱼vs棕熊第3节</div>\n" +
                "              </div>\n" +
                "            </a>";
        textView.setText(Html.fromHtml(hrml));
    }
}
