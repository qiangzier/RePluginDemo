package com.hzq.replugindemo;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.hzq.common_lib.utils.BaseApplication;
import com.hzq.router.RouterManager;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginCallbacks;
import com.qihoo360.replugin.RePluginConfig;

/**
 * Created by hezhiqiang on 2017/12/6.
 */

public class HostApplication extends BaseApplication {
    private static final String TAG = "HostApplication";

    /**
     * 子类可以复写此方法来自定义RePluginConfig。请参见 RePluginConfig 的说明
     *
     * @see RePluginConfig
     * @return 新的RePluginConfig对象
     */
    protected RePluginConfig createConfig() {
        RePluginConfig rePluginConfig = new RePluginConfig();
        rePluginConfig.setUseHostClassIfNotFound(true);
        rePluginConfig.setPrintDetailLog(true);
        return rePluginConfig;
    }

    public RouterManager getRouterManager1() {
        return RouterManager.getInstance();
    }

    /**
     * 子类可以复写此方法来自定义RePluginCallbacks。请参见 RePluginCallbacks 的说明 <p>
     * 注意：若在createConfig的RePluginConfig内同时也注册了Callbacks，则以这里创建出来的为准
     *
     * @see RePluginCallbacks
     * @return 新的RePluginCallbacks对象，可以为空
     */
    protected RePluginCallbacks createCallbacks() {
        return null;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        RePluginConfig c = createConfig();
        if (c == null) {
            c = new RePluginConfig();
        }

        RePluginCallbacks cb = createCallbacks();
        if (cb != null) {
            c.setCallbacks(cb);
        }

        RePlugin.App.attachBaseContext(this, c);
    }

    public SensorStatisticEvent sensorStatisticEvent;

    @Override
    public void onCreate() {
        super.onCreate();

        RePlugin.App.onCreate();

        //预加载插件
        RePlugin.preload("plugin1");

//        RouterManager.init(this);
        getRouterManager1().registerProvider("host",new HostRouterProvider());
        Log.d("xxxxBaseApplication","---------------->" + getRouterManager1().toString());
        sensorStatisticEvent = new SensorStatisticEvent();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        // 如果App的minSdkVersion >= 14，该方法可以不调用
        RePlugin.App.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        // 如果App的minSdkVersion >= 14，该方法可以不调用
        RePlugin.App.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // 如果App的minSdkVersion >= 14，该方法可以不调用
        RePlugin.App.onConfigurationChanged(newConfig);
    }
}
