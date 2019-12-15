package pers.liam.mediator;

public interface Colleague {

	public void giveMess(String[] mess);

	public void receiveMess(String mess);

	public void setName(String name);

	public String getName();
}
