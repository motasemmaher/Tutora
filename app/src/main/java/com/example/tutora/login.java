package com.example.tutora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tutora.models.sampledata.Login;
import com.example.tutora.models.sampledata.Student;

import java.io.Serializable;

public class login extends AppCompatActivity {
    LinearLayout btnback;
    Button btnLogin;
    EditText pass,user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnback = findViewById(R.id.back);
        btnLogin = findViewById(R.id.btnlogin);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),landing.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(getApplicationContext());
                pass = findViewById(R.id.pass);
                user = findViewById(R.id.user);
                if(student.isExist(user.getText().toString(),pass.getText().toString())){
                    Login login = new Login(getApplicationContext());
                    login.insertI(user.getText().toString());
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid username or password!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
