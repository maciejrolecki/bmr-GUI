package bmr;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        /*Input side*/
        GridPane inputGP = new GridPane();
        inputGP.setPadding(new Insets(4));
        inputGP.setHgap(8);
        inputGP.setVgap(4);
        Label data = new Label("Données");
        data.setUnderline(true);
        GridPane.setHalignment(data, HPos.LEFT);

        Label lbSize = new Label("Taille (cm) ");
        Label lbWeight = new Label("Poids (kg) ");
        Label lbAge = new Label("Age (années) ");
        Label lbGender = new Label("Sexe ");
        Label lbLifeStyle = new Label("Style de vie ");
        inputGP.add(data, 0, 0);
        inputGP.add(lbSize, 0, 1);
        inputGP.add(lbWeight, 0, 2);
        inputGP.add(lbAge, 0, 3);
        inputGP.add(lbGender, 0, 4);
        inputGP.add(lbLifeStyle, 0, 5);

        InputComponents input = new InputComponents(inputGP);

        ColumnConstraints inputCol1 = new ColumnConstraints();
        ColumnConstraints inputCol2 = new ColumnConstraints();
        inputCol2.setPercentWidth(50);
        inputGP.getColumnConstraints().addAll(inputCol1, inputCol2);
        /*Output side*/

        GridPane outputGP = new GridPane();
        outputGP.setPadding(new Insets(5));
        outputGP.setHgap(10);
        outputGP.setVgap(10);

        Label results = new Label("Résultats");
        results.setUnderline(true);

        Label BMR = new Label("BMR ");
        Label calories = new Label("Calories ");

        outputGP.add(results, 0, 0);
        outputGP.add(BMR, 0, 1);
        outputGP.add(calories, 0, 2);

        ResultTextField resBMR = new ResultBMR(input, input);
        ResultTextField resCalorie = new ResultCalorie(input, input);
        outputGP.add(resBMR, 1, 1);
        outputGP.add(resCalorie, 1, 2);

        HBox ioHBox =  new HBox(4);
        ioHBox.getChildren().addAll(inputGP,outputGP);
        HBox.setHgrow(inputGP,Priority.ALWAYS);
        HBox.setHgrow(outputGP,Priority.ALWAYS);

        VBox mainVBox = new VBox(8);
        Region fillbox = new Region();
        VBox.setVgrow(fillbox,Priority.ALWAYS);
        Button computeBMR = new Button("Calcul du BMR");

        computeBMR.setMaxWidth(Double.MAX_VALUE);
        computeBMR.setMaxHeight(240);
        VBox.setVgrow(computeBMR, Priority.ALWAYS);
        mainVBox.getChildren().addAll(ioHBox,fillbox,computeBMR);

        Scene scene = new Scene(mainVBox, 575, 313);
        primaryStage.setTitle("BMR Calculator");
        primaryStage.setMinWidth(575);
        primaryStage.setMinHeight(300);
        primaryStage.setMaxWidth(575);
        primaryStage.setMaxHeight(300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
