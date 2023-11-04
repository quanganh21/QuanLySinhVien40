package com.example.QuanLySinhVien;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends javafx.application.Application {
    static ArrayList<SinhVien> sv = new ArrayList<>();
    static ArrayList<MonHoc> monhoc = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        monhoc.add(new MonHoc("Java Basic"));
        monhoc.add(new MonHoc("C# Basic"));
        monhoc.add(new MonHoc("C++ Basic"));
        monhoc.add(new MonHoc("Python Basic"));
        monhoc.add(new MonHoc("Linux Basic"));
        sv.add(new SinhVien("1", "Nguyen Van A", "12A", "Khoa A", "123456789", "Hanoi"));
        sv.add(new SinhVien("2", "Nguyen Van B", "12B", "Khoa B", "987654321", "HCM"));
        sv.add(new SinhVien("3", "Nguyen Van C", "12C", "Khoa C", "456123789", "Danang"));
        sv.add(new SinhVien("4", "Nguyen Van D", "12D", "Khoa D", "789123456", "Hue"));
        sv.add(new SinhVien("5", "Nguyen Van E", "12E", "Khoa E", "321654987", "Vinh"));
        sv.get(0).getDanhSachMonHoc().add(monhoc.get(0));
        sv.get(0).getDanhSachMonHoc().get(0).setDiemQuaTrinh(8);
        sv.get(0).getDanhSachMonHoc().get(0).setDiemGiuaKy(5);
        sv.get(0).getDanhSachMonHoc().get(0).setDiemCuoiKy(7);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FormTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 520);
        stage.setTitle("Quản Lý Sinh Viên");
        stage.setScene(scene);
        FormTableController ctr = fxmlLoader.getController();
        ctr.loadTable();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}