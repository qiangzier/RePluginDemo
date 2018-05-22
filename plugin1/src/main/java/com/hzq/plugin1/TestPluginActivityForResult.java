package com.hzq.plugin1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;


/**
 * Created by hezhiqiang on 2017/12/6.
 */

public class TestPluginActivityForResult extends FragmentActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin_forresult);
        editText = (EditText) findViewById(R.id.edt);
    }

    public void back(View view) {
        Intent intent = new Intent();
        intent.putExtra("data",editText.getText().toString());
        setResult(0x012,intent);
        finish();
    }
}
