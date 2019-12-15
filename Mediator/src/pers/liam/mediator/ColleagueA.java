package pers.liam.mediator;

public class ColleagueA implements Colleague {

	private ConcreteMediator mediator;

	private String name;

	private ColleagueB colleagueB;

	ColleagueA(ConcreteMediator mediator) {

	}


	/**
	 * @see Colleague#giveMessage(String)
	 */
	public void giveMessage(String mess[]) {

	}


	/**
	 * @see Colleague#receiveMess(String)
	 */
	public void receiveMess(String mess) {

	}


	/**
	 * @see Colleague#setName(String)
	 */
	public void setName(String name) {

	}


	/**
	 * @see Colleague#getName()
	 */
	public String getName() {
		return null;
	}

}
