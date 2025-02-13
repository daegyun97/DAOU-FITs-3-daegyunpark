package example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXTableViewEx extends Application {

  @Override
  public void start(Stage stage) {
    Parent root = null;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/example.fxml"));
    try {
      root = loader.load();
    } catch (Exception e) {
      e.printStackTrace();
    }
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Book Search");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
