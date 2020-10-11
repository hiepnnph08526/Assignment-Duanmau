package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.assignment_duanmau.DAO.TheLoaiDAO;
import com.example.assignment_duanmau.R;
import com.example.assignment_duanmau.model.TheLoai;

public class ThemTheLoaiActivity extends AppCompatActivity {
    Button btnThemTheLoai;
    EditText edMaTheLoai,edTenTheLoai,edViTri,edMota;
    TheLoaiDAO theLoaiDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_the_loai);
        setTitle("Thêm thể loại");

        btnThemTheLoai= findViewById(R.id.themtheloai);

        edMaTheLoai=findViewById(R.id.edMaTheLoai);
        edTenTheLoai=findViewById(R.id.edTenTheLoai);
        edViTri= findViewById(R.id.edViTri);
        edMota = findViewById(R.id.edMoTa);

    }

    public void themtheloai(View view) {
        theLoaiDAO = new TheLoaiDAO(ThemTheLoaiActivity.this);
        TheLoai user = new TheLoai(
                edMaTheLoai.getText().toString(), edTenTheLoai.getText().toString(),edMota.getText().toString(),edViTri.getText().toString());
        try {
            if (validateForm() > 0) {
                if (theLoaiDAO.inserTheLoai(user) > 0) {
                    onBackPressed();
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Lỗi:", ex.toString());
        }
    }

    public int validateForm() {
        int check = 1;
        if (edMaTheLoai.getText().length() == 0 || edTenTheLoai.getText().length() == 0
                || edViTri.getText().length() == 0 || edMota.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}