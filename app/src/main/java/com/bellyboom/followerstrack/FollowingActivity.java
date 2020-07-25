package com.bellyboom.followerstrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FollowingActivity extends BaseActivity {
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.loading_page)
    RelativeLayout loadingPage;
    private ArrayList<UserEntity> dataList = new ArrayList<>();
    private FollowingAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following);
        ButterKnife.bind(this);
        titleTv.setText(GlobalParams.getInstance().following);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingPage.setVisibility(View.GONE);
            }
        }, 2000);
        if ("Following".equals(GlobalParams.getInstance().following)) {
            dataList.add(new UserEntity("jimmyfallon",R.mipmap.avatar_1,"Jimmy Fallon"));
            dataList.add(new UserEntity("prattprattpratt",R.mipmap.avatar_2,"chris pratt"));
            dataList.add(new UserEntity("justintimberfake",R.mipmap.avatar_3,"Justin TimberFake"));
            dataList.add(new UserEntity("boniver",R.mipmap.avatar_4,"Bon Iver"));
            dataList.add(new UserEntity("patagonia",R.mipmap.avatar_5,"Patagonia"));
            dataList.add(new UserEntity("sistersfrost",R.mipmap.avatar_6,"robin & amy"));
            dataList.add(new UserEntity("ruthielindsey",R.mipmap.avatar_7,"Ruthie Lindsey"));
            dataList.add(new UserEntity("thisislany",R.mipmap.avatar_8,"This is Lany"));
            dataList.add(new UserEntity("goodboy",R.mipmap.avatar_9,"good & boy"));
        } else if ("Followers".equals(GlobalParams.getInstance().following)) {
            dataList.add(new UserEntity("jimmyfallon",R.mipmap.avatar_10,"Jimmy Fallon"));
            dataList.add(new UserEntity("prattprattpratt",R.mipmap.avatar_11,"chris pratt"));
        }else  if ("NotFollowing".equals(GlobalParams.getInstance().following)) {
            dataList.add(new UserEntity("jimmyfallon",R.mipmap.avatar_1,"Jimmy Fallon"));
            dataList.add(new UserEntity("prattprattpratt",R.mipmap.avatar_2,"chris pratt"));
            dataList.add(new UserEntity("justintimberfake",R.mipmap.avatar_3,"Justin TimberFake"));
            dataList.add(new UserEntity("boniver",R.mipmap.avatar_10,"Bon Iver"));
            dataList.add(new UserEntity("patagonia",R.mipmap.avatar_11,"Patagonia"));
            dataList.add(new UserEntity("sistersfrost",R.mipmap.avatar_12,"robin & amy"));
            dataList.add(new UserEntity("ruthielindsey",R.mipmap.avatar_13,"Ruthie Lindsey"));
            dataList.add(new UserEntity("thisislany",R.mipmap.avatar_14,"This is Lany"));
            dataList.add(new UserEntity("goodboy",R.mipmap.avatar_15,"good & boy"));
        }else  if ("NotFollowers".equals(GlobalParams.getInstance().following)) {
            dataList.add(new UserEntity("sistersfrost",R.mipmap.avatar_12,"robin & amy"));
            dataList.add(new UserEntity("ruthielindsey",R.mipmap.avatar_13,"Ruthie Lindsey"));
            dataList.add(new UserEntity("thisislany",R.mipmap.avatar_14,"This is Lany"));
            dataList.add(new UserEntity("goodboy",R.mipmap.avatar_15,"good & boy"));
        }else if ("Blocking".equals(GlobalParams.getInstance().following)) {
            dataList.add(new UserEntity("jimmyfallon",R.mipmap.avatar_16,"Jimmy Fallon"));
            dataList.add(new UserEntity("prattprattpratt",R.mipmap.avatar_17,"chris pratt"));
            dataList.add(new UserEntity("justintimberfake",R.mipmap.avatar_3,"Justin TimberFake"));
            dataList.add(new UserEntity("boniver",R.mipmap.avatar_10,"Bon Iver"));
            dataList.add(new UserEntity("patagonia",R.mipmap.avatar_11,"Patagonia"));
            dataList.add(new UserEntity("sistersfrost",R.mipmap.avatar_12,"robin & amy"));
            dataList.add(new UserEntity("ruthielindsey",R.mipmap.avatar_13,"Ruthie Lindsey"));
            dataList.add(new UserEntity("thisislany",R.mipmap.avatar_14,"This is Lany"));
            dataList.add(new UserEntity("goodboy",R.mipmap.avatar_15,"good & boy"));
        }
        Collections.shuffle(dataList);
        mAdapter = new FollowingAdapter(this,R.layout.item_following_layout,dataList,GlobalParams.getInstance().following);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @OnClick(R.id.back_btn)
    public void onClick() {
        finish();
    }
}
