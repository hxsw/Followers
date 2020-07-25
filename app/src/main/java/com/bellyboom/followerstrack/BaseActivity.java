package com.bellyboom.followerstrack;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.SPUtils;
import com.umeng.analytics.MobclickAgent;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected boolean isLogin() {
        boolean isLogin = SPUtils.getInstance().getBoolean(GlobalParams.KYE_IST_LOGIN);
        return isLogin;
    }
}
