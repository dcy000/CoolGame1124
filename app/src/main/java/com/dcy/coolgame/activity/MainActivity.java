package com.dcy.coolgame.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dcy.coolgame.R;

/**
 * Created by dcy123 on 2015/10/19.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_clear).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_clear:
                Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
