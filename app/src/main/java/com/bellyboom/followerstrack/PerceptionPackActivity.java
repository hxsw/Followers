package com.bellyboom.followerstrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PerceptionPackActivity extends AppCompatActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.near_me_tv)
    TextView nearMeTv;
    @BindView(R.id.far_from_me_tv)
    TextView farFromMeTv;
    @BindView(R.id.i_like_not_follow_me_tv)
    TextView iLikeNotFollowMeTv;
    @BindView(R.id.secret_admire_tv)
    TextView secretAdmireTv;
    @BindView(R.id.oldest_instagram_tv)
    TextView oldestInstagramTv;
    @BindView(R.id.newest_instagram_tv)
    TextView newestInstagramTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perception_pack);
        ButterKnife.bind(this);
        titleTv.setText("Perception");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nearMeTv.setText("5");
                farFromMeTv.setText("12");
                iLikeNotFollowMeTv.setText("11");
                secretAdmireTv.setText("3");
                oldestInstagramTv.setText("7");
                newestInstagramTv.setText("1");
            }
        },1500);
    }

    @OnClick(R.id.back_btn)
    public void onClick() {
        finish();
    }

    @OnClick({R.id.near_me_rl, R.id.far_from_me_rl, R.id.i_like_not_follow_me_rl,
            R.id.secret_admire_rl, R.id.oldest_instagram_rl, R.id.newest_instagram_rl})
    public void onItemClick(View view) {

    }
}
