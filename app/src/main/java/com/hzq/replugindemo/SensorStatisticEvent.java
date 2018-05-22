package com.hzq.replugindemo;

import android.content.Context;
import android.util.Log;

/**
 * Created by hezhiqiang on 2017/12/7.
 */

public class SensorStatisticEvent {
    public void click_recommend_course(Context context, String lcs_id, String lcs_name, String course_name, int order_id) {
        Log.d("xxxSensorStatisticEvent","lcs_id = "+lcs_id);
    }
}
