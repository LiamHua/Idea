package pers.liam.calculator.Factory;

public class Sub extends Operator {

    public double getResult() {
        return this.getFirstNumber()-this.getSecondNumber();
    }

}