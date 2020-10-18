package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.assignment_duanmau.Adapter.CartAdapter;
import com.example.assignment_duanmau.DAO.HoaDonChiTietDAO;
import com.example.assignment_duanmau.R;
import com.example.assignment_duanmau.model.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;

public class ListHDCTByIDActivity extends AppCompatActivity {
    public List<HoaDonChiTiet> dsHDCT = new ArrayList<>();
    ListView lvCart;
    CartAdapter adapter = null;
    HoaDonChiTietDAO hoaDonChiTietDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_h_d_c_t_by_i_d);
        setTitle("HOÁ ĐƠN CHI TIẾT");
        lvCart = (ListView) findViewById(R.id.lvHoaDonChiTiet);
        hoaDonChiTietDAO = new HoaDonChiTietDAO(ListHDCTByIDActivity.this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            dsHDCT =
                    hoaDonChiTietDAO.getAllHoaDonChiTietByID(b.getString("MAHOADON"));
        }
        adapter = new CartAdapter(this, dsHDCT);
        lvCart.setAdapter(adapter);
    }
}