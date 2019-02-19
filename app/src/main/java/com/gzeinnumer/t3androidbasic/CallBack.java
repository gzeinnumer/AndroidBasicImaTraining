package com.gzeinnumer.t3androidbasic;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CallBack extends AppCompatActivity implements View.OnClickListener {

    //todo 44. lakukan hal sama
    public static final String EXTRA_CALL_BACK = "extra_callback";
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //todo 45. kirim data
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CALL_BACK, "Call Back Nih!!");
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
