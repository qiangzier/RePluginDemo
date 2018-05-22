package com.hzq.plugin1.openapi;

import android.content.Context;
import android.util.Log;

import com.hzq.router.action.RouterAction;
import com.hzq.router.action.RouterResult;

import java.util.HashMap;

/**
 * Created by hezhiqiang on 2017/12/7.
 */

public class Plugin1StopServiceAction extends RouterAction {
    @Override
    public RouterResult invoke(Context context, HashMap<String, String> hashMap) {
        Log.d("RouterAction","stop service success...");
        return null;
    }
}
