package com.example.th4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class mainb2_nhap extends AppCompatActivity {
    private EditText etNumbers;
    private Button btnNhapLai, btnTroVe;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainb2_nhap);
        etNumbers = findViewById(R.id.etNumbers);
        btnNhapLai = findViewById(R.id.nhaplai);
        btnTroVe = findViewById(R.id.buttonBack);
        tvResult = findViewById(R.id.tvResult);
        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numbersString = etNumbers.getText().toString();
                try {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("list", numbersString);
                    setResult(RESULT_OK, returnIntent);
                    finish();

                }
                catch (Exception ex){
                    tvResult.setText("Vui lòng nhập dãy số");
                }
            }
        });
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}