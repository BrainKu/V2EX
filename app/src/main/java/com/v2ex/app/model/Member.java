package com.v2ex.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class Member {
    private long id;
    private String username;
    private String tagline;
    @SerializedName(value = "avatar_normal")
    private String avaterNormal;
    @SerializedName(value = "avatar_large")
    private String avaterLarge;
    @SerializedName(value = "avatar_mini")
    private String avaterMini;
}
