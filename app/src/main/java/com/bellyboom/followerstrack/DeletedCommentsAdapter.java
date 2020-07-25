package com.bellyboom.followerstrack;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DeletedCommentsAdapter extends BaseQuickAdapter<UserEntity, BaseViewHolder> {
    public DeletedCommentsAdapter(int layoutResId, @Nullable List<UserEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, UserEntity userEntity) {
        baseViewHolder.setText(R.id.name_1,userEntity.name)
                .setText(R.id.name_2,userEntity.subName)
                .setImageResource(R.id.avatar_img,
                        userEntity.avatar)
                .setText(R.id.following_tv,"UnFollow")
                .setText(R.id.deleted_comments_tv,String.format("%d comments and likes",userEntity.deletedCommentsCount));
    }
}
