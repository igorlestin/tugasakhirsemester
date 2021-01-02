package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    private Button calculateBtn;
    private EditText input_weight;
    private TextView suggestTextView;

    static {
        System.loadLibrary("watercalc-jni");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_calculator);
        setTitle(R.string.calculator_menu_label);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calculateBtn = findViewById(R.id.btn_calculate);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    input_weight = findViewById(R.id.et_weight_calculator);
                    int uWeight = Integer.parseInt(input_weight.getText().toString());
                    int target = calculateTarget(uWeight);
                    suggestTextView = findViewById(R.id.tv_result);
                    Log.d("WaterCalculator", "input " +  input_weight.getText() + ", suggest daily intake " + Integer.toString(target/10 - target/3) + " jam");
                    suggestTextView.setText(Integer.toString(target)+" jam");
                } catch (NumberFormatException e) {
                    Log.d("WaterCalculator", " "+ e);
                    Toast.makeText(CalculatorActivity.this, "Enter number!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public native int calculateTarget(int weight);
}
