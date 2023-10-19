package com.example.th4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mainb1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainb1);
        final Button button = (Button) findViewById(R.id.btn);
        final TextView result = (TextView) findViewById(R.id.textresult);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override

            public void onClick(View v) {

                String sa = ((EditText) findViewById(R.id.edita)).getText().toString();

                String sb = ((EditText) findViewById(R.id.editb)).getText().toString();

                String sc = ((EditText) findViewById(R.id.editc)).getText().toString();

                String sd = ((EditText) findViewById(R.id.editd)).getText().toString();
                try

                {

                    int a = Integer.parseInt(sa);

                    int b = Integer.parseInt(sb);

                    int c = Integer.parseInt(sc);

                    int d = Integer.parseInt(sd);

                    PhanSo phanSo1=new PhanSo(a,b);
                    PhanSo phanSo2=new PhanSo(c,d);
                    result.setText(phanSo1.congPhanSo(phanSo2));
                } catch (Exception ex)
                {
                    result.setText(ex.toString());
                }
            }
        });

    }
    public void goBackToMainActivity(View view) {
        finish();
    }

}
