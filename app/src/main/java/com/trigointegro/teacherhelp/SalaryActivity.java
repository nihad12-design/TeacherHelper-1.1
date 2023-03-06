package com.trigointegro.teacherhelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SalaryActivity extends AppCompatActivity {

    int cem = 0;
    CardView btn;
    EditText etStaj, etLisey, etAdi, etEvezicilik;
    SwitchCompat swRehber, swTehsil;
    TextView amtxt, gvtxt, htxt, dtxt, tstxt, istxt, cttxt, hmtxt;
    Dialog dialog;
    Button dbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);
        init();


        btn.setOnClickListener(v -> {
            cem = 0;

            if (etStaj.getText().toString().isEmpty() && etStaj.getText().toString().equals("")) {
                Toast.makeText(SalaryActivity.this, "Stajı daxil edin", Toast.LENGTH_SHORT).show();
            } else {
                if (swRehber.isChecked()) {
                    cem = 40;
                } else {
                    cem = 0;
                }
                if (swTehsil.isChecked()) {
                    ali();
                } else {
                    orta();
                }
            }
        });

        dbtn.setOnClickListener(v -> dialog.cancel());

    }

    private void ali() {

        int a = convert(etStaj.getText().toString());
        int b = convert(etLisey.getText().toString());
        int c = convert(etAdi.getText().toString());
        int k = convert(etEvezicilik.getText().toString());
        double s = 0.0;

        if (b + c + k > 36) {
            Toast.makeText(SalaryActivity.this, "Həftəlik dərs yükü 36 saatdan artıq ola bilməz", Toast.LENGTH_LONG).show();
            return;
        }

        double[] StavkaArrAli = {607, 653, 686, 732, 785};

        if (0 <= a && a <= 3) {
            s = ((StavkaArrAli[0] / 18 * b * 1.15) + (StavkaArrAli[0] / 18 * c) + (StavkaArrAli[0] / 76.2 * k)) + cem;
        } else if (3 < a && a <= 8) {
            s = ((StavkaArrAli[1] / 18 * b * 1.15) + (StavkaArrAli[1] / 18 * c) + (StavkaArrAli[1] / 76.2 * k)) + cem;
        } else if (8 < a && a <= 13) {
            s = ((StavkaArrAli[2] / 18 * b * 1.15) + (StavkaArrAli[2] / 18 * c) + (StavkaArrAli[2] / 76.2 * k)) + cem;
        } else if (13 < a && a <= 18) {
            s = ((StavkaArrAli[3] / 18 * b * 1.15) + (StavkaArrAli[3] / 18 * c) + (StavkaArrAli[3] / 76.2 * k)) + cem;
        } else if (a > 18) {
            s = ((StavkaArrAli[4] / 18 * b * 1.15) + (StavkaArrAli[4] / 18 * c) + (StavkaArrAli[4] / 76.2 * k)) + cem;
        }

        calc(s);
    }

    private void orta() {

        int a = convert(etStaj.getText().toString());
        int b = convert(etLisey.getText().toString());
        int c = convert(etAdi.getText().toString());
        int k = convert(etEvezicilik.getText().toString());
        double s = 0.0;

        if (b + c + k > 36) {
            Toast.makeText(SalaryActivity.this, "Həftəlik dərs yükü 36 saatdan artıq ola bilməz", Toast.LENGTH_LONG).show();
            return;
        }

        double[] StavkaArrOrta = {554, 587, 604, 647, 699};

        if (0 <= a && a <= 3) {
            s = ((StavkaArrOrta[0] / 18 * b * 1.15) + (StavkaArrOrta[0] / 18 * c) + (StavkaArrOrta[0] / 76.2 * k)) + cem;
        } else if (3 < a && a <= 8) {
            s = ((StavkaArrOrta[1] / 18 * b * 1.15) + (StavkaArrOrta[1] / 18 * c) + (StavkaArrOrta[1] / 76.2 * k)) + cem;
        } else if (8 < a && a <= 13) {
            s = ((StavkaArrOrta[2] / 18 * b * 1.15) + (StavkaArrOrta[2] / 18 * c) + (StavkaArrOrta[2] / 76.2 * k)) + cem;
        } else if (13 < a && a <= 18) {
            s = ((StavkaArrOrta[3] / 18 * b * 1.15) + (StavkaArrOrta[3] / 18 * c) + (StavkaArrOrta[3] / 76.2 * k)) + cem;
        } else if (a > 18) {
            s = ((StavkaArrOrta[4] / 18 * b * 1.15) + (StavkaArrOrta[4] / 18 * c) + (StavkaArrOrta[4] / 76.2 * k)) + cem;
        }

        calc(s);
    }

    @SuppressLint("DefaultLocale")
    private void calc(double s) {
        double t, h;

        if (s < 200) {
            t = s - s * 0.075;
            h = 0;
        } else {
            t = s - (s - 200) * 0.14 - s * 0.075;
            h = (s - 200) * 0.14;
        }
        hmtxt.setText(String.format("%.2f", s));
        amtxt.setText(String.format("%.2f", t));
        gvtxt.setText(String.format("%.2f", h));
        htxt.setText(String.format("%.2f", s * 0.02));
        dtxt.setText(String.format("%.2f", s * 0.03));
        tstxt.setText(String.format("%.2f", s * 0.02));
        istxt.setText(String.format("%.2f", s * 0.005));
        cttxt.setText(String.format("%.2f", s - t));
        dialog.show();
    }

    private void init() {
        btn = findViewById(R.id.btn);
        etStaj = findViewById(R.id.etStaj);
        etLisey = findViewById(R.id.etLisey);
        etAdi = findViewById(R.id.etAdi);
        etEvezicilik = findViewById(R.id.etEvezicilik);
        swRehber = findViewById(R.id.swRehber);
        swTehsil = findViewById(R.id.swTehsil);

        init_dialog();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void init_dialog() {
        // Start Dialog
        dialog = new Dialog(SalaryActivity.this);
        dialog.setContentView(R.layout.custon_layout);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        //End Dialog

        amtxt = dialog.findViewById(R.id.textView3);
        dbtn = dialog.findViewById(R.id.button);
        gvtxt = dialog.findViewById(R.id.textView11);
        htxt = dialog.findViewById(R.id.textView12);
        dtxt = dialog.findViewById(R.id.textView13);
        tstxt = dialog.findViewById(R.id.textView14);
        istxt = dialog.findViewById(R.id.textView15);
        cttxt = dialog.findViewById(R.id.textView16);
        hmtxt = dialog.findViewById(R.id.textView17);
    }


    public int convert(String str) {
        int val;


        try {
            val = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }

        return val;
    }
}