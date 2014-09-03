package com.v2ex.app.json;

import android.test.AndroidTestCase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.v2ex.app.utils.L;
import com.v2ex.app.model.Artical;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class ArticalTest extends AndroidTestCase {

    private String content;
    private Artical mArtical;
    private List<Artical> mArticals = new ArrayList<Artical>();

    @Override protected void setUp() throws Exception {
        super.setUp();
        InputStream is = mContext.getAssets().open("hot.json");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        bufferedReader.close();
        content = sb.toString();
    }

    public void testContent() {
        assertNotNull(content);
    }

    public void testJson() {
        Gson mGson = new Gson();
        Type mType = new TypeToken<List<Artical>>() {
        }.getType();
        mArticals = mGson.fromJson(content, mType);
        for (int i = 0; i < mArticals.size(); i++) {
           L.d(mArticals.get(i).toString());
        }
        assertNotNull(mArticals);
    }
}
