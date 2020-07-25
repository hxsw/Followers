package com.bellyboom.followerstrack;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.umeng.commonsdk.UMConfigure;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        UMConfigure.init(this,"5ecfc752dbc2ec081c04d388","google",UMConfigure.DEVICE_TYPE_PHONE,"");
    }
}
