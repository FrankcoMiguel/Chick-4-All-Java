package Controller;

import Model.User;
import Service.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @FXML
    protected AnchorPane mainPane;
    @FXML
    protected ImageView closeButton, altButton;
    @FXML
    protected JFXTextField phone, username;
    @FXML
    protected JFXPasswordField password, passwordRepeat;
    @FXML
    protected FontAwesomeIconView passwordConfirm;
    @FXML
    protected JFXButton signupButton;

    private UserService userService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AbstractController.closeApp(closeButton);
        userService = new UserService();
        SwitchLogin();
        Signup();

    }

    private void Signup(){

        signupButton.setOnAction(event -> {

            if (!phone.getText().isEmpty() && !username.getText().isEmpty() && !password.getText().isEmpty() && !passwordRepeat.getText().isEmpty()){

                if (password.getText().equals(passwordRepeat.getText())){

                    passwordConfirm.setGlyphName("CHECK");
                    passwordConfirm.setFill(Paint.valueOf("#3a9a29"));
                    passwordConfirm.setVisible(true);

                   boolean result = userService.AddUser(new User(phone.getText(), username.getText(), password.getText()));
                   System.out.println(result);
                   phone.clear();
                   username.clear();
                   password.clear();
                   passwordRepeat.clear();


                } else {

                    passwordConfirm.setGlyphName("CLOSE");
                    passwordConfirm.setFill(Paint.valueOf("#ff0000"));
                    passwordConfirm.setVisible(true);

                    password.clear();
                    passwordRepeat.clear();


                }

            } else {

                System.out.println("Put your info xd");

            }

        });

    }

    private void SwitchLogin(){

        AbstractController abstractController = new AbstractController();
        abstractController.switchStage(altButton, "Login");

    }

}
