package com.v2ex.app.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class UIHelper {
    public static void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
