package com.hzq.replugindemo;

import com.hzq.replugindemo.action.TestRouterAction1;
import com.hzq.replugindemo.action.TestRouterAction2;
import com.hzq.router.provider.RouterProvider;

/**
 * Created by hezhiqiang on 2017/12/6.
 */

public class HostRouterProvider extends RouterProvider {
    @Override
    public void registerActions() {
        registerAction("hostAction1",new TestRouterAction1());
        registerAction("hostAction2",new TestRouterAction2());
    }
}
