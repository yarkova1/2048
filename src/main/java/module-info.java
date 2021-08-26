module com.example.twopower {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.twopower to javafx.fxml;
    exports com.example.twopower;
}