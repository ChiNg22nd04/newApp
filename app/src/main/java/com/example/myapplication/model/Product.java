package com.example.myapplication.model;

import java.io.Serializable;

public class Product implements Serializable {
    int id;

    @Override
    public String toString() {
        return
                "tenSP='" + tenSP + '\'' +
                ", giaSP='" + giaSP + '\'' +
                ", motaSP='" + motaSP + '\'' +
                ", hinhanhSP='" + hinhanhSP + '\''
                ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public String getMotaSP() {
        return motaSP;
    }

    public void setMotaSP(String motaSP) {
        this.motaSP = motaSP;
    }

    public String getHinhanhSP() {
        return hinhanhSP;
    }

    public void setHinhanhSP(String hinhanhSP) {
        this.hinhanhSP = hinhanhSP;
    }

    public Product(int id, int loai, String tenSP, String giaSP, String motaSP, String hinhanhSP) {
        this.id = id;
        this.loai = loai;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.motaSP = motaSP;
        this.hinhanhSP = hinhanhSP;
    }

    public Product() {
    }

    int loai;
    String tenSP;
    String giaSP;
    String motaSP;
    String hinhanhSP;

}
