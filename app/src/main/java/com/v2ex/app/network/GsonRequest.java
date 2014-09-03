package com.v2ex.app.network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class GsonRequest<T> extends Request<T> {

    private Listener<T> mListener;
    private Class<T> clazz;
    private Gson mGson = new Gson();
    private Map<String, String> params;
    private Type mType;

    @Override public Map<String, String> getParams() {
        return params.isEmpty() ? null : params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public GsonRequest(int method, String url, ErrorListener errorListener, Class<T> clazz, Listener<T> listener) {
        super(method, url, errorListener);
        this.clazz = clazz;
        this.mListener = listener;
    }

    public GsonRequest(String url,  Class<T> clazz, Listener<T> listener,
                       ErrorListener errorListener) {
        this(Method.GET, url, errorListener, clazz, listener);
    }

    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String paresed = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            return Response.success(mGson.fromJson(paresed, clazz), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override protected void deliverResponse(T t) {
        mListener.onResponse(t);
    }
}