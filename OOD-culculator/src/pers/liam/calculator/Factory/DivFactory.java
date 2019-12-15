package pers.liam.calculator.Factory;

public class DivFactory implements InterfaceOperatorFactory {

    public Operator createOperatorFactory() {
        return new Div();
    }

}
