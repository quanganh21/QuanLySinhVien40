package com.example.QuanLySinhVien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.Comparator;

public class FormAddController {

    @FXML
    private Button ExitButton;
    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField AddMSSV;

    @FXML
    private  TextField AddTen;

    @FXML
    private  TextField AddLop;

    @FXML
    private  TextField AddKhoa;

    @FXML
    private  TextField AddSdt;

    @FXML
    private  TextField AddDiachi;

    Stage stage;

    public void add(ActionEvent e) {
        String MSSV;
        String Ten;
        String Lop;
        String Khoa;
        String Sdt;
        String Diachi;
        MSSV = AddMSSV.getText();
        Ten = AddTen.getText();
        Lop = AddLop.getText();
        Khoa = AddKhoa.getText();
        Sdt = AddSdt.getText();
        Diachi = AddDiachi.getText();
        if (MSSV.trim().isEmpty() || Ten.trim().isEmpty() || Lop.trim().isEmpty() || Khoa.trim().isEmpty() || Sdt.trim().isEmpty() || Diachi.trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Không được để trống");
            alert.setContentText("Vui lòng nhập đủ thông tin");
            alert.showAndWait();
        }else{
            boolean t = false;
            for (SinhVien o:Main.sv) {
                if (o.getMaSV().equals(MSSV)){
                    t = true;
                    break;
                }
            }
            if (t){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText("Trùng MSSV");
                alert.setContentText("Vui lòng nhập lại");
                alert.showAndWait();
            }else{
                SinhVien sv = new SinhVien(MSSV, Ten, Lop, Khoa, Sdt, Diachi);
                int index = Collections.binarySearch(Main.sv, sv, Comparator.comparing(SinhVien::getMaSV));
                if (index < 0) {
                    Main.sv.add(-index - 1, sv);
                } else {
                    Main.sv.add(index, sv);
                }
                stage = (Stage) scenePane.getScene().getWindow();
                stage.close();
            }
        }
    }

    public void exit(ActionEvent e){
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
}
