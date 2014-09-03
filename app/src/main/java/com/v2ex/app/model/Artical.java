package com.v2ex.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class Artical {
    private long id;
    private String title;
    private String url;
    private String content;
    private Node node;
    @SerializedName(value = "content_rendered")
    private String contentRendered;
    @SerializedName(value = "replies")
    private int replyCount;
    @SerializedName(value = "member")
    private Member publisher;
    @SerializedName(value = "created")
    private long createdTime;
    @SerializedName(value = "last_modified")
    private long lastModified;
    @SerializedName(value = "last_touched")
    private long lastTouched;

    public Node getNode() {
        return node;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public String getContentRendered() {
        return contentRendered;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public Member getPublisher() {
        return publisher;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public long getLastModified() {
        return lastModified;
    }

    public long getLastTouched() {
        return lastTouched;
    }
}
