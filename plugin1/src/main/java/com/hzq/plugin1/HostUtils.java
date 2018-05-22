package com.hzq.plugin1;

import com.hzq.plugin1.openapi.Plugin1Provider;
import com.hzq.router.RouterManager;

/**
 * Created by hezhiqiang on 2017/12/7.
 */

public class HostUtils {

    public HostUtils() {
    }

    public static HostUtils getInstance() {
        return Holde.Instance;
    }

    public static class Holde {
        public static HostUtils Instance = new HostUtils();
    }

    private RouterManager routerManager;

    public void setRouterManager(RouterManager routerManager) {
        this.routerManager = routerManager;
        setProvider();
    }

    private void setProvider() {
        if(routerManager != null)
            routerManager.registerProvider("plugin1",new Plugin1Provider());
    }

    public RouterManager getRouterManager() {
        return routerManager;
    }
}
