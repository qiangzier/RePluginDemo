package com.hzq.replugindemo;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hzq.common_lib.utils.AppUtils;
import com.hzq.common_lib.utils.BaseApplication;
import com.hzq.router.RouterManager;
import com.hzq.router.RouterRequest;
import com.qihoo360.replugin.RePlugin;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_DEMO1 = 0x011;
    private static final int RESULT_CODE_DEMO1 = 0x012;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.processName);
        textView.setText("当前进程名称为："+ AppUtils.getProcessName(this));

        findViewById(R.id.btn_start_plugin1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RePlugin.startActivity(MainActivity.this,RePlugin.createIntent("com.hzq.plugin1","com.hzq.plugin1.MainActivity"));
            }
        });

        findViewById(R.id.btn_start_plugin_for_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("plugin1","com.hzq.plugin1.TestPluginActivityForResult"));
                RePlugin.startActivityForResult(MainActivity.this,intent,REQUEST_CODE_DEMO1);
            }
        });

        findViewById(R.id.btn_load_fragment_from_plugin1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PluginFragmentActivity.class));
            }
        });

        findViewById(R.id.btn_load_fragment_from_plugin1_v4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PluginFragmentActivity.class);
                intent.putExtra("classname","com.hzq.plugin1.V4FragmentTest");
                startActivity(intent);
            }
        });

        findViewById(R.id.getPlugin1Data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.getInstance().router(MainActivity.this,new RouterRequest.Builder("plugin1","startService").build());
            }
        });

        Log.d("xxxHostMainActivity",RouterManager.getInstance().toString());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_DEMO1 && resultCode == RESULT_CODE_DEMO1) {
            String str = data.getStringExtra("data");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }
}
