package com.example.th4;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Arrays;

public class mainb2 extends AppCompatActivity {
    private Button btnNhap, btnDong;
    private RadioGroup radioGroup;
    private Button btnSort;
    private TextView tvResult,tv;
    private static final int REQUEST_CODE_NHAP = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainb2);
        btnNhap= findViewById(R.id.btnNhap);
        radioGroup = findViewById(R.id.radioGroup);
        btnSort = findViewById(R.id.btnSort);
        tvResult = findViewById(R.id.tvResult);
        btnDong= findViewById(R.id.btnDong);
        tv = findViewById(R.id.tv);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainb2.this, mainb2_nhap.class);
                startActivityForResult(intent, REQUEST_CODE_NHAP);
            }
        });
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numbersString = tv.getText().toString().trim();
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String sortAlgorithm = selectedRadioButton.getText().toString();
                try{
                    String[] numbersArray = numbersString.split(" ");
                    int[] numbers = new int[numbersArray.length];

                    for (int i = 0; i < numbersArray.length; i++) {

                        numbers[i] = Integer.parseInt(numbersArray[i]);
                    }

                    sortNumbers(numbers, sortAlgorithm);

                    String result = Arrays.toString(numbers);
                    tvResult.setText("Dãy số được sắp xếp theo giải thuật " + sortAlgorithm + ": " + result);
                }
                catch (Exception ex){
                    tvResult.setText("Vui lòng nhập dãy số và chọn giải thuật");
                }
            }
        });
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    private void sortNumbers(int[] numbers, String sortAlgorithm) {
        if (sortAlgorithm.equals("Selection Sort")) {
            selectionSort(numbers);
        } else if (sortAlgorithm.equals("Bubble Sort")) {
            bubbleSort(numbers);
        } else if (sortAlgorithm.equals("Interchange Sort")) {
            interchangeSort(numbers);
        }
    }

    private void selectionSort(int[] numbers) {
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }
    }

    private void bubbleSort(int[] numbers) {
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    private void interchangeSort(int[] numbers) {
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NHAP && resultCode == RESULT_OK) {
            String numbers = data.getStringExtra("list");
            tv.setText(numbers);
        }
    }
}