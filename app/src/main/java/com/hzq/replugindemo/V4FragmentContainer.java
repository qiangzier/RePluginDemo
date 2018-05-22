package com.hzq.replugindemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qihoo360.replugin.RePlugin;

/**
 * 将android.app.Fragment 转成 v4.app.Fragment
 * Created by hezhiqiang on 2017/12/6.
 */

public class V4FragmentContainer extends Fragment {

    public V4FragmentContainer() {
    }

    private static final String TAG = "DemoFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        /**
         * 需要注意不能使用inflater及container因为他们的Context是宿主的
         */
        View view= inflater.inflate(R.layout.activity_plugin_fragment1, container, false);
        ClassLoader d1ClassLoader = RePlugin.fetchClassLoader("com.hzq.plugin1");//获取插件的ClassLoader
        try {
            String  classname = "com.hzq.plugin1.BaseFragment";
            Object obj = d1ClassLoader.loadClass(classname).newInstance();//使用插件的Classloader获取指定Fragment实例
            getActivity().getFragmentManager().beginTransaction().add(R.id.container3, (android.app.Fragment) obj).commit();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return view;
    }
}
