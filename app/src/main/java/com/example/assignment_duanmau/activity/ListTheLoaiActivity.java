package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.assignment_duanmau.Adapter.TheLoaiAdapter;
import com.example.assignment_duanmau.DAO.TheLoaiDAO;
import com.example.assignment_duanmau.R;
import com.example.assignment_duanmau.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ListTheLoaiActivity extends AppCompatActivity {
    public static List<TheLoai> dsTheLoai = new ArrayList<>();
    ListView lvTheLoai;
    TheLoaiAdapter adapter = null;
    TheLoaiDAO theLoaiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai);
        setTitle("Thể loại");
        lvTheLoai=(ListView) findViewById(R.id.lvTheLoai);

        theLoaiDAO= new TheLoaiDAO(ListTheLoaiActivity.this);
        dsTheLoai=theLoaiDAO.getAllTheLoai();

        adapter= new TheLoaiAdapter(this,dsTheLoai);
        lvTheLoai.setAdapter(adapter);
        lvTheLoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(ListTheLoaiActivity.this, TheLoaiDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("MATHELOAI", dsTheLoai.get(position).getMaTheloai());
                b.putString("TENTHELOAI", dsTheLoai.get(position).getTenTheloai());
                b.putString("VITRI", String.valueOf(dsTheLoai.get(position).getViTri()));
                b.putString("MOTA", dsTheLoai.get(position).getMoTa());
                intent.putExtras(b);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_theloai, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.themtheloai:
                Intent intent = new Intent(ListTheLoaiActivity.this, ThemTheLoaiActivity.class);
                startActivity(intent);
                return (true);


            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dsTheLoai.clear();
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter.changeDataset(dsTheLoai);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Chọn thông tin");
    }
}