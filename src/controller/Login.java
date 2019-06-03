package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Database;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Login implements Initializable {
    @FXML
    Button prijavaBtn;

    @FXML
    TextField korisnikTxt;

    @FXML
    TextField lozinkaTxt;


    @FXML
    public void loginUser(ActionEvent a) {
       String username= korisnikTxt.getText();
       String password = lozinkaTxt.getText();
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("SELECT * FROM korisnik WHERE korisnicko_ime=? AND lozinka=?");
            stmnt.setString(1, username);
            stmnt.setString(2, password);
            ResultSet rs = stmnt.executeQuery();

            if (rs.next()) {
                Utils u = new Utils();
                u.showNewWindow("admin");
            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
