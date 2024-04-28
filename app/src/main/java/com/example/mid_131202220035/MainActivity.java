package com.example.mid_131202220035;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editNilai, editNilai2, txtHasilPerhitungan;
    private RadioGroup radioGroup;
    private Button btnClear;
    private double hasil=0;
    private boolean pilihOperasi = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNilai = findViewById(R.id.Nilai1);
        editNilai2 = findViewById(R.id.Nilai2);
        txtHasilPerhitungan = findViewById(R.id.hitung);
        radioGroup = findViewById(R.id.rgMTK);
        btnClear = findViewById(R.id.button);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                editNilai.setText("");
                editNilai2.setText("");
                txtHasilPerhitungan.setText("");
                radioGroup.clearCheck();
                pilihOperasi = false;
            }

        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                pilihOperasi = true;
                hitung();
            }
        });

    }

    public void hitung() {
        if(!pilihOperasi || editNilai.getText().toString().isEmpty() ||editNilai2.getText().toString().isEmpty()) {

            return;
        }

        double nilai1 = Double.parseDouble(editNilai.getText().toString());
        double nilai2 = Double.parseDouble(editNilai2.getText().toString());

        if(radioGroup.getCheckedRadioButtonId() == R.id.rbTambah) {
            hasil = nilai1 + nilai2;
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.rbKurang) {
            hasil = nilai1 - nilai2;
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.rbKali) {
            hasil = nilai1 * nilai2;
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.rbBagi) {
            hasil = nilai1/nilai2;
        }
        txtHasilPerhitungan.setText(String.valueOf(hasil));
    }
}