package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment_duanmau.DAO.NguoiDungDAO;
import com.example.assignment_duanmau.R;
import com.example.assignment_duanmau.model.NguoiDung;

public class DoiMatKhauActivity extends AppCompatActivity {
    EditText edPass, edRePass, edUser;
    NguoiDungDAO nguoiDungDAO;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        setTitle("Đổi mật khẩu");
        edUser = findViewById(R.id.edTaiKhoan1);
        edPass = (EditText) findViewById(R.id.edPassnew);
        edRePass = (EditText) findViewById(R.id.edRePassnew);

        nguoiDungDAO= new NguoiDungDAO(this);

    }

    public int validateForm() {
        int check = 1;
        if (edPass.getText().length() == 0 || edRePass.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edPass.getText().toString();
            String rePass = edRePass.getText().toString();
            if (!pass.equals(rePass)) {
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }


    public void changePassword(View view) {
        String mkmoi = edPass.getText().toString();

        if (nguoiDungDAO.changePasswordNguoiDung(edUser.getText().toString(),mkmoi)>=0) {
            Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
        }
        else
            {
                    Toast.makeText(getApplicationContext(), "Lưu thất bại", Toast.LENGTH_SHORT).show();
                }


    }

}