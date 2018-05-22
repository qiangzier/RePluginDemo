package com.hzq.plugin1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hzq.common_lib.utils.AppUtils;
import com.hzq.router.RouterManager;
import com.hzq.router.RouterRequest;
import com.qihoo360.replugin.RePlugin;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.txt);
        textView.setText("I am Plugin1,My processName = " + AppUtils.getProcessName(this));

        findViewById(R.id.get_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HostUtils.getInstance().getRouterManager().router(getApplication(),
                        new RouterRequest.Builder("host","hostAction1").build());
            }
        });

        Log.d("xxxPlugin1MainActivity", RouterManager.getInstance().toString());

        click_recommend_course(RePlugin.getHostContext(),"111","12","323",1);
    }

    public void click_recommend_course(Context context, String lcs_id, String lcs_name, String course_name, int order_id) {
        Class cl = RePlugin.getHostContext().getClass();
        try {
            Field field = cl.getDeclaredField("sensorStatisticEvent");
            Method method= field.get(RePlugin.getHostContext()).getClass().getDeclaredMethod("click_recommend_course",Context.class,String.class,String.class,String.class,int.class);
            method.invoke(field.get(RePlugin.getHostContext()),context,lcs_id,lcs_name,course_name,order_id);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
