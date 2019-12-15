package pers.liam.calculator.Factory;

public class AddFactory implements InterfaceOperatorFactory {

	public Operator createOperatorFactory() {
		return new Add();
	}

}
