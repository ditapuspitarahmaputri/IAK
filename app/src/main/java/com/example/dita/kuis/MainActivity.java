package com.example.dita.kuis;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;

public class MainActivity extends Activity implements OnClickListener {

    // Attribute
    ImageView soal_image, bg_soal;
    TextView text_soal, text_jawab, salah_benar, nomor;
    Button button_jawab, button_next1, button_next2;
    ImageButton button_a, button_b, button_c, button_d;

    int indeks = 0, index = 0, point = 0, benar = 0, salah = 0, no = 1;

    // Array Untuk Gambar
    int[] soalGAMBAR = {
            R.drawable.wayang,
            R.drawable.reog };

    int[] jawab_a = {
            R.drawable.facebook,
            R.drawable.kucing};
    int[] jawab_b = {
            R.drawable.kucing,
            R.drawable.kelelawar};
    int[] jawab_c = {
            R.drawable.twit,
            R.drawable.labalaba };
    int[] jawab_d = {
            R.drawable.youtube,
            R.drawable.panci };

    // Array Untuk Text
    String[] soalTEXT = {
            "Manakah yang merupakan Icon facebook?",
            "Manakah yang merupakan Binatang berkaki 4 ?" };

    String[] textHINT = {
            "Apa Nama kebudayaan pada Gambar Tersebut ?",
            "apa nama gambar kebudayaan diatas ?" };

    // Array Untuk Jawaban
    String[] jawabSATU = {
            "wayang",
            "reog" };

    String[] jawabDUA = { "A", "A" };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soal_image = (ImageView) findViewById(R.id.Soal_Gambar);
        soal_image.setImageResource(soalGAMBAR[0]);

        text_jawab = (TextView) findViewById(R.id.Text_Jawab);
        text_jawab.setHint(textHINT[0]);

        button_jawab = (Button) findViewById(R.id.Button_Jawab);
        button_jawab.setOnClickListener(this);

        bg_soal = (ImageView) findViewById(R.id.Bg_Soal);
        nomor = (TextView) findViewById(R.id.No);
        nomor.setText("Soal " + no++);

        text_soal = (TextView) findViewById(R.id.Soal);
        text_soal.setText(soalTEXT[0]);

        button_a = (ImageButton) findViewById(R.id.BI_Jawab1);
        button_a.setImageResource(jawab_a[0]);
        button_a.setOnClickListener(this);

        button_b = (ImageButton) findViewById(R.id.BI_Jawab2);
        button_b.setImageResource(jawab_b[0]);
        button_b.setOnClickListener(this);

        button_c = (ImageButton) findViewById(R.id.BI_Jawab3);
        button_c.setImageResource(jawab_c[0]);
        button_c.setOnClickListener(this);

        button_d = (ImageButton) findViewById(R.id.BI_Jawab4);
        button_d.setImageResource(jawab_d[0]);
        button_d.setOnClickListener(this);

        salah_benar = (TextView) findViewById(R.id.Benar_Salah);

        button_next1 = (Button) findViewById(R.id.Button_Next1);
        button_next1.setOnClickListener(this);

        button_next2 = (Button) findViewById(R.id.Button_Next2);
        button_next2.setOnClickListener(this);

    }

    public void onClick(View v) {

        // Untuk Soal 1 - 2
        if (v == button_jawab) {
            String jawab_user = text_jawab.getText().toString();

            if (jawab_user.equalsIgnoreCase(jawabSATU[indeks])) {
                salah_benar.setText("BENAR");
                salah_benar.setTextColor(Color.GREEN);
                benar++;
                point = point + 25;
            } else {
                salah_benar.setText("SALAH");
                salah_benar.setTextColor(Color.RED);
                salah++;
            }

            salah_benar.setVisibility(View.VISIBLE);
            button_next1.setVisibility(View.VISIBLE);
            button_jawab.setEnabled(false);
            button_jawab.setTextColor(Color.WHITE);

        }

        else if (v == button_next1) {

            text_jawab.setText("");
            salah_benar.setText("");
            nomor.setText("Soal " + no++);
            button_next1.setVisibility(View.INVISIBLE);

            button_jawab.setEnabled(true);
            button_jawab.setTextColor(Color.RED);

            if (indeks < jawabSATU.length - 1) {

                indeks++;
                soal_image.setImageResource(soalGAMBAR[indeks]);
                text_jawab.setHint(textHINT[indeks]);

            } else {

                soal_image.setVisibility(View.INVISIBLE);
                text_jawab.setVisibility(View.INVISIBLE);
                button_jawab.setVisibility(View.INVISIBLE);

                bg_soal.setVisibility(View.VISIBLE);
                text_soal.setVisibility(View.VISIBLE);
                button_a.setVisibility(View.VISIBLE);
                button_b.setVisibility(View.VISIBLE);
                button_c.setVisibility(View.VISIBLE);
                button_d.setVisibility(View.VISIBLE);

            }
        }

        // Untuk Soal 3 - 4
        else if (v == button_a) {
            if (jawabDUA[index].equals("A")) {
                salah_benar.setText("BENAR");
                salah_benar.setTextColor(Color.BLACK);
                benar++;
                point = point + 25;
            } else {
                salah_benar.setText("SALAH");
                salah_benar.setTextColor(Color.RED);
                salah++;
            }
            button_next2.setVisibility(View.VISIBLE);
        }

        else if (v == button_b) {
            if (jawabDUA[index].equals("B")) {
                salah_benar.setText("BENAR");
                salah_benar.setTextColor(Color.GREEN);
                benar++;
                point = point + 25;
            } else {
                salah_benar.setText("SALAH");
                salah_benar.setTextColor(Color.RED);
                salah++;
            }
            button_next2.setVisibility(View.VISIBLE);
        }

        else if (v == button_c) {
            if (jawabDUA[index].equals("C")) {
                salah_benar.setText("BENAR");
                salah_benar.setTextColor(Color.GREEN);
                benar++;
                point = point + 25;
            } else {
                salah_benar.setText("SALAH");
                salah_benar.setTextColor(Color.RED);
                salah++;
            }
            button_next2.setVisibility(View.VISIBLE);
        }

        else if (v == button_d) {
            if (jawabDUA[index].equals("D")) {
                salah_benar.setText("BENAR");
                salah_benar.setTextColor(Color.GREEN);
                benar++;
                point = point + 25;
            } else {
                salah_benar.setText("SALAH");
                salah_benar.setTextColor(Color.RED);
                salah++;
            }
            button_next2.setVisibility(View.VISIBLE);
        }

        else if (v == button_next2) {

            if (index < jawabDUA.length - 1) {

                salah_benar.setText("");
                nomor.setText("Soal " + no);
                button_next2.setVisibility(View.INVISIBLE);

                index++;
                text_soal.setText(soalTEXT[index]);
                button_a.setImageResource(jawab_a[index]);
                button_b.setImageResource(jawab_b[index]);
                button_c.setImageResource(jawab_c[index]);
                button_d.setImageResource(jawab_d[index]);

            } else {

                // Pindah ke MainActivity2
                Intent m2 = new Intent(MainActivity.this, tampilan1.class);
                m2.putExtra("BenaR", benar);
                m2.putExtra("SalaH", salah);
                m2.putExtra("PoinT", point);
                startActivity(m2);
                finish();

            }
        }
    }
}