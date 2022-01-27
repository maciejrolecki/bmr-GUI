package bmr;

public class ResultCalorie extends ResultBMR {


    public ResultCalorie(Observable observable, Input input) {
        super(observable, input);
    }

    @Override
    protected double compute() {
        return input.getActivityLevel() * computeBMR();
    }
}
