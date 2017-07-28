package com.yu.tinker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Button btnOnlineRequest;
    private Button btnConfigRequest;
    private Button btnKillSelf;
    private static final String TAG = "Tinker.TinkerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOnlineRequest = (Button) findViewById(R.id.btn_online_request);
        btnConfigRequest = (Button) findViewById(R.id.btn_config_request);
        btnKillSelf = (Button) findViewById(R.id.btn_kill_self);
        btnOnlineRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //每次强制访问服务器更新
                TinkerPatch.with().fetchPatchUpdate(true);
            }
        });
        btnConfigRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinkerPatch.with().fetchDynamicConfig(new ConfigRequestCallback() {
                    @Override
                    public void onSuccess(final HashMap<String, String> map) {
                        TinkerLog.w(TAG, "请求参数成功, config:" + map);
                    }

                    @Override
                    public void onFail(final Exception e) {
                        TinkerLog.w(TAG, "请求参数失败, exception:" + e);
                    }
                }, true);
            }
        });
        btnKillSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareTinkerInternals.killAllOtherProcess(getApplicationContext());
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }
}
