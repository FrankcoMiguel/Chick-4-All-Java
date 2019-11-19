package Controller;

import Model.User;
import Service.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.hibernate.engine.spi.EffectiveEntityGraph;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    //Controls
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
        userService.AddUser(new User("809","Franko","root"));

        Login();

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

            } else {

                System.out.println("put your credentials xd");

            }

        });

    }



}
