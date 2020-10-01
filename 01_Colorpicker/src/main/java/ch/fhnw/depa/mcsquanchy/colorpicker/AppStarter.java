package ch.fhnw.depa.mcsquanchy.colorpicker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Model model = new Model();
        primaryStage.setTitle("Color Picker");
        Scene scene = new Scene(new UI(model));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
