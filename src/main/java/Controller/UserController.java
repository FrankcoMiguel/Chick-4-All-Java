package Controller;

import Model.User;
import Service.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    protected ImageView closeButton, signUp;
    @FXML
    protected AnchorPane mainPane;
    @FXML
    protected JFXTextField username;
    @FXML
    protected JFXPasswordField password;
    @FXML
    protected JFXButton loginButton;
    @FXML
    protected Text forgetPassword;

    private UserService userService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AbstractController.dragApp(mainPane);
        AbstractController.closeApp(closeButton);

        userService = new UserService();
        userService.AddUser(new User("809","Franko","root"));

        Login();

    }


    private void Login(){

        loginButton.setOnMouseClicked(event -> {

            if (!username.getText().isEmpty() && !password.getText().isEmpty()){

                userService = new UserService();
                boolean result = userService.LogIn(username.getText(), password.getText());

                if (result){

                    // Logic login
                    System.out.println("Access granted");

                } else {

                    // Logic wrong credentials
                    System.out.println("Wrong credentials");

                }

            }

        });

    }



}
