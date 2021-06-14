package com.example.myintentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv1);
    }

    public void startButtonClicked(View view) {
        //Create intent
        Intent intent = new Intent(this, EditActivity.class);

        //Add the text of the TV to the intent
        String text;
        text = tv.getText().toString();
        intent.putExtra("my_text",text);
        //start the activity
        startActivityForResult(intent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000 && resultCode==RESULT_OK){
            String text = data.getStringExtra("result_text");
            tv.setText(text);
        }

    }
}