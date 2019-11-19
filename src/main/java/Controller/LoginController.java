package Controller;

import Model.User;
import Service.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    protected JFXButton loginButton;
    @FXML
    protected Text forgetPassword, loadingStatus;
    @FXML
    protected VBox loginPane, loadingPane;
    @FXML
    protected JFXSpinner loadingSpinner;

    //User Service
    private UserService userService;


    //Init method
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AbstractController.dragApp(mainPane);
        AbstractController.closeApp(closeButton);

        userService = new UserService();
        Login(); //Login method
        SwitchSignup();



    }

    private void Login(){

        loginButton.setOnAction(event -> {

            if (!username.getText().isEmpty() && !password.getText().isEmpty()){

                boolean result = userService.LogIn(username.getText(), password.getText());

                if (result){

                    loginPane.setDisable(true);
                    loginPane.setOpacity(0.40);
                    loadingPane.setVisible(true);
                }

                username.clear();
                password.clear();

            } else {

                //Alerts
                System.out.println("Put your credentials");

            }

        });

    }

    private void SwitchSignup(){

        AbstractController abstractController = new AbstractController();
        abstractController.switchStage(altButton, "Signup");

    }




}
