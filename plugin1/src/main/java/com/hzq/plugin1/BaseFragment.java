package com.hzq.plugin1;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qihoo360.replugin.RePlugin;

/**
 * Created by hezhiqiang on 2017/12/6.
 */

public class BaseFragment extends Fragment {

    public BaseFragment() {
    }

    private static final String TAG = "DemoFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        /**
         * 需要注意不能使用inflater及container因为他们的Context是宿主的
         */
        return LayoutInflater.from(RePlugin.getPluginContext()).inflate(R.layout.plugin_fragment, container, false);
    }
}
