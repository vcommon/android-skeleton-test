package com.diyerland.tech.tech_android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.diyerland.StringTest;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringTest test = new StringTest();
        String ret = test.stringAdd();
        ret = test.stringBuilderAdd();
        ret = test.stringBufferAdd();
        ret = test.stringReplace();

        Log.d(ret, ret);
    }
}
