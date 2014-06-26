package com.example.androidgles20;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MainActivity extends Activity {
    private GLSurfaceView view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        view = (GLSurfaceView) findViewById(R.id.surfaceView);

        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();

        // 端末がOpenGL ES 2.0をサポートしているかチェック
        if (configurationInfo.reqGlEsVersion >= 0x20000) {
            view.setEGLContextClientVersion(2); // OpenGLバージョンを設定
            view.setRenderer(new MyRenderer()); // レンダラを設定

        } else {
            finish();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if (view != null) {
            view.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (view != null) {
            view.onPause();
        }
    }
}
