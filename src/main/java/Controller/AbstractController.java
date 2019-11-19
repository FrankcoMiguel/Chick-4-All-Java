package Controller;


import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

    class AbstractController {

    private static double x, y;
    Stage stage;


    static void closeApp(ImageView close){

        close.setOnMouseClicked(event -> System.exit(0));

    }

    static void dragApp(Pane pane){

        pane.setOnMousePressed(event -> {

            pane.setCursor(Cursor.OPEN_HAND);
            x = event.getSceneX();
            y = event.getSceneY();

        });

        pane.setOnMouseDragged(event -> {

            pane.setCursor(Cursor.CLOSED_HAND);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);

        });

        pane.setOnMouseReleased(event -> pane.setCursor(Cursor.DEFAULT));

    }


}
