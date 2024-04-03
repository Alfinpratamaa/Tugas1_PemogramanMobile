package com.alfinn.tugas1;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutNama;
    private TextInputLayout textInputLayoutKelas;
    private RadioGroup radioGroup;
    private RadioButton radioButtonLaki;
    private RadioButton radioButtonPerempuan;
    private CheckBox checkBoxKalkulus;
    private CheckBox checkBoxWebProgramming;
    private CheckBox checkBoxMatematika;
    private CheckBox checkBoxBahasaInggris;
    private Button submitButton;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        

        submitButton = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButton.setText("");
                submitButton.setEnabled(false);
                submitButton.setActivated(false);


                progressBar.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        submitButton.setEnabled(true);
                        submitButton.setActivated(true);
                        submitButton.setText("submit");
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Submit berhasil 😊😊", Toast.LENGTH_SHORT).show();
                        textInputLayoutNama.getEditText().setText("");
                        textInputLayoutNama.clearFocus();
                        textInputLayoutKelas.getEditText().setText("");
                        textInputLayoutKelas.clearFocus();
                        radioGroup.clearCheck();
                        checkBoxBahasaInggris.setChecked(false);
                        checkBoxKalkulus.setChecked(false);
                        checkBoxMatematika.setChecked(false);
                        checkBoxWebProgramming.setChecked(false);
                    }
                },3000);


            }
        });



        textInputLayoutNama = findViewById(R.id.nama);
        textInputLayoutKelas = findViewById(R.id.kelas);
        radioButtonLaki = findViewById(R.id.laki);
        radioButtonPerempuan = findViewById(R.id.perempuan);
        checkBoxKalkulus = findViewById(R.id.kalkulus);
        checkBoxWebProgramming = findViewById(R.id.webProgramming);
        checkBoxMatematika = findViewById(R.id.matematika);
        checkBoxBahasaInggris = findViewById(R.id.bInggris);
        radioGroup = findViewById(R.id.radioGroup);

        customize();

    }


    private void clearFocusFromTextInputLayout() {
        if (textInputLayoutNama.getEditText() != null) {
            textInputLayoutNama.getEditText().clearFocus();
        }
        if (textInputLayoutKelas.getEditText() != null) {
            textInputLayoutKelas.getEditText().clearFocus();
        }
    }

    private void customize(){

        // Set warna garis border TextInputLayout
        textInputLayoutNama.setBoxStrokeColorStateList(getResources().getColorStateList(R.color.primary));
        textInputLayoutKelas.setBoxStrokeColorStateList(getResources().getColorStateList(R.color.primary));

        // Set warna background RadioButton
        radioButtonLaki.setButtonTintList(getResources().getColorStateList(R.color.primary));
        radioButtonPerempuan.setButtonTintList(getResources().getColorStateList(R.color.primary));

        // Set warna background CheckBox
        checkBoxKalkulus.setButtonTintList(getResources().getColorStateList(R.color.primary));
        checkBoxWebProgramming.setButtonTintList(getResources().getColorStateList(R.color.primary));
        checkBoxMatematika.setButtonTintList(getResources().getColorStateList(R.color.primary));
        checkBoxBahasaInggris.setButtonTintList(getResources().getColorStateList(R.color.primary));
    }


}