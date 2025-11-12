package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        TextField tfUsername  = new TextField();
        TextField tfLastName  = new TextField();
        TextField tfFirstName = new TextField();
        PasswordField pfPass  = new PasswordField();

        Button btnSubmit = new Button("Save");

        btnSubmit.setOnAction(e -> {
            String u = tfUsername.getText().trim();
            String ln = tfLastName.getText().trim();
            String fn = tfFirstName.getText().trim();
            String pw = pfPass.getText();

            if (u.isEmpty() || ln.isEmpty() || fn.isEmpty() || pw.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "All fields are required.").showAndWait();
                return;
            }

            try {
                UserDao.insertUser(u, ln, fn, pw);
                new Alert(Alert.AlertType.INFORMATION, "Successful!").showAndWait();
                tfUsername.clear(); tfLastName.clear(); tfFirstName.clear(); pfPass.clear();
            } catch (Exception ex) {
                ex.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Insert failed: " + ex.getMessage()).showAndWait();
            }
        });

        GridPane gp = new GridPane();
        gp.setHgap(8); gp.setVgap(10); gp.setPadding(new Insets(16));
        gp.addRow(0, new Label("Username:"),  tfUsername);
        gp.addRow(1, new Label("Last Name:"), tfLastName);
        gp.addRow(2, new Label("First Name:"), tfFirstName);
        gp.addRow(3, new Label("Password:"),  pfPass);
        gp.add(btnSubmit, 1, 4);

        stage.setTitle("JavaFX Add User");
        stage.setScene(new Scene(gp, 360, 220));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
