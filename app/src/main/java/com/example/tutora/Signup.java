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

public class Signup extends AppCompatActivity {
    LinearLayout back;
    EditText username,email,password,repassword;
    Button btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        back = findViewById(R.id.back);
        btnSignup = findViewById(R.id.signup);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),landing.class);
                startActivity(intent);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username =findViewById(R.id.username);
                email = findViewById(R.id.email);
                password =findViewById(R.id.password);
                repassword = findViewById(R.id.repassword);
                Student student = new Student(getApplicationContext());
                if(password.getText().toString().equals(repassword.getText().toString())){
                    if (student.insert(username.getText().toString(),email.getText().toString(),password.getText().toString(),R.drawable.account)){
                        Login login = new Login(getApplicationContext());
                        login.insertI(username.getText().toString());
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"username is not valid!",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"not same password!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
