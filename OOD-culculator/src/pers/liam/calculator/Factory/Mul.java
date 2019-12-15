package pers.liam.calculator.Factory;

public class Mul extends Operator {

    public double getResult() {
        return this.getFirstNumber()*this.getSecondNumber();
    }

}