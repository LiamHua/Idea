package pers.liam.calculator.Factory;

public class Div extends Operator {

    public double getResult() {
        return this.getFirstNumber()/this.getSecondNumber();
    }

}