package com.hzq.plugin1.openapi;

import android.app.Application;

import com.hzq.plugin1.openapi.Plugin1Provider;
import com.hzq.router.RouterApplicationLogic;
import com.hzq.router.RouterManager;

/**
 * Created by hezhiqiang on 2017/12/7.
 */

public class Plugin1ApplicationLogic extends RouterApplicationLogic {

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        RouterManager.getInstance().registerProvider("plugin1",new Plugin1Provider());
    }
}
