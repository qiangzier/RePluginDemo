package com.hzq.replugindemo.action;

import android.content.Context;
import android.widget.Toast;

import com.hzq.router.action.RouterAction;
import com.hzq.router.action.RouterResult;

import java.util.HashMap;

/**
 * Created by hezhiqiang on 2017/12/6.
 */

public class TestRouterAction2 extends RouterAction {
    @Override
    public RouterResult invoke(Context context, HashMap<String, String> requestData) {
        Toast.makeText(context, "host Action2", Toast.LENGTH_SHORT).show();
        return null;
    }
}
