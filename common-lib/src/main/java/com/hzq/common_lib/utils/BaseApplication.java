package com.hzq.common_lib.utils;

import android.app.Application;

import com.hzq.router.RouterManager;

/**
 * Created by hezhiqiang on 2017/12/7.
 */

public abstract class BaseApplication extends Application{

    public RouterManager getRouterManager() {
        return RouterManager.getInstance();
    }
}
