package pers.liam.mediator;

public abstract interface Colleague {

	public abstract void giveMessage(String mess[]);

	public abstract void receiveMess(String mess);

	public abstract void setName(String name);

	public abstract String getName();

}
