package com.example.QuanLySinhVien;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FormDangKiController {

    @FXML
    private Button ExitButton;

    private int svIndex;

    private ArrayList<MonHoc> dsmonhoc = new ArrayList<>();
    private ArrayList<MonHoc> dsdangki = new ArrayList<>();
    public void setSvIndex(int i) {
        this.svIndex = i;
    }

    @FXML
    private ListView<String> DsMonhoc;
    @FXML
    private ListView<String> DsDangki;
    public void Load(){
        dsmonhoc.clear();
        dsdangki.clear();
        DsMonhoc.getItems().clear();
        DsDangki.getItems().clear();
        for (MonHoc o:Main.monhoc) {
            boolean t = true;
            for (MonHoc p:Main.sv.get(svIndex).getDanhSachMonHoc()) {
                if (o.getTenMonHoc().equals(p.getTenMonHoc())){
                    t = false;
                    break;
                }
            }
            if (t) dsmonhoc.add(o);
        }
        for (MonHoc o:dsmonhoc) {
            DsMonhoc.getItems().add(o.getTenMonHoc());
        }
    }

    @FXML
    public void DangKi(ActionEvent e){
        if (!dsdangki.isEmpty()){
            for (MonHoc o:dsdangki) {
                Main.sv.get(svIndex).getDanhSachMonHoc().add(Main.monhoc.get(o.getMaMonHoc()-1));
            }
            Thoat(e);
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Lỗi");
            a.setContentText("Chưa chọn môn học");
            a.showAndWait();
        }
    }

    @FXML
    public void ChonMot(ActionEvent e){
        int i = DsMonhoc.getSelectionModel().getSelectedIndex();
        if (i != -1){
            dsdangki.add(dsmonhoc.get(i));
            DsDangki.getItems().add(dsmonhoc.get(i).getTenMonHoc());
            dsmonhoc.remove(i);
            DsMonhoc.getItems().remove(i);
            DsMonhoc.refresh();
            DsDangki.refresh();
        }
    }

    @FXML
    public void ChonHet(ActionEvent e){
            dsdangki.addAll(dsmonhoc);
            DsDangki.getItems().addAll(DsMonhoc.getItems());
            dsmonhoc.clear();
            DsMonhoc.getItems().clear();
            DsMonhoc.refresh();
            DsDangki.refresh();
    }

    @FXML
    public void XoaMot(ActionEvent e){
        int i = DsDangki.getSelectionModel().getSelectedIndex();
        if (i != -1){
            dsmonhoc.add(dsdangki.get(i));
            DsMonhoc.getItems().add(dsdangki.get(i).getTenMonHoc());
            dsdangki.remove(i);
            DsDangki.getItems().remove(i);
            DsDangki.refresh();
            DsMonhoc.refresh();
        }
    }

    @FXML
    public void XoaHet(ActionEvent e){
        dsmonhoc.addAll(dsdangki);
        DsMonhoc.getItems().addAll(DsDangki.getItems());
        dsdangki.clear();
        DsDangki.getItems().clear();
        DsMonhoc.refresh();
        DsDangki.refresh();
    }

    @FXML
    private AnchorPane scenePane;
    Stage stage;
    @FXML
    public void Thoat(ActionEvent e){
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
}
