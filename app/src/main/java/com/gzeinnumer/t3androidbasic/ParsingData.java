package com.gzeinnumer.t3androidbasic;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ParsingData extends AppCompatActivity {

    //todo 33. buat var
    public static final String EXTRA_NAME = "NAME";
    public static final String EXTRA_AGE = "AGE";

    TextView dataReceived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing_data);
        dataReceived = findViewById(R.id.data_received);
        //todo 35.
        getDataIntent();
    }

    //todo 36.
    @SuppressLint("SetTextI18n")
    private void getDataIntent() {
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,0 );
        dataReceived.setText("Name " + name + "Age " + age);
    }
}
