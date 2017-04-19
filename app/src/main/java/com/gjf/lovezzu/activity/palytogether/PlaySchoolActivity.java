package com.gjf.lovezzu.activity.palytogether;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.lovezzu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhaox on 2017/4/19.
 */

public class PlaySchoolActivity extends AppCompatActivity {

    @BindView(R.id.school_back)
    ImageView schoolBack;
    @BindView(R.id.play_news_title)
    TextView playNewsTitle;
    @BindView(R.id.play_news_author)
    TextView playNewsAuthor;
    @BindView(R.id.school_news_time)
    TextView schoolNewsTime;
    @BindView(R.id.play_news_subject)
    TextView playNewsSubject;
    @BindView(R.id.school_news_comment_text)
    EditText schoolNewsCommentText;
    @BindView(R.id.school_news_comment)
    LinearLayout schoolNewsComment;
    @BindView(R.id.school_news_share)
    LinearLayout schoolNewsShare;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.play_school);
        ButterKnife.bind(this);
        String text= "<br />新华社美国海湖庄园4月8日电4月6日至7日，国家主席习近平在美国佛罗里达州海湖庄园同美国总统特朗普举行会晤。初次谋面，坦诚相见，两国元首达成重要共识，为新时期中美关系发展指明了方向，推动开启合作共赢新篇章。\n" +
                "\n" +
                "<br />友谊之旅增进互信\n" +
                "\n" +
                "<br />海湖庄园，东临碧波无垠的大西洋，西连水鸟飞旋的沃思湖，蓝天澄净，棕榈摇曳。\n" +
                "\n" +
                "<br />6日下午5时许，习近平主席的车队驶入海湖庄园。18名礼兵列队致敬。主楼门前，中美两国国旗分列两侧。\n" +
                "\n" +
                "<br />习近平主席和夫人彭丽媛走下车来，特朗普总统和夫人梅拉尼娅上前迎接，宾主握手寒暄。\n" +
                "\n" +
                "美国新政府就职不到百日，中美两国元首实现会晤，在两国关系史上写下重要一笔。国际舆论认为，这一安排表明，中美两个大国正积极寻求建设性合作。\n" +
                "\n" +
                "大变动、大调整，当今世界各种不确定性正在增加。中美关系作为世界稳定“压舱石”的作用更加凸显，中美加强合作的必要性和紧迫性进一步上升。\n" +
                "\n" +
                "推动新时期中美关系更好发展，中国展现出大国的战略思考和自信气度。\n" +
                "\n" +
                "去年11月，特朗普当选美国总统后，习近平主席致电祝贺，指出发展长期健康稳定的中美关系，符合两国人民根本利益，也是国际社会普遍期待。\n" +
                "\n" +
                "5天之后，习近平主席同特朗普通电话，指出作为最大的发展中国家、最大的发达国家、世界前两大经济体，中美需要合作和可以合作的事情很多。\n" +
                "\n" +
                "今年2月10日，习近平主席同特朗普第二次通话，强调中美两国发展完全可以相辅相成、相互促进，双方完全能够成为很好的合作伙伴。\n" +
                "\n" +
                "特朗普表示，美中作为合作伙伴，可以通过共同努力，推动双边关系达到历史新高度。他盛情邀请习近平主席到海湖庄园举行会晤。\n" +
                "\n" +
                "白宫随后发表声明，认为这是一次长时间的“极其真诚的”电话交谈。\n" +
                "\n" +
                "不远万里，应邀而至。特朗普总统将习近平主席夫妇请进主客厅。“习爷爷好！彭奶奶好！”特朗普特意安排自己的外孙和外孙女同中国贵宾见面。两个天真可爱的孩子用中文演唱歌曲《茉莉花》并背诵了《三字经》和唐诗。\n" +
                "\n" +
                "习近平主席和夫人彭丽媛热情鼓掌，夸赞他们中文讲得好，还把一份小礼物——一对熊猫毛绒玩具送给孩子。\n" +
                "\n" +
                "中美关系发展史上，元首外交一直扮演着引航指路的角色。领导人建立良好关系举足轻重。\n" +
                "\n" +
                "白宫官员透露，特朗普总统主动邀请习近平主席来海湖庄园，就是希望两人在家庭气氛中尽快熟悉起来。\n" +
                "\n" +
                "国际媒体评论说，这是一次“无脚本”的会晤。从一对一会见到大范围会谈，从家庭茶叙到一同散步，从欢迎晚宴到工作午餐……24个小时中，两国元首数次见面，进行深入友好交流，话题无所不包。仅原定半小时的一对一会见就持续了将近两个小时，两位领导人意犹未尽可见一斑。\n" +
                "\n" +
                "习近平主席表示，我们举行的中美元首会晤是一次匠心独具的安排，这对于中美关系发展具有特殊重要意义。我们将不断巩固发展这样的友好关系，对推动中美关系发展，造福两国和两国人民，造福各国人民，尽到我们的历史责任。\n" +
                "\n" +
                "习近平主席向特朗普发出年内访华邀请，特朗普愉快接受邀请，期待尽快成行。\n" +
                "\n" +
                "“我同习近平主席谈得很好，建立了非凡的友谊。此次会晤取得重要、丰硕成果，有力推动了美中关系向前发展。”特朗普说。\n" +
                "\n" +
                "未来之问 定调定向\n" +
                "\n" +
                "习近平主席向特朗普赠送的一幅书法作品意味深长——\n" +
                "\n" +
                "“九层之台，起于累土；千里之行，始于足下。”\n" +
                "\n" +
                "欢迎晚宴上，习近平主席一番话发人深省，为下一步发展中美关系确定基调、指明方向——\n" +
                "\n" +
                "“中国有句话说，万丈高楼平地起。我愿同总统先生一道，带领两国对发展中美关系抱有良好愿望和热情的建设者，把中美关系的大厦一层一层建设好，使之更牢、更高、更美。”\n" +
                "\n" +
                "45年前，中美重启交往大门。45年来，中美关系不断发展。\n" +
                "\n" +
                "习近平主席说：“中美关系今后45年如何发展？需要我们深思，也需要两国领导人作出政治决断，拿出历史担当。”\n" +
                "\n" +
                "美国媒体对习近平主席提出的“未来之问”迅速作出评价：西方人只考虑眼前一两年，最长不过5年。而中国人的维度是50年、100年、甚至200年。\n" +
                "\n" +
                "历史经验告诉我们，中美关系发展从来不是一帆风顺，平稳中有波折、前进中有迂回。在新起点上推动中美关系取得更大发展，尤需“一层一层建设好”的耐心与担当。\n" +
                "\n" +
                "“我们有一千个理由把中美关系搞好，没有一条理由把中美关系搞坏。”习近平主席朴素的话语中蕴含着深刻哲理。\n" +
                "\n" +
                "7日上午，两国元首举行第二场正式会晤。习近平主席向特朗普介绍了中国发展理念，强调中国坚定不移走和平发展道路，不奉行你输我赢的理念，不走国强必霸的老路。\n" +
                "\n" +
                "面对新形势，中美只有合作才能共赢。\n" +
                "\n" +
                "看两国发展——中国，正在为实现“两个一百年”奋斗目标，实现中华民族伟大复兴的中国梦奋力前行；美国，处在历史的十字路口，特朗普总统正致力于使“美国更加伟大”。中美两国都希望发展，也都需要有利于发展的国际环境。\n" +
                "\n" +
                "看国际大势——乱变交织的世界，面对变革的关键当口。逆全球化暗流涌动，不确定性侵扰人心。作为世界前两大经济体、安理会常任理事国，中美肩负着应对全球性问题的责任。\n" +
                "\n" +
                "为深化友好合作而来，为世界人民福祉而来。海湖庄园会晤成果超出预期，向世界表明了中美关系向前发展的正确方向。\n" +
                "\n" +
                "合作之路 通向未来\n" +
                "\n" +
                "清风拂面，草木芬芳。7日上午，习近平主席同特朗普在海湖庄园主楼前草坪上并肩散步，边走边谈，继续着两国友好合作的话题。\n" +
                "\n" +
                "此前举行的大范围会谈进行了整整一个小时。从双边关系到重大国际及地区问题，坦诚交流、不避分歧，探寻共识、拓展合作。\n" +
                "\n" +
                "合作，是中美关系的大局，是两国唯一正确的选择。既要高瞻远瞩，也需脚踏实地。\n" +
                "\n" +
                "习近平主席对特朗普说：我们愿意在相互尊重和互利互惠的基础上，拓展务实合作，以建设性方式处理分歧和敏感问题，让两国人民从中美关系发展中有更多获得感。\n" +
                "\n" +
                "特朗普回应：美中两国作为世界大国责任重大。双方应该就重要问题保持沟通和协调，可以共同办成一些大事。\n" +
                "\n" +
                "——为合作，建立更加稳定化的机制安排。\n" +
                "\n" +
                "两国元首确认，要充分用好全面经济、外交安全、执法及网络安全、社会和人文等四个新建的对话合作机制，继续加强在经贸、两军、人文等各领域合作。元首会晤期间，全面经济对话、外交安全对话机制率先同步启动。\n" +
                "\n" +
                "——为合作，确定重点领域实现早期收获。\n" +
                "\n" +
                "会晤中，习近平主席强调，推进双边投资协定谈判，推动双向贸易和投资健康发展，探讨开展基础设施建设、能源等领域务实合作。中美要做大合作蛋糕，制定重点合作清单，争取多些早期收获。\n" +
                "\n" +
                "——为合作，加强在重大国际和地区问题上的沟通协调。\n" +
                "\n" +
                "习近平主席深刻指出，中美双方要为促进世界和平、稳定、繁荣尽到我们的历史责任。从共同推动有关地区热点问题妥善处理解决，到拓展在防扩散、打击跨国犯罪等全球性挑战上的合作，再到加强在联合国、二十国集团、亚太经合组织等多边机制内的沟通和协调，中美合作展现出深远的世界意义。\n" +
                "\n" +
                "海湖庄园会晤，掀开中美关系新的一页。\n" +
                "\n" +
                "原标题：把中美关系的大厦建设得更牢、更高、更美 ——记习近平主席赴美国佛罗里达州海湖庄园同特朗普总统举行中美元首会晤";
        playNewsSubject.setText(Html.fromHtml(text));
    }

    @OnClick(R.id.school_back)
    public void onViewClicked() {
        Intent intent =new Intent(this,PlayTogetherActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick({R.id.school_news_comment, R.id.school_news_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.school_news_comment:
                //提交评论
                Toast.makeText(this,"提交评论",Toast.LENGTH_SHORT).show();
                break;
            case R.id.school_news_share:
                Toast.makeText(this,"分享",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
