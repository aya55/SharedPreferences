package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Button button1=findViewById(R.id.save);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et=(EditText)findViewById(R.id.et1);
                SharedPreferences.Editor myedit=sharedPreferences.edit();
                myedit.putString("data",et.getText().toString());
                myedit.commit();
            }
        });
        Button button2=findViewById(R.id.load);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1=(EditText)findViewById(R.id.et2);
                  et1.setText(sharedPreferences.getString("data","empty"));

            }
        });
    }
}
