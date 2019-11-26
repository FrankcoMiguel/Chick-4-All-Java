package Controller;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseHomepageController implements Initializable {

    @FXML
    protected ImageView closeButton, settingButton;
    @FXML
    protected TextField searchBar;
    @FXML
    protected FontAwesomeIconView searchGlass, searchClear;
    @FXML
    protected BorderPane contentPane;
    @FXML
    protected JFXButton dashboardButton, orderListButton, customersButton, statisticsButton;

    private AbstractController abstractController;

    //Init method
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AbstractController.closeApp(closeButton);
        abstractController = new AbstractController();
        abstractController.setContent(contentPane,"Dashboard");


        dashboardButton.setOnAction(event -> abstractController.setContent(contentPane, "Dashboard"));
        orderListButton.setOnAction(event -> abstractController.setContent(contentPane, "OrderList"));
        customersButton.setOnAction(event -> abstractController.setContent(contentPane, "Customers"));
        statisticsButton.setOnAction(event -> abstractController.setContent(contentPane, "Statistics"));

    }







}
