package Controller.ContentController;

import Service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    protected Text customersCounting, todayRevenue, totalOrders;
    @FXML
    protected BarChart<String, Integer> barChart;
    @FXML
    protected CategoryAxis categoryX;
    @FXML
    protected NumberAxis numberY;

    //Init method
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setBarChart();


    }


    private void setBarChart(){

        XYChart.Series set1 = new XYChart.Series();
        set1.getData().add(new XYChart.Data("Jan",2340));
        set1.getData().add(new XYChart.Data("Feb",1203));
        set1.getData().add(new XYChart.Data("Mar",3029));
        set1.getData().add(new XYChart.Data("Apr",3991));
        set1.getData().add(new XYChart.Data("May",2283));
        set1.getData().add(new XYChart.Data("June",1589));
        set1.getData().add(new XYChart.Data("July",4179));
        set1.getData().add(new XYChart.Data("Aug",2031));
        set1.getData().add(new XYChart.Data("Sep",2009));
        set1.getData().add(new XYChart.Data("Oct",1857));
        set1.getData().add(new XYChart.Data("Nov",902));

        barChart.getData().add(set1);

    }


}
