package Controller;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
class AbstractController {

    private static double x, y;

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

    void switchStage(Node altControl, String Layout){

        altControl.setOnMouseClicked(event -> {

            try {

                Parent root = FXMLLoader.load(getClass().getResource("../Layout/"+(Layout)+".fxml"));
                root.translateXProperty().set(altControl.getScene().getWidth());
                Pane pane = (Pane) altControl.getScene().getRoot();
                pane.getChildren().removeAll(); //Improvement of Performance: Deleting all previous nodes before set the next Parent
                pane.getChildren().add(root);

                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.DISCRETE);
                KeyFrame kf = new KeyFrame(Duration.millis(100), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();

            } catch (IOException e) {

                System.out.println("Error switching stages");

            }


        });

    }


}