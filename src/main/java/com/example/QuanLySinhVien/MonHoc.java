package com.example.QuanLySinhVien;

public class MonHoc {
    static int STT = 1;

    private int maMonHoc;
    private String tenMonHoc;
    private double diemQuaTrinh;
    private double diemGiuaKy;
    private double diemCuoiKy;
    private boolean daDangKi;

    public MonHoc() {
    }

    public MonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
        this.daDangKi = false;
        this.maMonHoc = STT;
        STT++;
    }

    public double diemTB() {
        return (diemQuaTrinh + diemGiuaKy + diemCuoiKy) / 3;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }
    public double getDiemQuaTrinh() {
        return diemQuaTrinh;
    }

    public void setDiemQuaTrinh(double diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
    }

    public double getDiemGiuaKy() {
        return diemGiuaKy;
    }

    public void setDiemGiuaKy(double diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }

    public double getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(double diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public boolean isDaDangKi() {
        return daDangKi;
    }

    public void setDaDangKi(boolean daDangKi) {
        this.daDangKi = daDangKi;
    }
}

