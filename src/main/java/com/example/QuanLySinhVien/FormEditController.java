package com.example.QuanLySinhVien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FormEditController {
    @FXML
    private Button ExitButton;

    @FXML
    private TextField Ten;

    @FXML
    private TextField Lop;

    @FXML
    private TextField Khoa;

    @FXML
    private TextField Sdt;

    @FXML
    private TextField Diachi;

    @FXML
    private AnchorPane scenePane;

    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    Stage stage;

    public void Load(){
        Ten.setText(Main.sv.get(index).getHoTen());
        Lop.setText(Main.sv.get(index).getLop());
        Khoa.setText(Main.sv.get(index).getKhoa());
        Sdt.setText(Main.sv.get(index).getSdt());
        Diachi.setText(Main.sv.get(index).getDiaChi());
    }

    public void Edit(ActionEvent e){
        String ETen;
        String ELop;
        String EKhoa;
        String ESdt;
        String EDiachi;
        ETen = Ten.getText();
        ELop = Lop.getText();
        EKhoa = Khoa.getText();
        ESdt = Sdt.getText();
        EDiachi = Diachi.getText();
        if (ETen.trim().isEmpty() || ELop.trim().isEmpty() || EKhoa.trim().isEmpty() || ESdt.trim().isEmpty() || EDiachi.trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Không được để trống");
            alert.setContentText("Hãy nhập đầy đủ thông tin");
            alert.showAndWait();
        }else{
            Main.sv.get(index).setHoTen(Ten.getText());
            Main.sv.get(index).setLop(Lop.getText());
            Main.sv.get(index).setKhoa(Khoa.getText());
            Main.sv.get(index).setSdt(Sdt.getText());
            Main.sv.get(index).setDiaChi(Diachi.getText());
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }
    public void Exit(ActionEvent e){
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
}
