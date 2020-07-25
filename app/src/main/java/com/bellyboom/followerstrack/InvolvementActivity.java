package com.bellyboom.followerstrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InvolvementActivity extends BaseActivity {
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.likes_to_me_tv)
    TextView likesToMeTv;
    @BindView(R.id.comments_to_me_tv)
    TextView commentsToMeTv;
    @BindView(R.id.comments_and_likes_to_me_tv)
    TextView commentsAndLikesToMeTv;
    @BindView(R.id.least_likes_to_me_tv)
    TextView leastLikesToMeTv;
    @BindView(R.id.least_comments_to_me_tv)
    TextView leastCommentsToMeTv;
    @BindView(R.id.no_comments_or_likes_to_me_tv)
    TextView noCommentsLikesToMeTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_involvement);
        ButterKnife.bind(this);
        titleTv.setText("Involvement");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                likesToMeTv.setText("3");
                commentsToMeTv.setText("9");
                commentsAndLikesToMeTv.setText("5");
                leastLikesToMeTv.setText("7");
                leastCommentsToMeTv.setText("11");
                noCommentsLikesToMeTv.setText("1");
            }
        }, 1500);
    }

    @OnClick(R.id.back_btn)
    public void onClick() {
        finish();
    }

    @OnClick({R.id.likes_to_me_rl, R.id.comments_to_me_rl, R.id.comments_and_likes_to_me_rl,
            R.id.least_likes_to_me_rl, R.id.least_comments_to_me_rl, R.id.no_comments_or_likes_to_me_rl})
    public void onItemClick(View view) {

    }
}
