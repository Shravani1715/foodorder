package com.sveri.foodapplicaion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, password;
    Button btnSubmit, btnNext;
    ImageView Iv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        password = findViewById(R.id.editTextPassword);
        btnSubmit = findViewById(R.id.buttonSubmit);
        btnNext = findViewById(R.id.buttonNext);
        Iv = findViewById(R.id.imageView3);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View  view) {
                Toast.makeText(MainActivity.this,"Submited",Toast.LENGTH_SHORT).show();
                //btnSubmit.setText("Submited");
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                  startActivity(intent);
            }
        });

    }

}

