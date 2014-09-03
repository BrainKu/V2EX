package com.v2ex.app.network;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.v2ex.app.utils.UIHelper;
import com.v2ex.app.V2Application;
import com.v2ex.app.model.Artical;
import com.v2ex.app.model.User;

import java.util.List;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class V2Request {
    private static Gson mGson = new Gson();

    public static void fetchAllArtical(Response.Listener<List<Artical>> mListener) {
        GsonArrayRequest<List<Artical>> mGsonArrRequest = new GsonArrayRequest<List<Artical>>
            (V2EXAPI.LATEST, new TypeToken<List<Artical>>() {
            }.getType(), mListener,
                DEFAULT_ERROR_LISTENER
            );
        V2Application.getInstance().addRequest(mGsonArrRequest, "all");
    }

    public static void fetchHotArtical(Response.Listener<List<Artical>> mListener) {
        GsonArrayRequest<List<Artical>> mGsonArrRequest = new GsonArrayRequest<List<Artical>>
            (V2EXAPI.HOT, new TypeToken<Artical>() {
            }.getType(), mListener, DEFAULT_ERROR_LISTENER);
        V2Application.getInstance().addRequest(mGsonArrRequest, "hot");
    }

    public static void getUserInfo(int userId, Response.Listener<User> mListener) {
        String FINAL_URL = V2EXAPI.USER + "?id=" + userId;
        GsonRequest<User> mGsonRequest = new GsonRequest<User>(FINAL_URL, User.class,
            mListener, DEFAULT_ERROR_LISTENER);
        V2Application.getInstance().addRequest(mGsonRequest, "userinfo");
    }

    private static Response.ErrorListener DEFAULT_ERROR_LISTENER = new Response.ErrorListener() {
        @Override public void onErrorResponse(VolleyError volleyError) {
            UIHelper.showToast(V2Application.getInstance(), volleyError.getMessage());
        }
    };
}
