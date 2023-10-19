package com.example.th4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openLayout(View view){
        int id = view.getId();
        Intent intent;
        if (id == R.id.bai1) {
            intent = new Intent(this, mainb1.class);
            startActivity(intent);
        } else if (id == R.id.bai2) {
            intent = new Intent(this, mainb2.class);
            startActivity(intent);
        } else if (id == R.id.exit) {
            finish();
        }
    }
}