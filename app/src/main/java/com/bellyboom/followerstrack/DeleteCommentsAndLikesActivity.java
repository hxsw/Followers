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

public class DeleteCommentsAndLikesActivity extends BaseActivity {
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.loading_page)
    RelativeLayout loadingPage;
    private ArrayList<UserEntity> dataList = new ArrayList<>();
    private DeletedCommentsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_comments_and_likes);
        ButterKnife.bind(this);
        titleTv.setText("Deleted Comments/Likes");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingPage.setVisibility(View.GONE);
            }
        }, 2000);
        dataList.add(new UserEntity("jimmyfallon",R.mipmap.avatar_1,"Jimmy Fallon",10));
        dataList.add(new UserEntity("prattprattpratt",R.mipmap.avatar_2,"chris pratt",5));
        dataList.add(new UserEntity("justintimberfake",R.mipmap.avatar_3,"Justin TimberFake",15));
        dataList.add(new UserEntity("boniver",R.mipmap.avatar_4,"Bon Iver",35));
        dataList.add(new UserEntity("patagonia",R.mipmap.avatar_5,"Patagonia",20));
        dataList.add(new UserEntity("sistersfrost",R.mipmap.avatar_6,"robin & amy",3));
        dataList.add(new UserEntity("ruthielindsey",R.mipmap.avatar_7,"Ruthie Lindsey",9));
        dataList.add(new UserEntity("thisislany",R.mipmap.avatar_8,"This is Lany",7));
        dataList.add(new UserEntity("goodboy",R.mipmap.avatar_9,"good & boy",12));
        Collections.shuffle(dataList);
        mAdapter = new DeletedCommentsAdapter(R.layout.item_deleted_comments_layout,dataList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @OnClick(R.id.back_btn)
    public void onClick() {
        finish();
    }
}
