package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.assignment_duanmau.R;

public class DangNhapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_dang_nhap);
    }

    public void login(View view) {
        Intent i = new Intent(DangNhapActivity.this,MainActivity.class);
        startActivity(i);
    }

    public void dangki(View view) {
        Intent i = new Intent(DangNhapActivity.this,DangKiActivity.class);
        startActivity(i);
    }
}