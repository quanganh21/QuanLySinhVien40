module com.example.QuanLySinhVien {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.QuanLySinhVien to javafx.fxml;
    exports com.example.QuanLySinhVien;
}