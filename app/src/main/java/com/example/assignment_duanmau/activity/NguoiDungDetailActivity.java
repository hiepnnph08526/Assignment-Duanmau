package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_duanmau.DAO.NguoiDungDAO;
import com.example.assignment_duanmau.R;

public class NguoiDungDetailActivity extends AppCompatActivity {
    EditText edFullName, edPhone;
    TextView edUsername,edPassword;
    NguoiDungDAO nguoiDungDAO;
    String username,fullname,phone,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung_detail);
        setTitle("Chi tiết người dùng");

        edFullName = findViewById(R.id.edFullname);
        edPhone= findViewById(R.id.edPhone);
        edUsername=findViewById(R.id.edUsername);
        edPassword=findViewById(R.id.edPassword);

        nguoiDungDAO = new NguoiDungDAO(this);
        Intent in = getIntent();
        Bundle b=in.getExtras();
        fullname=b.getString("FULLNAME");
        phone=b.getString("PHONE");
        username=b.getString("USERNAME");
        password=b.getString("PASSWORD");

        edFullName.setText(fullname);
        edPhone.setText(phone);
        edUsername.setText("Tài khoản:"+username);
        edPassword.setText("Mật khẩu:"+password);

    }

    public void updateUser(View view) {
        if(nguoiDungDAO.updateInfoNguoiDung(username,edPhone.getText().toString(),edFullName.getText().toString())>0){
            Toast.makeText(getApplicationContext(),"Lưu thành công",Toast.LENGTH_SHORT).show();
            finish();
        }
    }


}