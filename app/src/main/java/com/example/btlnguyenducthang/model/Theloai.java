package com.example.btlnguyenducthang.model;

public class Theloai {
    int idTheLoai;
    String tenTheLoai;
    String hinhTheLoai;
    private Chude idChuDe;

    public int getIdTheLoai() {
        return idTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public String getHinhTheLoai() {
        return hinhTheLoai;
    }

    public void setIdTheLoai(int idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public void setHinhTheLoai(String hinhTheLoai) {
        this.hinhTheLoai = hinhTheLoai;
    }
}
