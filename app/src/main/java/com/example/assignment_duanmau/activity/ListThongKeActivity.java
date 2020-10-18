package com.example.assignment_duanmau.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.assignment_duanmau.DAO.HoaDonChiTietDAO;
import com.example.assignment_duanmau.R;

public class ListThongKeActivity extends AppCompatActivity {
    TextView tvNgay, tvThang, tvNam;
    HoaDonChiTietDAO hoaDonChiTietDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_thong_ke);
        setTitle("Thống kê doanh thu");
        tvNgay = (TextView) findViewById(R.id.tvThongKeNgay);
        tvThang = (TextView) findViewById(R.id.tvThongKeThang);
        tvNam = (TextView) findViewById(R.id.tvThongKeNam);

        hoaDonChiTietDAO = new HoaDonChiTietDAO(this);

        tvNgay.setText("Hôm nay      : " + hoaDonChiTietDAO.getDoanhThuTheoNgay()+"VNĐ");
        tvThang.setText("Tháng này   : " + hoaDonChiTietDAO.getDoanhThuTheoThang()+"VNĐ");
        tvNam.setText("Năm này       : " + hoaDonChiTietDAO.getDoanhThuTheoNam()+"VNĐ");
    }



    }
