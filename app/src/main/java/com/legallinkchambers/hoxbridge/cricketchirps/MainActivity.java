package com.legallinkchambers.hoxbridge.cricketchirps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText numOfChirps;
    Button calcTemp;
    TextView tvResults;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        numOfChirps = findViewById(R.id.numOfChirps);
        calcTemp = findViewById(R.id.calcTemp);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.00");

        calcTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOfChirps.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }else{
                    int chirps = Integer.parseInt(numOfChirps.getText().toString().trim());
                    double temp = (chirps / 3.0) + 4;
                    String results = "The approximate temperature outside is " + formatter.format(temp) + " degrees Celsius!";

                    tvResults.setText(results);
                    tvResults.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
