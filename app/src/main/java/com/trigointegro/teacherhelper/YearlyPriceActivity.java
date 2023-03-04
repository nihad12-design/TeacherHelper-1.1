package com.trigointegro.teacherhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;

public class YearlyPriceActivity extends AppCompatActivity {

    View llB1, llB2, llB3, llB4, llB5, llB6, llI1, llI2, llI3, llI4, llI5, llI6, llbsq;
    View btnB2, btnB3, btnB4, btnB5, btnB6, btnI1, btnI2, btnI3, btnI4, btnI5, btnI6;
    EditText etB1, etB2, etB3, etB4, etB5, etB6, etI1, etI2, etI3, etI4, etI5, etI6, etbsq;
    TextView txtB1, txtB2, txtB3, txtB4, txtB5, txtB6, txtI1, txtI2, txtI3, txtI4, txtI5, txtI6, txtbsq;
    CheckBox checkBox;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_price);
        init();

        Boolean[] arrBbtn = {true, true, true, true, true, false};
        View[] arrBv = {btnB2, btnB3, btnB4, btnB5, btnB6};
        EditText[] arrBvet = {etB1, etB2, etB3, etB4, etB5, etB6};
        View[] arrBvll = {llB1, llB2, llB3, llB4, llB5, llB6};
        TextView[] arrBtxt = {txtB1, txtB2, txtB3, txtB4, txtB5, txtB6};
        String[] arrksqg = {"KSQ 1", "KSQ 2", "KSQ 3", "KSQ 4", "KSQ 5", "KSQ 6"};
        String[] arrksqv = {"KSQ 1:", "KSQ 2:", "KSQ 3:", "KSQ 4:", "KSQ 5:", "KSQ 6:"};

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            arrBv[i].setOnClickListener(v -> {
                if (arrBbtn[finalI + 1]) {
                    if (arrBbtn[5]) {
                        arrBbtn[5] = false;
                        arrBv[4].setBackgroundResource(R.drawable.frameadd);
                        arrBvet[5].setVisibility(View.GONE);
                        arrBvll[5].setBackgroundResource(R.drawable.darkuncornerrounder);
                        arrBtxt[5].setText(arrksqg[5]);
                    } else {
                        int a = 5;
                        for (int i12 = 0; i12 < 6; i12++) {
                            if (!arrBbtn[i12]) {
                                a = i12 - 1;
                                arrBbtn[a] = false;
                                break;
                            }
                        }
                        arrBv[a - 1].setBackgroundResource(R.drawable.frameadd);
                        arrBvet[a].setVisibility(View.GONE);
                        if (a % 2 == 0) {
                            arrBvll[a].setBackgroundResource(R.drawable.darkcornerrounder);
                        } else {
                            arrBvll[a].setBackgroundResource(R.drawable.darkuncornerrounder);
                        }
                        arrBtxt[a].setText(arrksqg[a]);
                        arrBv[a].setVisibility(View.GONE);
                    }


                } else {
                    if (finalI == 4) {
                        arrBvll[5].setBackgroundResource(R.drawable.uncornerrounder);
                        arrBtxt[5].setText(arrksqv[5]);
                        arrBvet[5].setVisibility(View.VISIBLE);
                        arrBv[4].setBackgroundResource(R.drawable.frame);
                        arrBbtn[5] = true;
                    } else {
                        arrBv[finalI].setBackgroundResource(R.drawable.frame);
                        arrBv[finalI + 1].setBackgroundResource(R.drawable.frameadd);
                        arrBv[finalI + 1].setVisibility(View.VISIBLE);
                        arrBvet[finalI + 1].setVisibility(View.VISIBLE);
                        if ((finalI + 1) % 2 == 0) {
                            arrBvll[finalI + 1].setBackgroundResource(R.drawable.cornerrounder);
                        } else {
                            arrBvll[finalI + 1].setBackgroundResource(R.drawable.uncornerrounder);
                        }
                        arrBtxt[finalI + 1].setText(arrksqv[finalI + 1]);
                        arrBbtn[finalI + 1] = true;
                        arrBbtn[finalI + 1] = true;
                    }
                }
            });

        }

        Boolean[] arrIbtn = {true, true, true, true, true, false};
        View[] arrIv = {btnI1, btnI2, btnI3, btnI4, btnI5, btnI6};
        EditText[] arrIvet = {etI1, etI2, etI3, etI4, etI5, etI6};
        View[] arrIvll = {llI1, llI2, llI3, llI4, llI5, llI6};
        TextView[] arrItxt = {txtI1, txtI2, txtI3, txtI4, txtI5, txtI6};

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            arrIv[i + 1].setOnClickListener(v -> {
                if (arrIbtn[finalI + 1]) {
                    if (arrIbtn[5]) {
                        arrIbtn[5] = false;
                        arrIv[5].setBackgroundResource(R.drawable.frameadd);
                        arrIvet[5].setVisibility(View.GONE);
                        arrIvll[5].setBackgroundResource(R.drawable.darkuncornerrounder);
                        arrItxt[5].setText(arrksqg[5]);
                    } else {
                        int a = 5;
                        for (int i1 = 0; i1 < 6; i1++) {
                            if (!arrIbtn[i1]) {
                                a = i1 - 1;
                                arrIbtn[a] = false;
                                break;
                            }
                        }
                        arrIv[a].setBackgroundResource(R.drawable.frameadd);
                        arrIvet[a].setVisibility(View.GONE);
                        if (a % 2 == 0) {
                            arrIvll[a].setBackgroundResource(R.drawable.darkcornerrounder);
                        } else {
                            arrIvll[a].setBackgroundResource(R.drawable.darkuncornerrounder);
                        }
                        arrItxt[a].setText(arrksqg[a]);
                        arrIv[a + 1].setVisibility(View.GONE);
                    }


                } else {
                    if (finalI == 4) {
                        arrIvll[5].setBackgroundResource(R.drawable.uncornerrounder);
                        arrItxt[5].setText(arrksqv[5]);
                        arrIvet[5].setVisibility(View.VISIBLE);
                        arrIv[5].setBackgroundResource(R.drawable.frame);
                        arrIbtn[5] = true;
                    } else {
                        arrIv[finalI + 1].setBackgroundResource(R.drawable.frame);
                        arrIv[finalI + 2].setBackgroundResource(R.drawable.frameadd);
                        arrIv[finalI + 2].setVisibility(View.VISIBLE);
                        arrIvet[finalI + 1].setVisibility(View.VISIBLE);
                        if ((finalI + 1) % 2 == 0) {
                            arrIvll[finalI + 1].setBackgroundResource(R.drawable.cornerrounder);
                        } else {
                            arrIvll[finalI + 1].setBackgroundResource(R.drawable.uncornerrounder);
                        }
                        arrItxt[finalI + 1].setText(arrksqv[finalI + 1]);
                        arrIbtn[finalI + 1] = true;
                        arrIbtn[finalI + 1] = true;
                    }
                }
            });

        }

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                for (int i = 0; i < 6; i++) {
                    arrIbtn[i] = false;
                    arrIv[1].setVisibility(View.GONE);
                    arrIv[2].setVisibility(View.GONE);
                    arrIv[3].setVisibility(View.GONE);
                    arrIv[4].setVisibility(View.GONE);
                    arrIv[5].setVisibility(View.GONE);
                    arrIvet[i].setVisibility(View.GONE);
                    if(i % 2 == 0){
                        arrIvll[i].setBackgroundResource(R.drawable.darkcornerrounder);
                    }else{
                        arrIvll[i].setBackgroundResource(R.drawable.darkuncornerrounder);
                    }
                    arrItxt[i].setText(arrksqg[i]);
                }
                etbsq.setVisibility(View.GONE);
                txtbsq.setText("BSQ");
                llbsq.setBackgroundResource(R.drawable.darkrounder);
            }
            else{
                for (int i = 0; i < 6; i++) {
                    arrIbtn[i] = true;
                    arrIv[1].setVisibility(View.VISIBLE);
                    arrIv[2].setVisibility(View.VISIBLE);
                    arrIv[3].setVisibility(View.VISIBLE);
                    arrIv[4].setVisibility(View.VISIBLE);
                    arrIv[5].setVisibility(View.VISIBLE);
                    arrIvet[i].setVisibility(View.VISIBLE);
                    if(i % 2 == 0){
                        arrIvll[i].setBackgroundResource(R.drawable.cornerrounder);
                    }else{
                        arrIvll[i].setBackgroundResource(R.drawable.uncornerrounder);
                    }
                    arrItxt[i].setText(arrksqv[i]);
                    btnI6.setBackgroundResource(R.drawable.frame);
                }
                etbsq.setVisibility(View.VISIBLE);
                txtbsq.setText("BSQ:");
                llbsq.setBackgroundResource(R.drawable.rounder);
            }
        });
    }

    @SuppressLint("WrongViewCast")
    private void init() {
        btnB2 = findViewById(R.id.btnB2);
        btnB3 = findViewById(R.id.btnB3);
        btnB4 = findViewById(R.id.btnB4);
        btnB5 = findViewById(R.id.btnB5);
        btnB6 = findViewById(R.id.btnB6);

        btnI2 = findViewById(R.id.btnI2);
        btnI3 = findViewById(R.id.btnI3);
        btnI4 = findViewById(R.id.btnI4);
        btnI5 = findViewById(R.id.btnI5);
        btnI6 = findViewById(R.id.btnI6);

        etB1 = findViewById(R.id.etbksq1);
        etB2 = findViewById(R.id.etbksq2);
        etB3 = findViewById(R.id.etbksq3);
        etB4 = findViewById(R.id.etbksq4);
        etB5 = findViewById(R.id.etbksq5);
        etB6 = findViewById(R.id.etbksq6);

        etI1 = findViewById(R.id.etiksq1);
        etI2 = findViewById(R.id.etiksq2);
        etI3 = findViewById(R.id.etiksq3);
        etI4 = findViewById(R.id.etiksq4);
        etI5 = findViewById(R.id.etiksq5);
        etI6 = findViewById(R.id.etiksq6);

        llB1 = findViewById(R.id.llbksq1);
        llB2 = findViewById(R.id.llbksq2);
        llB3 = findViewById(R.id.llbksq3);
        llB4 = findViewById(R.id.llbksq4);
        llB5 = findViewById(R.id.llbksq5);
        llB6 = findViewById(R.id.llbksq6);

        llI1 = findViewById(R.id.lliksq1);
        llI2 = findViewById(R.id.lliksq2);
        llI3 = findViewById(R.id.lliksq3);
        llI4 = findViewById(R.id.lliksq4);
        llI5 = findViewById(R.id.lliksq5);
        llI6 = findViewById(R.id.lliksq6);

        txtB1 = findViewById(R.id.txtBksq1);
        txtB2 = findViewById(R.id.txtBksq2);
        txtB3 = findViewById(R.id.txtBksq3);
        txtB4 = findViewById(R.id.txtBksq4);
        txtB5 = findViewById(R.id.txtBksq5);
        txtB6 = findViewById(R.id.txtBksq6);

        txtI1 = findViewById(R.id.txtiksq1);
        txtI2 = findViewById(R.id.txtiksq2);
        txtI3 = findViewById(R.id.txtiksq3);
        txtI4 = findViewById(R.id.txtiksq4);
        txtI5 = findViewById(R.id.txtiksq5);
        txtI6 = findViewById(R.id.txtiksq6);

        checkBox = findViewById(R.id.checkbox);

        llbsq = findViewById(R.id.llbsq);
        etbsq = findViewById(R.id.etbsq);
        txtbsq = findViewById(R.id.txtbsq);
    }
}