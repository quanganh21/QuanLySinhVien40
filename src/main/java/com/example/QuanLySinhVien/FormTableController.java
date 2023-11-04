package com.example.QuanLySinhVien;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;

public class FormTableController extends Stage{
    @FXML
    private TableView<SinhVien> TableTTSV;

    @FXML
    private TableColumn<SinhVien, String> TableMSSV;

    @FXML
    private TableColumn<SinhVien, String> TableTen;

    @FXML
    private TableColumn<SinhVien, String> TableLop;

    @FXML
    private TableColumn<SinhVien, String> TableKhoa;

    @FXML
    private TableColumn<SinhVien, String> TableSdt;

    @FXML
    private TableColumn<SinhVien, String> TableDiachi;

    @FXML
    private TextField NhapMSSV;

    @FXML
    private void Add(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FormAdd.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Thêm sinh viên");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            loadTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Edit(ActionEvent event) {
        SinhVien selectedSinhVien = TableTTSV.getSelectionModel().getSelectedItem();
        if (selectedSinhVien != null){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FormEdit.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Sửa sinh viên");
                stage.setScene(new Scene(root));
                FormEditController ctr = fxmlLoader.getController();
                ctr.setIndex(TableTTSV.getSelectionModel().getSelectedIndex());
                ctr.Load();
                stage.showAndWait();
                loadTable();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Chưa chọn dữ liệu cần sửa");
            alert.showAndWait();
        }

    }

    @FXML
    private void SearchTTSV(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FormSearch.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Tìm kiếm sinh viên");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            FormSearchController ctr = fxmlLoader.getController();
            TableTTSV.getSelectionModel().select(ctr.getSearchID());
            loadTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Del(ActionEvent e){
        int i = TableTTSV.getSelectionModel().getSelectedIndex();
        if (i!=-1){
            Main.sv.remove(i);
            loadTable();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Chưa chọn dữ liệu cần xóa");
            alert.showAndWait();
        }
    }

    @FXML
    private Label labelTen;
    @FXML
    private Label labelLop;
    @FXML
    private Label labelMSSV;
    @FXML
    private Label labelDanhGia;
    @FXML
    private Label labelKhoa;
    @FXML
    private Label labelDiemTB;

    @FXML
    private TableView<MonHoc> BangDiem;

    @FXML
    private TableColumn<MonHoc, String> STT;

    @FXML
    private TableColumn<MonHoc, String> TenMH;

    @FXML
    private TableColumn<MonHoc, Double> QT;

    @FXML
    private TableColumn<MonHoc, Double> GK;

    @FXML
    private TableColumn<MonHoc, Double> CK;

    @FXML
    private TableColumn<MonHoc, String> TBM;
    private SinhVien svInfo;
    private int MarkIndex = -1;

    private void MarkInfoLoad(){
        labelTen.setText("Tên: " + svInfo.getHoTen());
        labelLop.setText("Lớp: " + svInfo.getLop());
        labelKhoa.setText("Khoa: " + svInfo.getKhoa());
        labelMSSV.setText("MSSV: " + svInfo.getMaSV());
        labelDiemTB.setText("Điểm TB: " + String.format("%.2f", svInfo.diemTB()));
        labelDanhGia.setText("Đánh giá: " + svInfo.DanhGia());
        BangDiem.setItems(FXCollections.observableArrayList(Main.sv.get(MarkIndex).getDanhSachMonHoc()));
        BangDiem.refresh();
    }

    @FXML
    private void ktNhapQT(TableColumn.CellEditEvent<MonHoc, Double> e) {
        try {
            MonHoc q = e.getRowValue();
            if (e.getNewValue() < 0 || e.getNewValue() > 10) {
                q.setDiemQuaTrinh(e.getOldValue());
            } else {
                q.setDiemQuaTrinh(e.getNewValue());
            }
            MarkInfoLoad();
        }catch (Exception ex){
            MonHoc q = e.getRowValue();
            q.setDiemQuaTrinh(e.getOldValue());
        }
    }

    @FXML
    private void ktNhapGK(TableColumn.CellEditEvent<MonHoc, Double> e) {
        try {
            MonHoc q = e.getRowValue();
            if (e.getNewValue() < 0 || e.getNewValue() > 10) {
                q.setDiemGiuaKy(e.getOldValue());
            } else {
                q.setDiemGiuaKy(e.getNewValue());
            }
            MarkInfoLoad();
        }catch (Exception ex){
            MonHoc q = e.getRowValue();
            q.setDiemQuaTrinh(e.getOldValue());
        }
    }

    @FXML
    private void ktNhapCK(TableColumn.CellEditEvent<MonHoc, Double> e) {
        try {
            MonHoc q = e.getRowValue();
            if (e.getNewValue() < 0 || e.getNewValue() > 10) {
                q.setDiemCuoiKy(e.getOldValue());
            } else {
                q.setDiemCuoiKy(e.getNewValue());
            }
            MarkInfoLoad();
        }catch (Exception ex){
            MonHoc q = e.getRowValue();
            q.setDiemQuaTrinh(e.getOldValue());
        }
    }

    @FXML
    private void MarkResearch(ActionEvent e){
        String s = NhapMSSV.getText();
        if (s.trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Lỗi");
            a.setContentText("Chưa nhập MSSV");
            a.showAndWait();
        }else{
            boolean t = true;
            int index = 0;
            for (SinhVien o:Main.sv) {
                if (s.trim().equals(o.getMaSV().trim())){
                    svInfo=o;
                    MarkIndex = index;
                    t = false;
                    break;
                }
                index++;
            }
            if (t){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Lỗi");
                a.setContentText("Sinh viên không tồn tại");
                a.showAndWait();
            }else{
                TenMH.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTenMonHoc()));
                QT.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getDiemQuaTrinh()).asObject());
                QT.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                GK.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getDiemGiuaKy()).asObject());
                GK.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                CK.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getDiemCuoiKy()).asObject());
                CK.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                TBM.setCellValueFactory(data -> new SimpleStringProperty(String.format("%.2f", data.getValue().diemTB())));
                MarkInfoLoad();
            }
        }
    }

    @FXML
    private void DangKi(ActionEvent event) {
        try {
            if (MarkIndex != -1) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FormDangKi.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Đăng kí môn học");
                stage.setScene(new Scene(root));
                FormDangKiController ctr = fxmlLoader.getController();
                ctr.setSvIndex(MarkIndex);
                ctr.Load();
                stage.showAndWait();
                MarkInfoLoad();
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Lỗi");
                a.setContentText("Chưa chọn sinh viên");
                a.showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadTable(){
        TableMSSV.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMaSV()));
        TableTen.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHoTen()));
        TableLop.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLop()));
        TableKhoa.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKhoa()));
        TableSdt.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSdt()));
        TableDiachi.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDiaChi()));
        TableTTSV.setItems(FXCollections.observableArrayList(Main.sv));
        TableTTSV.refresh();
    }

    @FXML
    private TabPane tabPane;

    Stage stage;
    public void exit(ActionEvent e){
        stage = (Stage) tabPane.getScene().getWindow();
        stage.close();
    }
}