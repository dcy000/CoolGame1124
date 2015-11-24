package com.dcy.coolgame.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dcy.coolgame.R;
import com.dcy.coolgame.view.DrawGameView;

/**
 * Created by dcy123 on 2015/11/24.
 */
public class DrawSelfActivity extends BaseActivity implements View.OnClickListener{
    private DrawGameView mDrawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_self);
        mDrawView = (DrawGameView) findViewById(R.id.view_draw);
        findViewById(R.id.btn_clear).setOnClickListener(this);
//        findViewById(R.id.iv_show).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_clear:
                mDrawView.clear();
                break;
            case R.id.iv_show:
                ((ImageView)view).setImageBitmap(mDrawView.getBitmap());
                break;
        }
    }
}
