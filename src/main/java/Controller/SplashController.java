package Controller;

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

    private AbstractController abstractController;


    //Init method
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        AbstractController.dragApp(mainPane);
        progressBar.setProgress(0.0);
        start();

    }

    private void start(){

        ProgressBarController task = new ProgressBarController() {
            @Override
            public void createCache() {

                //Call the service which create the cache table

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
