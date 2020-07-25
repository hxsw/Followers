package com.bellyboom.followerstrack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.avatar_img)
    CircleImageView avatarImg;
    @BindView(R.id.name_tv)
    TextView nameTv;
    @BindView(R.id.follower_num_tv)
    TextView followerTv;
    @BindView(R.id.following_num_tv)
    TextView followingTv;
    @BindView(R.id.new_followers_tv)
    TextView newFollowersTv;
    @BindView(R.id.have_unfollowed_tv)
    TextView haveUnfollowedTv;
    @BindView(R.id.are_not_following_tv)
    TextView areNotFollowingTv;
    @BindView(R.id.you_are_not_following_tv)
    TextView youAreNotFollowingTv;
    @BindView(R.id.blocking_me_tv)
    TextView blockingMeTv;
    @BindView(R.id.deleted_comments_tv)
    TextView deletedCommentsTv;
    @BindView(R.id.involvement_pack_tv)
    TextView involvementTv;
    @BindView(R.id.perception_pack_tv)
    TextView perceptionPackTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (isLogin()) {
           followerTv.setText(String.format("Followers (%d)",58));
           followingTv.setText(String.format("Following (%d)",118));
           newFollowersTv.setText(String.format("%d",2));
           haveUnfollowedTv.setText(String.format("%d",9));
           areNotFollowingTv.setText(String.format("%d",4));
           youAreNotFollowingTv.setText(String.format("%d",7));
           blockingMeTv.setText(String.format("%d",5));
           deletedCommentsTv.setText(String.format("%d",3));
           involvementTv.setText(String.format("%d",36));
           perceptionPackTv.setText(String.format("%d",39));
           nameTv.setText("Logged");
           loginBtn.setText("Exit");
        }
    }

    @OnClick({R.id.login_btn,R.id.new_followers_rl,R.id.have_unfollowed_rl,R.id.are_not_following_rl,
    R.id.you_are_not_following_rl,R.id.blocking_me_rl,R.id.deleted_comments_rl,R.id.involvement_pack_rl,
    R.id.perception_pack_rl})
    public void onClick(View view){
        Log.e(TAG, "onClick: "+view.getId());
        if (!isLogin()) {
            ActivityUtils.startActivity(LoginActivity.class);
            return;
        }
        switch (view.getId()) {
            case R.id.login_btn:
                new AlertDialog.Builder(this).setTitle("Tips")
                        .setMessage("Are You Sure To Exit?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SPUtils.getInstance().put(GlobalParams.KYE_IST_LOGIN,false);
                                reset();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;
            case R.id.new_followers_rl:
                GlobalParams.getInstance().following = "Followers";
                ActivityUtils.startActivity(FollowingActivity.class);
                break;
            case R.id.have_unfollowed_rl:
                GlobalParams.getInstance().following = "Following";
                ActivityUtils.startActivity(FollowingActivity.class);
                break;
            case R.id.are_not_following_rl:
                GlobalParams.getInstance().following = "NotFollowing";
                ActivityUtils.startActivity(FollowingActivity.class);
                break;
            case R.id.you_are_not_following_rl:
                GlobalParams.getInstance().following = "NotFollowers";
                ActivityUtils.startActivity(FollowingActivity.class);
                break;
            case R.id.blocking_me_rl:
                GlobalParams.getInstance().following = "Blocking";
                ActivityUtils.startActivity(FollowingActivity.class);
                break;
            case R.id.deleted_comments_rl:
                ActivityUtils.startActivity(DeleteCommentsAndLikesActivity.class);
                break;
            case R.id.involvement_pack_rl:
                ActivityUtils.startActivity(InvolvementActivity.class);
                break;
            case R.id.perception_pack_rl:
                ActivityUtils.startActivity(PerceptionPackActivity.class);
                break;
        }
    }

    private void reset() {
        followerTv.setText(String.format("Followers (%d)",0));
        followingTv.setText(String.format("Following (%d)",0));
        newFollowersTv.setText(String.format("%d",0));
        haveUnfollowedTv.setText(String.format("%d",0));
        areNotFollowingTv.setText(String.format("%d",0));
        youAreNotFollowingTv.setText(String.format("%d",0));
        blockingMeTv.setText(String.format("%d",0));
        deletedCommentsTv.setText(String.format("%d",0));
        involvementTv.setText(String.format("%d",0));
        perceptionPackTv.setText(String.format("%d",0));
        nameTv.setText("Not Logged in");
        loginBtn.setText("Login");
    }
}
