package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {


    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //test comment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        et = findViewById(R.id.et2);
        //Receive the intent used to start this activity
        Intent intent = getIntent();

        if(((Intent) intent).hasExtra("my_text")){
            String text = intent.getStringExtra("my_text");
            et.setText(text);
        }
    }

    public void sendClicked(View view) {
        String text = et.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result_text",text);
        setResult(Activity.RESULT_OK,resultIntent);
        finish();
    }
}