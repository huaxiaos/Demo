package com.huaxiao.demo.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.huaxiao.demo.R;
import com.huaxiao.demo.helper.LogHelper;

public class Lifecycle1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle1);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lifecycle1Activity.this, Lifecycle2Activity.class);
                startActivity(intent);
            }
        });

        LogHelper.e("1 onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogHelper.e("1 onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogHelper.e("1 onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogHelper.e("1 onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogHelper.e("1 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogHelper.e("1 onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogHelper.e("1 onDestory");
    }
}
