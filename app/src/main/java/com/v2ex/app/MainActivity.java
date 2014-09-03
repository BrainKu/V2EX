package com.v2ex.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.v2ex.app.adapter.BasePageAdapter;
import com.v2ex.app.utils.L;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends Activity {

    ActionBar actionBar;
    BasePageAdapter mPagerAdapter;

    @InjectView(R.id.viewpager) ViewPager mViewPager;

    private ActionBar.TabListener mTabListener = new ActionBar.TabListener() {
        @Override public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }

        @Override public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initViewPager();
        initActionBar();
    }

    private void initViewPager() {
        mPagerAdapter = new BasePageAdapter(getFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override public void onPageSelected(int position) {
                getActionBar().setSelectedNavigationItem(position);
            }
        });
    }

    private void initActionBar() {
        actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i < mPagerAdapter.getCount(); i++) {
            actionBar.addTab(actionBar.newTab().setText(mPagerAdapter.getPageTitle(i))
                .setTabListener(mTabListener));
        }
        forceTab();
    }

    /**
     * 设置嵌入式的Tab--很可能有严重的兼容性问题
     */
    private void forceTab() {
        try {
            Method mHasEmbedTabs = actionBar.getClass().getDeclaredMethod("setHasEmbeddedTabs", boolean.class);
            mHasEmbedTabs.setAccessible(true);
            mHasEmbedTabs.invoke(actionBar, true);
        } catch (NoSuchMethodException e) {
            L.d(e.toString());
        } catch (InvocationTargetException e) {
            L.d(e.toString());
        } catch (IllegalAccessException e) {
            L.d(e.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
