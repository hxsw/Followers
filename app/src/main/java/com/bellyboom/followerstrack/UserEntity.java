package com.bellyboom.followerstrack;

public class UserEntity {
    public String name;
    public int avatar;
    public String subName;
    public int deletedCommentsCount;
    public UserEntity() {
    }

    public UserEntity(String name, int avatar, String subName) {
        this.name = name;
        this.avatar = avatar;
        this.subName = subName;
    }

    public UserEntity(String name, int avatar, String subName, int deletedCommentsCount) {
        this.name = name;
        this.avatar = avatar;
        this.subName = subName;
        this.deletedCommentsCount = deletedCommentsCount;
    }
}
