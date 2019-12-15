package pers.liam.calculator.Factory;

public class SubFactory implements InterfaceOperatorFactory {

    public Operator createOperatorFactory() {
        return new Sub();
    }

}
