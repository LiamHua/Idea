package pers.liam.calculator;

public class AddFactory implements InterfaceOperatorFactory {

	public Operator createOperatorFactory() {
		return new Add();
	}

}
