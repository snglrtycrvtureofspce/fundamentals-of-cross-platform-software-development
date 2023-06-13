package com.example.lab17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etPartName;
    private EditText etPartCost;
    private Button btnAddPart;
    private TextView tvTotalCost;

    private double totalCost = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPartName = findViewById(R.id.et_part_name);
        etPartCost = findViewById(R.id.et_part_cost);
        btnAddPart = findViewById(R.id.btn_add_part);
        tvTotalCost = findViewById(R.id.tv_total_cost);

        btnAddPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String partName = etPartName.getText().toString();
                double partCost = Double.parseDouble(etPartCost.getText().toString());

                totalCost += partCost;
                tvTotalCost.setText(String.format("Total Cost: $%.2f", totalCost));

                etPartName.setText("");
                etPartCost.setText("");
            }
        });
    }
}