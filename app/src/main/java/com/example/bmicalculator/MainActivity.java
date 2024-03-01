package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText editWeight;
        EditText editHeightFt;
        EditText editHeightIn;
        Button btn;
        LinearLayout mainBG;

        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightIn = findViewById(R.id.editHeightIn);
        btn = findViewById(R.id.btn);
        txtResult = findViewById(R.id.txtResult);
        mainBG = findViewById(R.id.mainBG);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt = Integer.parseInt(editWeight.getText().toString());
               int ft = Integer.parseInt(editHeightFt.getText().toString());
               int in = Integer.parseInt(editHeightIn.getText().toString());

               int totalIn = ft*12 + in;
               double totalCm = totalIn*2.53;
               double totalM = totalCm/100;
               double bmi = wt/(totalM*totalM);

                if (bmi>25){
                    txtResult.setText("You'r Over-weight!");
                    mainBG.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi<18) {
                    txtResult.setText("You'r Under-weight!");
                    mainBG.setBackgroundColor(getResources().getColor(R.color.colorUW));
                } else {
                    txtResult.setText("You'r Healthy!");
                    mainBG.setBackgroundColor(getResources().getColor(R.color.colorH));
                }


            }
        });



    }
}