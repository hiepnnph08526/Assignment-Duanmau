package com.example.assignment_duanmau.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment_duanmau.DAO.NguoiDungDAO;
import com.example.assignment_duanmau.R;
import com.example.assignment_duanmau.model.NguoiDung;

public class DangKiActivity extends AppCompatActivity {
    Button btnDangki;
    NguoiDungDAO nguoiDungDAO;
    EditText edTaiKhoan, edPass,edRePass, edPhone, edFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_dang_ki);

        btnDangki= findViewById(R.id.btnDangki);
        edTaiKhoan=findViewById(R.id.edTaiKhoan);
        edPass=findViewById(R.id.edPass);
        edRePass=findViewById(R.id.edPass1);
        edPhone=findViewById(R.id.edPhone);
        edFullName=findViewById(R.id.edHoten);
    }


    public void addUser(View view) {
        nguoiDungDAO  = new NguoiDungDAO(DangKiActivity.this);
        NguoiDung nguoiDung=new NguoiDung(
                edTaiKhoan.getText().toString(),edPass.getText().toString() ,edPhone.getText().toString(),
                edFullName.getText().toString());
        try{
            if(validateForm()>0){
               if(nguoiDungDAO.inserNguoiDung(nguoiDung)>0){
                   Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
               }
            }
        }catch (Exception ex){
            Log.e("Error", ex.toString());
        }

    }

    public  int validateForm(){
        int check =1;
        if(edTaiKhoan.getText().length()==0||
                edPass.getText().length()==0||edRePass.getText().length()==0||
                edFullName.getText().length()==0||edPhone.getText().length()==0){
            Toast.makeText(getApplicationContext(),"Hãy nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
            check=-1;

        }else{
            String pass = edPass.getText().toString();
            String rePass = edRePass.getText().toString();
            if(!pass.equals(rePass)){
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }
}