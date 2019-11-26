package Controller;

import Model.User;
import Service.UserService;
import com.jfoenix.controls.JFXProgressBar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {

    @FXML
    protected JFXProgressBar progressBar;
    @FXML
    protected Text progressStatus;
    @FXML
    protected AnchorPane mainPane;

    private UserService userService;
    private AbstractController abstractController;


    //Init method
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        userService = new UserService();
        AbstractController.dragApp(mainPane);
        progressBar.setProgress(0.0);
        start();

    }

    private void start(){

        ProgressBarController task = new ProgressBarController() {
            @Override
            public void createCache() {

                userService.AddUser(new User("809-359-7244", "Franco29", "root"));

            }
        };

        progressBar.progressProperty().bind(task.progressProperty());
        progressStatus.textProperty().bind(task.messageProperty());

        task.setOnSucceeded(event -> {

            AbstractController abstractController = new AbstractController();
            abstractController.switchSplash(progressBar);

        });

        new Thread(task).start();

    }



}
