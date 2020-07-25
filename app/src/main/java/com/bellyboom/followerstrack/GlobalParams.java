package com.bellyboom.followerstrack;

public class GlobalParams {
    public static final String KYE_IST_LOGIN = "key_is_login";
    private static GlobalParams mInstance;
    private GlobalParams(){

    }
    public static GlobalParams getInstance() {
        if (mInstance == null) {
            mInstance = new GlobalParams();
        }
        return mInstance;
    }

    public String following;
}
