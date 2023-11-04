package com.example.QuanLySinhVien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FormSearchController {
    private int SearchID = -1;

    Stage stage;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField Input;

    public int getSearchID() {
        return SearchID;
    }

    @FXML
    private void Search(ActionEvent e){
        String s = Input.getText();
        if (!s.trim().isEmpty()){
            boolean t = false;
            for (SinhVien o:Main.sv) {
                if (o.getMaSV().equals(s)){
                    SearchID = Main.sv.indexOf(o);
                    t = true;
                    break;
                }
            }
            if (t) {
                Cancel(e);
            }else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Lỗi");
                a.setContentText("Mã sinh viên không tồn tại");
                a.showAndWait();
            }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Lỗi");
            a.setContentText("Chưa nhập mã");
            a.showAndWait();
        }
    }

    @FXML
    private void Cancel(ActionEvent e){
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
}
