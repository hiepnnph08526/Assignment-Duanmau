package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_duanmau.Adapter.CartAdapter;
import com.example.assignment_duanmau.DAO.HoaDonChiTietDAO;
import com.example.assignment_duanmau.DAO.SachDAO;
import com.example.assignment_duanmau.R;
import com.example.assignment_duanmau.model.HoaDon;
import com.example.assignment_duanmau.model.HoaDonChiTiet;
import com.example.assignment_duanmau.model.Sach;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDonDetailActivity extends AppCompatActivity {
    EditText edMaSach, edMaHoaDon, edSoLuong;
    TextView tvThanhTien;
    HoaDonChiTietDAO hoaDonChiTietDAO;
    SachDAO sachDAO;
    public List<HoaDonChiTiet> dsHDCT = new ArrayList<>();
    ListView lvCart;
    CartAdapter adapter = null;
    double thanhTien = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_detail);
        setTitle("Hóa đơn chi tiết");

        edMaHoaDon=(EditText) findViewById(R.id.edMaHoaDon);
        edMaSach=(EditText) findViewById(R.id.edMaSach);
        edSoLuong=(EditText) findViewById(R.id.edSoLuong);
        lvCart= (ListView) findViewById(R.id.lvCart);
        tvThanhTien= (TextView) findViewById(R.id.tvThanhTien);

        adapter = new CartAdapter(this, dsHDCT);
        lvCart.setAdapter(adapter);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            edMaHoaDon.setText(b.getString("MAHOADON"));
        }
    }

    public void ADDHDCT(View view) {
        hoaDonChiTietDAO = new HoaDonChiTietDAO(HoaDonDetailActivity.this);
        sachDAO = new SachDAO(HoaDonDetailActivity.this);
        try {
            if (validation() < 0) {
                Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                Sach sach = sachDAO.getSachByID(edMaSach.getText().toString());
                if (sach!=null){
                    int pos = checkMaSach(dsHDCT,edMaSach.getText().toString());
                    HoaDon hoaDon = new HoaDon(edMaHoaDon.getText().toString(),new Date());
                    HoaDonChiTiet hoaDonChiTiet = new
                            HoaDonChiTiet(1,hoaDon,sach,Integer.parseInt(edSoLuong.getText().toString()));
                    if (pos>=0){
                        int soluong = dsHDCT.get(pos).getSoLuongMua();
                        hoaDonChiTiet.setSoLuongMua(soluong +
                                Integer.parseInt(edSoLuong.getText().toString()));
                        dsHDCT.set(pos,hoaDonChiTiet);
                    }else {
                        dsHDCT.add(hoaDonChiTiet);
                    }
                    adapter.changeDataset(dsHDCT);
                }else {
                    Toast.makeText(getApplicationContext(),"Mã sách không tồn tại",Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
    public int checkMaSach(List<HoaDonChiTiet> lsHD, String maSach){
        int pos = -1;
        for (int i = 0; i < lsHD.size(); i++){
            HoaDonChiTiet hd = lsHD.get(i);
            if (hd.getSach().getMaSach().equalsIgnoreCase(maSach)){
                pos = i;
                break;
            }
        }
        return pos;
    }
    public int validation(){
        if
        (edMaSach.getText().toString().isEmpty()||edSoLuong.getText().toString().isEmpty()||
                edMaHoaDon.getText().toString().isEmpty()){
            return -1;
        }
        return 1;
    }

    public void ThanhToan(View view) {
        hoaDonChiTietDAO = new HoaDonChiTietDAO(HoaDonDetailActivity.this);
        //tinh tien
        thanhTien = 0;
        try {
            for (HoaDonChiTiet hd: dsHDCT) {
                hoaDonChiTietDAO.inserHoaDonChiTiet(hd);
                thanhTien = thanhTien + hd.getSoLuongMua() *
                        hd.getSach().getGiaBia();
            }
            tvThanhTien.setText("Tổng tiền: " +thanhTien);
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
}
