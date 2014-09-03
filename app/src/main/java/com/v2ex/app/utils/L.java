package com.v2ex.app.utils;

import android.util.Log;

import com.v2ex.app.BuildConfig;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class L {
    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg);
        }
    }

    private static final String TAG = "V2EX";

    public static void d(String msg) {
        d(TAG, msg);
    }
}
