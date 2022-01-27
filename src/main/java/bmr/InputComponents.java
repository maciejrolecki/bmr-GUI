package bmr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class InputComponents extends Observable implements Input {
    private final TextField tfSize;
    private final TextField tfWeight;
    private final TextField tfAge;
    private final ComboBox<ActivityLevel> cbActivityLevel;
    private final RadioButton rdMale;

    public InputComponents(GridPane input) {
        RadioButton rdFemale = new RadioButton("Femme");
        rdMale = new RadioButton("Homme");
        ToggleGroup rdSex = new ToggleGroup();
        rdFemale.setToggleGroup(rdSex);
        rdFemale.setSelected(true);
        rdMale.setToggleGroup(rdSex);
        HBox genderButtons = new HBox(0);
        genderButtons.getChildren().addAll(rdFemale, rdMale);
        input.add(genderButtons, 1, 4);

        tfSize = new TextField();
        tfWeight = new TextField();
        tfAge = new TextField();
        tfSize.setPromptText("Taille en centimètres");
        tfWeight.setPromptText("Poids en kg");
        tfAge.setPromptText("Age en années");
        input.add(tfSize, 1, 1);
        input.add(tfWeight, 1, 2);
        input.add(tfAge, 1, 3);

        ObservableList<ActivityLevel> lstStyle =
                FXCollections.observableArrayList(
                        ActivityLevel.NOT_ACTIVE,
                        ActivityLevel.NOT_VERY_ACTIVE,
                        ActivityLevel.ACTIVE,
                        ActivityLevel.VERY_ACTIVE,
                        ActivityLevel.EXTREMELY_ACTIVE
                );
        cbActivityLevel = new ComboBox<>(lstStyle);
        input.add(cbActivityLevel, 1, 5);
        EventHandler<ActionEvent> defaultHandler = event -> notifyObservers();

        tfSize.setOnAction(defaultHandler);
        tfWeight.setOnAction(defaultHandler);
        tfAge.setOnAction(defaultHandler);
        cbActivityLevel.setOnAction(defaultHandler);
        rdFemale.setOnAction(defaultHandler);
        rdMale.setOnAction(defaultHandler);
    }

    private int parseInt(String s) {
        int value = Integer.parseInt(s);
        if (value <= 0) {
            throw new IllegalArgumentException("Invalid number entered");
        }
        return value;
    }

    @Override
    public int getHeight() {
        return parseInt(tfWeight.getText());
    }

    @Override
    public int getWeight() {
        return parseInt(tfSize.getText());
    }

    @Override
    public int getAge() {
        return parseInt(tfAge.getText());
    }

    @Override
    public boolean isMale() {
        return rdMale.isSelected();
    }

    @Override
    public double getActivityLevel() {
        ActivityLevel al = cbActivityLevel.getValue();
        if (al == null) {
            throw new IllegalArgumentException("Activity level must be selected");
        }
        return al.getWeight();
    }
}
