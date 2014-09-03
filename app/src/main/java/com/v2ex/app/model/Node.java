package com.v2ex.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class Node {
    /**
     * "id" : 43,
     * "name" : "jobs",
     * "title" : "酷工作",
     * "title_alternative" : "Jobs",
     * "url" : "http://www.v2ex.com/go/jobs",
     * "topics" : 6130,
     * "avatar_mini" : "//cdn.v2ex.com/navatar/17e6/2166/43_mini.png?m=1409647054",
     * "avatar_normal" : "//cdn.v2ex.com/navatar/17e6/2166/43_normal.png?m=1409647054",
     * "avatar_large" : "//cdn.v2ex.com/navatar/17e6/2166/43_large.png?m=1409647054"
     */
    private long id;
    private long topics;
    private String name;
    private String title;
    private String url;
    @SerializedName(value = "avatar_normal")
    private String avaterNormal;
    @SerializedName(value = "title_alternative")
    private String titleAlternative;
    @SerializedName(value = "avatar_large")
    private String avaterLarge;
    @SerializedName(value = "avatar_mini")
    private String avaterMini;
}
