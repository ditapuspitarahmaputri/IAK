package com.example.dita.kuis;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;

public class tampilan1 extends Activity implements OnClickListener {

    int point, benar, salah;

    TextView nilai_point, judul, hasil, text_jawab, nomor;
    Button exit, button_jawab;
    ImageView bg_soal;
    RelativeLayout background;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengambil Point dan Jawaban Benar | Salah
        benar = getIntent().getIntExtra("BenaR", 0);
        salah = getIntent().getIntExtra("SalaH", 0);
        point = getIntent().getIntExtra("PoinT", 0);

        text_jawab = (TextView) findViewById(R.id.Text_Jawab);
        text_jawab.setVisibility(View.INVISIBLE);

        button_jawab = (Button) findViewById(R.id.Button_Jawab);
        button_jawab.setVisibility(View.INVISIBLE);

        bg_soal = (ImageView) findViewById(R.id.Bg_Soal);
        bg_soal.setVisibility(View.VISIBLE);

        background = (RelativeLayout) findViewById(R.id.Bg_Layout);
        background.setBackgroundResource(R.drawable.logo);

        judul = (TextView) findViewById(R.id.Judul_Hasil);
        judul.setVisibility(View.VISIBLE);

        nomor = (TextView) findViewById(R.id.No);
        nomor.setText("Hasil");

        hasil = (TextView) findViewById(R.id.Hasil_Jawaban);
        hasil.setVisibility(View.VISIBLE);
        hasil.setText("Jawaban Benar : " + benar + "\nJawaban Salah : "
                + salah);

        nilai_point = (TextView) findViewById(R.id.Point);
        nilai_point.setText("Nilai Kamu : " + point);

        exit = (Button) findViewById(R.id.Button_Exit);
        exit.setOnClickListener(this);
        exit.setVisibility(View.VISIBLE);

    }

    public void onClick(View v) {
        if (v == exit) {
            finish();
        }
    }
}



