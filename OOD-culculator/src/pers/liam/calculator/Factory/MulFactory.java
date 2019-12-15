package pers.liam.calculator.Factory;

public class MulFactory implements InterfaceOperatorFactory {

    public Operator createOperatorFactory() {
        return new Mul();
    }

}
