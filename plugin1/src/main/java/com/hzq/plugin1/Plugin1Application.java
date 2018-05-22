package com.hzq.plugin1;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.hzq.router.RouterManager;
import com.qihoo360.replugin.RePlugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hezhiqiang on 2017/12/7.
 */

public class Plugin1Application extends Application {

    private static final String TAG = "Plugin1Application";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("xxxPlugin1Application","我是插件中的Application onCreate");

        RouterManager routerManager = null;
        Context hostContext = RePlugin.getHostContext();
        Class<? extends Context> aClass = hostContext.getClass();
        try {
            Method method = aClass.getDeclaredMethod("getRouterManager1");
            routerManager = (RouterManager) method.invoke(RePlugin.getHostContext());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        HostUtils.getInstance().setRouterManager(routerManager);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d("xxxPlugin1Application","我是插件中的Application attachBaseContext");
    }



    //不会执行
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d("xxxPlugin1Application","我是插件中的Application onTerminate");
    }
}
