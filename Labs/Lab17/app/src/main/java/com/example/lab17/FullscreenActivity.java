package com.example.lab17;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    private EditText etPartPrice;
    private EditText etPartQuantity;
    private Button btnCalculate;
    private TextView tvTotalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        etPartPrice = findViewById(R.id.etPartPrice);
        etPartQuantity = findViewById(R.id.etPartQuantity);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvTotalCost = findViewById(R.id.tvTotalCost);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotalCost();
            }
        });
    }

    private void calculateTotalCost() {
        double partPrice = Double.parseDouble(etPartPrice.getText().toString());
        int partQuantity = Integer.parseInt(etPartQuantity.getText().toString());

        double totalCost = partPrice * partQuantity;

        tvTotalCost.setText("Общая стоимость: " + totalCost);
    }
}