package bmr;

import javafx.scene.control.TextField;

public abstract class ResultTextField extends TextField implements Observer {
    protected final Input input;

    public ResultTextField(Observable observable, Input input){
        observable.registerObserver(this);

        this.input = input;

        setEditable(false);
        setMaxWidth(Double.MAX_VALUE);
    }

    abstract protected double compute();

    @Override
    public void update() {
        try {
            double result = compute();
            setText(String.format("%.2f",result));
        }
        catch (IllegalArgumentException e){
            setText("entrée invalide");
        }
    }
}
