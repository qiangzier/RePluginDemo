package com.hzq.router;

import android.app.Application;
import android.content.Context;

import com.hzq.router.action.RouterAction;
import com.hzq.router.provider.RouterProvider;

import java.util.HashMap;

/**
 * Created by hezhiqiang on 2017/12/6.
 */

public class RouterManager {

    public static HashMap<String,RouterProvider> mProviders;

    private static RouterManager sInstance;
    private static Context mContext;

    public RouterManager() {

        mProviders = new HashMap<>();
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static RouterManager getInstance() {
        if(sInstance == null) {
            synchronized (RouterManager.class) {
                if(sInstance == null) {
                    sInstance = new RouterManager();
                }
            }
        }
        return sInstance;
    }

    /**
     * 提供一个外部设置
     * @param routerManager
     */
    public static void setRouterManager(RouterManager routerManager) {
        if(routerManager != null) {
            sInstance = routerManager;
        }
    }

    public void registerProvider(String providerName,RouterProvider provider) {
        if(!mProviders.containsKey(providerName)) {
            mProviders.put(providerName,provider);
        }
    }

    public void router(Context context,RouterRequest routerRequest) {
        RouterProvider routerProvider = mProviders.get(routerRequest.getProvider());
        RouterAction routerAction = routerProvider.findAction(routerRequest.getAction());
        routerAction.invoke(context,routerRequest.getData());
    }

}
