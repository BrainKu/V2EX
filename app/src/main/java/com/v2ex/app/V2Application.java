package com.v2ex.app;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class V2Application extends Application {

    private static V2Application sInstance;

    @Override public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static V2Application getInstance() {
        return sInstance;
    }

    private RequestQueue sRequestQueue;

    public RequestQueue getRequestQueue() {
        if (sRequestQueue == null) {
            synchronized (this) {
                if (sRequestQueue == null)
                    sRequestQueue = Volley.newRequestQueue(this);
            }
        }
        return sRequestQueue;
    }

    private String TAG = "DEFAULT";

    public void addRequest(Request<?> request, Object tag) {
        request.setTag(tag == null ? TAG : tag);
        if (sRequestQueue == null)
            getRequestQueue();
        sRequestQueue.add(request);
    }

    public void cancelQuest(Object tag) {
        if (sRequestQueue!= null || tag ==null)
            throw new IllegalStateException("Quest don't init or tag is null");
        getRequestQueue().cancelAll(tag);
    }
}
