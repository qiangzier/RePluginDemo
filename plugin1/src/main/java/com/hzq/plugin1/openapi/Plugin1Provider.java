package com.hzq.plugin1.openapi;

import com.hzq.router.provider.RouterProvider;

/**
 * Created by hezhiqiang on 2017/12/7.
 */

public class Plugin1Provider extends RouterProvider {
    @Override
    public void registerActions() {
        registerAction("startService",new Plugin1StartServiceAction());
        registerAction("stopService",new Plugin1StopServiceAction());
    }
}
