package com.example.lab08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //初始化Activity
        setContentView(R.layout.activity_main);    //連結activity_main.xml畫面

        Button button = findViewById(R.id.button); //連結Button元件

        //Button點擊事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent); //啟動Service
                Toast.makeText(MainActivity.this, "啟動Service", Toast.LENGTH_SHORT).show();
                finish(); //關閉Activity
            }
        });
    }
}