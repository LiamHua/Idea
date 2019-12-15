package pers.liam.calculator;

public class Add extends Operator {

	public double getResult() {
		return this.getFirstNumber()+this.getSecondNumber();
	}

}
