package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.classes.Calculator;
import sample.classes.Operation;

public class Main extends Application {
    public static Calculator calculator;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("calculatorMain.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.getIcons().add(new Image("images/calculator.png"));
//        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setScene(new Scene(root));
        primaryStage.getScene().getStylesheets().add(getClass().getResource("../css/styles.css").toExternalForm());  //
        // CSS из внешнего файла
        //primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        root.styleProperty().setValue("-fx-background-color: lightblue; -fx-background-radius: 20px; -fx-border-color: blue; -fx-border-radius: 20px; -fx-border-width: 5px;"); // CSS локально
        primaryStage.show();
    }


    public static void main(String[] args) {
        calculator = new Calculator();
        launch(args);
    }
}
