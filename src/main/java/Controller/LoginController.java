package Controller;

import Model.User;
import Service.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    //Controls
    @FXML
    protected ImageView closeButton, altButton;
    @FXML
    protected AnchorPane mainPane;
    @FXML
    protected JFXTextField username;
    @FXML
    protected JFXPasswordField password;
    @FXML
    protected FontAwesomeIconView usernameAlert, passwordAlert;
    @FXML
    protected JFXButton loginButton;
    @FXML
    protected Text forgetPassword, loadingStatus;
    @FXML
    protected VBox loginPane, loadingPane;
    @FXML
    protected JFXSpinner loadingSpinner;

    //User Service
    private UserService userService;
    private AbstractController abstractController;

    //Init method
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AbstractController.closeApp(closeButton);
        abstractController = new AbstractController();

        userService = new UserService();
        Login(); //Login method
        SwitchSignup();

    }

    private void Login(){

        loginButton.setOnAction(event -> {


            if (!username.getText().isEmpty() && !password.getText().isEmpty()){

                //Thread loading 2 seconds
                //Switch Login right side

                boolean result = userService.LogIn(username.getText(), password.getText());

                if (result){

                    abstractController.switchStage(loginButton, "BaseHomepage");

                } else {

                    usernameAlert.setVisible(true);
                    passwordAlert.setVisible(true);

                    username.clear();
                    password.clear();

                }


            } else {

                if (username.getText().isEmpty()){

                    usernameAlert.setVisible(true);
                    usernameAlert.setOnMouseEntered(userEmpty -> {

                        showEmptyAlert();
                        usernameAlert.setVisible(false);

                    });

                }

                if (password.getText().isEmpty()){

                    passwordAlert.setVisible(true);
                    passwordAlert.setOnMouseEntered(passEmpty -> {

                        showEmptyAlert();
                        passwordAlert.setVisible(false);

                    });

                }

            }

        });

    }

    private void SwitchSignup(){

        AbstractController abstractController = new AbstractController();
        abstractController.switchStage(altButton, "Signup");

    }

    private void showEmptyAlert(){

        abstractController.showDialog(usernameAlert, "Empty Field", "This field must be filled, please try again", "Alert");

    }

    private void showWrongUsername(){

        abstractController.showDialog(usernameAlert, "Wrong username", "The username you have entered is incorrect, please try again","Alert");

    }

    private void showWrongPassword(){

        abstractController.showDialog(passwordAlert, "Wrong password", "The password you have entered is incorrect, please try again","Alert");

    }


    @FXML
    protected void hideAlerts(){

        usernameAlert.setVisible(false);
        passwordAlert.setVisible(false);

    }




}
