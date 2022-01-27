package bmr;

public class ResultBMR extends ResultTextField {
    public ResultBMR(Observable observable, Input input){
        super(observable,input);
    }
    @Override
    protected double compute() {
        return computeBMR();
    }

    protected double computeBMR() {
        if (input.isMale()) {
            return 13.7 *  input.getWeight() + 5 * input.getHeight()
                    - 6.8 * input.getAge() + 66;

        } else {
            return 9.6 * input.getWeight()+ 1.8 * input.getHeight()
                    - 4.7 * input.getAge() + 655;
        }
    }
}
