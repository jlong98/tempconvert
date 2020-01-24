package com.example.tempconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText fahBox;
    private EditText celBox;
    private RadioButton FtoCRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fahBox = findViewById(R.id.Fahbox);
        celBox = findViewById(R.id.Celbox);
        FtoCRadio = findViewById(R.id.FtoCRadio);


    }
public void convert(View v){
        if(FtoCRadio.isChecked()) {
            String input = fahBox.getText().toString();
            if(input.length()>0) {
                double fahValue = Double.parseDouble(input);
                double celValue = (fahValue - 32) * 5.0 / 9.0;
                celBox.setText(String.format("%.1f", celValue));
            }else{
                Toast.makeText(this, "No Fahrenheit Value entered",Toast.LENGTH_SHORT).show();
            }
        }else{
            String input = celBox.getText().toString();
            if(input.length()>0) {
                double celValue = Double.parseDouble(input);
                double fahValue = (celValue * 9.0 / 5.0) + 32;
                fahBox.setText(String.format("%.1f", fahValue));
            }else{
                Toast.makeText(this, "No Celsius Value entered", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
