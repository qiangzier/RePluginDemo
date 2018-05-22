package com.hzq.router.provider;

import com.hzq.router.action.RouterAction;

import java.util.HashMap;

/**
 * Created by hezhiqiang on 2017/12/6.
 */

public abstract class RouterProvider {
    private HashMap<String,RouterAction> mActions;

    public RouterProvider() {
        mActions = new HashMap<>();
        registerActions();
    }

    public void registerAction(String actionName,RouterAction action) {
        if(!mActions.containsKey(actionName))
            mActions.put(actionName,action);
    }

    public RouterAction findAction(String actionName) {
        return mActions.get(actionName);
    }

    public abstract void registerActions();
}
