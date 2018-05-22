package com.hzq.common_lib.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by hezhiqiang on 2017/12/6.
 */

public class AppUtils {

    public static String getProcessName(Context context){
        int pid = android.os.Process.myPid(); //获取进程pid
        String processName = "";
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);//获取系统AM服务
        for (ActivityManager.RunningAppProcessInfo processInfo : am.getRunningAppProcesses()) {
            if(processInfo.pid == pid) {
                processName = processInfo.processName;
                break;
            }
        }
        return processName;
    }
}
