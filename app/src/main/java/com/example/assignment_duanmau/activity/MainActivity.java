package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.assignment_duanmau.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Quản lí sách");
    }

    public void nguoidung(View view) {
        Intent i = new Intent(MainActivity.this,ListNguoiDungActivity.class);
        startActivity(i);
    }
    public void theloai(View view) {
        Intent i = new Intent(MainActivity.this,ListTheLoaiActivity.class);
        startActivity(i);
    }
    public void sach(View view) {
        Intent i = new Intent(MainActivity.this,ListSachActivity.class);
        startActivity(i);
    }
    public void hoadon(View view) {
        Intent i = new Intent(MainActivity.this,ListHoaDonActivity.class);
        startActivity(i);
    }
    public void banchay(View view) {
        Intent i = new Intent(MainActivity.this,ListBanChayActivity.class);
        startActivity(i);
    }
    public void thongke(View view) {
        Intent i = new Intent(MainActivity.this,ListThongKeActivity.class);
        startActivity(i);
    }
}