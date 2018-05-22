package com.hzq.router.action;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by hezhiqiang on 2017/12/6.
 */

public abstract class RouterAction {

    public abstract RouterResult invoke(Context context, HashMap<String,String> requestData);

}
