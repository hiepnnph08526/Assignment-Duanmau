package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment_duanmau.Adapter.SachAdapter;
import com.example.assignment_duanmau.DAO.SachDAO;
import com.example.assignment_duanmau.R;
import com.example.assignment_duanmau.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class ListBanChayActivity extends AppCompatActivity {
    public static List<Sach> dsSach = new ArrayList<>();
    ListView lvBook;
    SachAdapter adapter = null;
    SachDAO sachDAO;
    EditText edThang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ban_chay);
        setTitle("Bán chạy");
        lvBook = (ListView) findViewById(R.id.lvBookTop);
        edThang = (EditText) findViewById(R.id.edThang);
    }

    public void banchaytop10(View view) {
        if (Integer.parseInt(edThang.getText().toString()) > 13 ||
                Integer.parseInt(edThang.getText().toString()) < 0) {
            Toast.makeText(getApplicationContext(), "Không đúng định dạng tháng (1- 12)", Toast.LENGTH_SHORT).show();
        } else {
            sachDAO = new SachDAO(ListBanChayActivity.this);
            dsSach = sachDAO.getSachTop10(edThang.getText().toString());
            adapter = new SachAdapter(this, dsSach);
            lvBook.setAdapter(adapter);
        }
    }
}