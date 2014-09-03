package com.v2ex.app.network;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class V2EXAPI {
    public static final String BASE_URL = "http://www.v2ex.com/api";
    public static final String LATEST = BASE_URL + "/topics/latest.json";
    public static final String ALL_NODE = BASE_URL + "/nodes/all.json";
    public static final String REPLIES = BASE_URL + "/replies/show.json";
    public static final String TOPIC = BASE_URL + "/topics/show.json";
    public static final String HOT = BASE_URL + "/topics/hot.json";
    /**
     * 参数为username,或者id.返回内容：
     * "status" : "found",
     * "id" : 1,
     * "url" : "http://www.v2ex.com/member/Livid",
     * "username" : "Livid",
     * "website" : "http://livid.v2ex.com/",
     * "twitter" : "Livid",
     * "psn" : "OLIVIDA",
     * "github" : "livid",
     * "btc" : "1PhdS8whFp33tAquwQ2ho6cXNiqW4CLn5P",
     * "location" : "Inland Empire, CA",
     * "tagline" : "Beautifully Advance",
     * "bio" : "What it lies in our power to do, it lies in our power not to do.\u000D\u000A\u000D\u000A黑魔法，白魔法，树蛇，紧靠翡翠森林的静默之湖。\u000D\u000A\u000D\u000A高兴的时候不做承诺，愤怒的时候不做决定。\u000D\u000A\u000D\u000A未来不迎，既过不恋，当时不杂。\u000D\u000A\u000D\u000A天然存在的放射性同位素主要是恆星的內部。例如鈾，在星體內直接被形成。\u000D\u000A\u000D\u000A梦想般的人生就是，一直在做梦想中的事情。\u000D\u000A\u000D\u000A当他回首往事的时候，不因虚度年华而悔恨，也不因碌碌无为而羞耻。",
     * "avatar_mini" : "//cdn.v2ex.com/avatar/c4ca/4238/1_mini.png?m=1401650222",
     * "avatar_normal" : "//cdn.v2ex.com/avatar/c4ca/4238/1_normal.png?m=1401650222",
     * "avatar_large" : "//cdn.v2ex.com/avatar/c4ca/4238/1_large.png?m=1401650222",
     * "created" : 1272203146
     */
    public static final String USER = BASE_URL + "/members/show.json";
}
