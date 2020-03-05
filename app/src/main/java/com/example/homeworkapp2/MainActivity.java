package com.example.homeworkapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EditText_id;
    EditText EditText_password;
    String check_id="wnsgk42";
    String check_password="123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText_id=findViewById(R.id.EditText_id);
        EditText_password=findViewById(R.id.EditText_password);

        Button Button_login=findViewById(R.id.Button_login);

        Button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=EditText_id.getText().toString();
                String password=EditText_password.getText().toString();

                Intent intent =new Intent(MainActivity.this, MainContext.class);
               if(id.equals(check_id)&& password.equals(check_password)){
                   // Intent intent =new Intent(MainActivity.this, MainContext.class);
                    startActivity(intent);
               }else{
                    Toast.makeText(getApplicationContext(),"ID 혹은 PASSWORD가 틀렸습니다!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
