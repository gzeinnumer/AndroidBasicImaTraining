//todo 4. package name
package com.gzeinnumer.t3androidbasic;

//todo 5. import
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gzeinnumer.t3androidbasic.model.Orang;

//todo 6. apa itu AppCompatActivity >> merupakan sebuah klas yang isi nya semua fitur2 android.
//fragment
//jelaskan tentang kurung kurawal
//todo 28. buat ini
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //todo 7. variable local dan global
    //String gzeinnumer;

    //todo 22. deklarasi layout
    Button btnMove, btnParsingData, btnParsingObject, btnCallBack, btnEmail, btnDial;
    private static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo 3. saat membuat activity ada 2 file yang terbuat
        setContentView(R.layout.activity_main);

        //todo 23. findview
        btnMove = findViewById(R.id.btn_move);
        btnParsingData = findViewById(R.id.btn_parsing_data);
        btnParsingObject = findViewById(R.id.btn_pasring_object);
        btnCallBack = findViewById(R.id.btn_callback);
        btnEmail = findViewById(R.id.btn_email);
        btnDial = findViewById(R.id.btn_dial);

//        //todo 24. event listener
//        btnMove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //buat Activity dulu
//                Intent intent = new Intent(getApplicationContext(), Move.class);
//                startActivity(intent);
//            }
//        });
//
//        //todo 25. buat semua onclick
//
//        btnParsingData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //buat Activity dulu
//                Intent intent = new Intent(getApplicationContext(), ParsingData.class);
//                startActivity(intent);
//            }
//        });
//
//        btnParsingObject.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //buat Activity dulu
//                Intent intent = new Intent(getApplicationContext(), ParsingObject.class);
//                startActivity(intent);
//
//            }
//        });
//
//        btnCallBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //buat Activity dulu
//                Intent intent = new Intent(getApplicationContext(), CallBack.class);
//                startActivity(intent);
//
//            }
//        });
//
//        btnEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        btnDial.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        //todo 26. cara mudah
        btnMove.setOnClickListener(this);
        btnParsingData.setOnClickListener(this);
        btnParsingObject.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnCallBack.setOnClickListener(this);
    }

    //todo 29. jadi ini
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move:
                //todo 30. buat fungtion intent
                intent();
                break;
            case R.id.btn_parsing_data:
                //buat Activity dulu
                intentPassData();
                break;
            case R.id.btn_pasring_object:
                //todo 39.
                passObj();
                //buat Activity dulu

                break;
            case R.id.btn_callback:
                //buat Activity dulu
                //todo 46.
                getDataCallBack();
                break;
            case R.id.btn_email:
                //todo 49.
                getEmailIntent();
                break;
            case R.id.btn_dial:
//                todo 51.
                getDialIntent();
                break;
        }
    }

    //todo 52.
    private void getDialIntent() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:082385804045"));
        startActivity(intent);
    }


    //todo 50
    private void getEmailIntent() {
        // intent implicit email
        Intent email = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto",
                        "m.fadli.zein.17@gmail.com",
                        null));

        // subject email
        email.putExtra(Intent.EXTRA_SUBJECT, "Ini Subjcet");
        email.putExtra(Intent.EXTRA_TEXT, "Ini pesan");

        // cek jika device ada email client
        if (email.resolveActivity(getPackageManager()) != null) {

            // pilih email client di device
            startActivity(Intent.createChooser(
                    email, "Pilih Email Client"));
        } else {

        }
    }

    //todo 47.
    private void getDataCallBack() {
        Intent callBack = new Intent(this, CallBack.class);
        startActivityForResult(callBack, REQUEST_CODE);
    }

    //todo 48.


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //todo 49. jika requets kode yang sama
        // cek requestCode nya cocok apa enggak
        // denga apa yang telah kita buat
        if (requestCode == RESULT_OK) {

            // cek hasil sama atau enggak
            if (resultCode == RESULT_OK) {

                // get data callback nya
                String result = data.getStringExtra(CallBack.EXTRA_CALL_BACK);

                // nampilin toast
                Toast.makeText(this, "Result : "
                        + result, Toast.LENGTH_SHORT).show();

            } else {

            }
        }

    }

    //todo 40.
    private void passObj() {
        Orang orang = new Orang();
        orang.setName("Zein");
        orang.setAge(21);
        orang.setAsal("Padang Panjang");
        orang.setTinggal("Jakarta");
        orang.setPekerjaan("Mahasiswa");
        Intent intent2 = new Intent(getApplicationContext(), ParsingObject.class);
        intent2.putExtra(ParsingObject.EXTRA_ORANG,orang);
        startActivity(intent2);
    }

    //todo 31.
    private void intent() {
        startActivity(new Intent(this, Move.class));
    }

    //todo 34.
    private void intentPassData(){
        Intent intent = new Intent(getApplicationContext(), ParsingData.class);
        intent.putExtra(ParsingData.EXTRA_NAME,"Zein ini mah");
        intent.putExtra(ParsingData.EXTRA_AGE,21);
        startActivity(intent);
    }
}

//todo 8. jelaskan folder res
//jelaskan sambil jalan
//todo 9. jelaskan Gradle Scripts
