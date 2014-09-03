package com.v2ex.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class User {
    public String status;
    private long id;
    private String url;
    private String username;
    private String website;
    private String tagline;
    private String bio;
    @SerializedName(value = "avatar_normal")
    private String avaterNormal;
    @SerializedName(value = "avatar_large")
    private String avaterLarge;
    @SerializedName(value = "avatar_mini")
    private String avaterMini;

    public String getAvaterMini() {
        return avaterMini;
    }

    public String getAvaterNormal() {
        return avaterNormal;
    }

    public String getAvaterLarge() {
        return avaterLarge;
    }

    public String getBio() {
        return bio;
    }

    public String getTagline() {
        return tagline;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getUrl() {
        return url;
    }

    public long getId() {
        return id;
    }

}
