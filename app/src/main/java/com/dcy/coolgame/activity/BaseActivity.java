package com.dcy.coolgame.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by dcy123 on 2015/10/19.
 */
public class BaseActivity extends Activity{
    private LinearLayout rootView;
    private LayoutInflater mInflater;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mInflater = LayoutInflater.from(this);
        rootView = new LinearLayout(this);
        rootView.setOrientation(LinearLayout.VERTICAL);
    }
}
