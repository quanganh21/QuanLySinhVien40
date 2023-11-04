package com.example.QuanLySinhVien;

import java.util.ArrayList;

public class SinhVien {

    private String maSV;
    private String hoTen;
    private String lop;
    private String khoa;
    private String sdt;
    private String diaChi;
    private ArrayList<MonHoc> danhSachMonHoc;

    public SinhVien() {
        // Constructor mặc định
    }

    public SinhVien(String maSV, String hoTen, String lop, String khoa, String sdt, String diaChi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.khoa = khoa;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.danhSachMonHoc = new ArrayList<>();
    }
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    // Getter và setter cho hoTen
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    // Getter và setter cho lop
    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    // Getter và setter cho khoa
    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    // Getter và setter cho sdt
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ArrayList<MonHoc> getDanhSachMonHoc() {
        return this.danhSachMonHoc;
    }

    public double diemTB(){
        if (this.getDanhSachMonHoc().size() != 0){
            double s = 0;
            for (MonHoc o:this.getDanhSachMonHoc())
            {
                s += o.diemTB();
            }
            return s/this.getDanhSachMonHoc().size();
        }else return 0;
    }

    public String DanhGia(){
        double tb = this.diemTB();
        if (tb >= 8) return "Giỏi";
        else if (tb >= 6.5) return "Khá";
        else if (tb >= 5) return "Trung Bình";
        else return "Yếu";
    }
}
