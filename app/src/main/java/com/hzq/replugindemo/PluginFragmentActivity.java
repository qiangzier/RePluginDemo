package com.hzq.replugindemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qihoo360.replugin.RePlugin;

/**
 * 打开插件中的Fragment
 * Created by hezhiqiang on 2017/12/6.
 */

public class PluginFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 注意：
         *
         * 如果一个插件是内置插件，那么这个插件的名字就是文件的前缀，比如：demo1.jar插件的名字就是demo1(host-gradle插件自动生成)，可以执行诸如RePlugin.fetchClassLoader("demo1")的操作；
         * 如果一个插件是外置插件，通过RePlugin.install("/sdcard/demo1.apk")安装的，则必须动态获取这个插件的名字来使用：
         * PluginInfo pluginInfo = RePlugin.install("/sdcard/demo1.apk");
         * RePlugin.preload(pluginInfo);//耗时
         * String name = pluginInfo != null ? pluginInfo.getName() : null;
         * ClassLoader classLoader = RePlugin.fetchClassLoader(name);
         */

        String classname = getIntent().getStringExtra("classname");

        boolean isBuiltIn = false;
        String pluginName = isBuiltIn ? "plugin1" : "com.hzq.plugin1";

        //注册相关Fragment的类
        //注册一个全局Hook用于拦截系统对XX类的寻找定向到Demo1中的XX类主要是用于在xml中可以直接使用插件中的类
//        RePlugin.registerHookingClass("com.qihoo360.replugin.sample.demo1.fragment.DemoFragment", RePlugin.createComponentName(pluginName, "com.qihoo360.replugin.sample.demo1.fragment.DemoFragment"), null);
        setContentView(R.layout.activity_plugin_fragment);

        //解决直接获取插件Fragment时 插件的Context为null的问题
        RePlugin.fetchContext("plugin1");
        getSupportFragmentManager().beginTransaction().add(R.id.container2, new V4FragmentContainer()).commit();//添加Fragment到UI
        //代码使用插件Fragment
//        ClassLoader d1ClassLoader = RePlugin.fetchClassLoader(pluginName);//获取插件的ClassLoader
//        try {
//            if(TextUtils.isEmpty(classname))
//                classname = "com.hzq.plugin1.BaseFragment";
//            Object obj = d1ClassLoader.loadClass(classname).newInstance();//使用插件的Classloader获取指定Fragment实例
//            if(obj instanceof Fragment) {
//                Fragment fragment = (Fragment) obj;
//                getFragmentManager().beginTransaction().add(R.id.container2, fragment).commit();//添加Fragment到UI
//            }
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }

}
