package pers.liam.calculator.Factory;

public class Add extends Operator {

	public double getResult() {
		return this.getFirstNumber()+this.getSecondNumber();
	}

}
