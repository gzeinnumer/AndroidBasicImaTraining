package com.gzeinnumer.t3androidbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gzeinnumer.t3androidbasic.model.Orang;

public class ParsingObject extends AppCompatActivity {

    //todo 41. lakukan hal sama sepertipada ParsingData
    public static final String EXTRA_ORANG = "extra_orang";
    TextView receivedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing_object);
        receivedData = findViewById(R.id.data_received);

        getDataObjectIntent();
    }
//todo 42. get data menggunakan parce lable
    private void getDataObjectIntent() {
        Orang orang = getIntent().getParcelableExtra(EXTRA_ORANG);
        String show = "Nama = " + orang.getName() +
                        "\nUmur = "+ orang.getAge() +
                        "\nT4 tinggal = "+ orang.getTinggal() +
                        "\nAsal = "+ orang.getAsal() +
                        "\nAsal = "+ orang.getAsal();
        receivedData.setText(show);
    }
}
