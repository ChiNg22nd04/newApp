package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.GioHang;
import com.example.myapplication.model.Product;
import com.example.myapplication.utils.Utils;

import java.text.DecimalFormat;

public class DeteilActivity extends AppCompatActivity {

    TextView tensp, giasp, mota;
    Button btnThem;
    ImageView img;
    Spinner spinner;
    Toolbar toolbar;
    Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deteil);
        
        initView();
        initontrol();
        initData();
        actionToolbar();
    }

    private void initontrol() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.manggiohang.size() > 0) {

                    boolean flag = false;

                    int soLuong= Integer.parseInt(spinner.getSelectedItem().toString());
                        for(int i = 0; i < Utils.manggiohang.size(); i++) {
                            if (Utils.manggiohang.get(i).getIdsp() == product.getId()) {
                                Utils.manggiohang.get(i).setSoLuong(soLuong + Utils.manggiohang.get(i).getSoLuong());
                                long gia = Long.parseLong(product.getGiaSP()) * Utils.manggiohang.get(i).getSoLuong();
                                Utils.manggiohang.get(i).setGiasp(gia);
                                flag = true;
                            }
                        }
                        if (flag == false) {
                            long gia = Long.parseLong(product.getGiaSP()) * soLuong;
                            GioHang gioHang = new GioHang();
                            gioHang.setGiasp(gia);
                            gioHang.setSoLuong(soLuong);
                            gioHang.setIdsp(product.getId());
                            gioHang.setHinhsp(product.getHinhanhSP());
                            gioHang.setTensp(product.getTenSP());
                            Utils.manggiohang.add(gioHang);
                        }
                }else {
                    int soLuong= Integer.parseInt(spinner.getSelectedItem().toString());
                    long gia = Long.parseLong(product.getGiaSP()) * soLuong;
                    GioHang gioHang = new GioHang();
                    gioHang.setGiasp(gia);
                    gioHang.setSoLuong(soLuong);
                    gioHang.setIdsp(product.getId());
                    gioHang.setHinhsp(product.getHinhanhSP());
                    gioHang.setTensp(product.getTenSP());
                    Utils.manggiohang.add(gioHang);


                }
            }
        });
    }

    private void initData() {
         product = (Product) getIntent().getSerializableExtra("chitiet");
        tensp.setText(product.getTenSP());
        mota.setText(product.getMotaSP());
        Glide.with(getApplicationContext()).load(product.getHinhanhSP()).into(img);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        giasp.setText("Gía:"+decimalFormat.format(Double.parseDouble(product.getGiaSP())) + "Đ");

        //Chọn số lượng sp
        Integer[] soluong = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void actionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    private void initView() {
        tensp =findViewById(R.id.txtten);
        giasp =findViewById(R.id.txtgia);
        mota =findViewById(R.id.txtMotachitiet);
        btnThem =findViewById(R.id.btnThemvaogiohang);
        spinner =findViewById(R.id.spinner);
        img =findViewById(R.id.imgchitiet);
        toolbar =findViewById(R.id.toolbar);


    }
}