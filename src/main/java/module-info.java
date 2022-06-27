module com.example.weth {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.example.weth to javafx.fxml;
    exports com.example.weth;
}