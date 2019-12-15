package pers.liam.mediator;

public class ColleagueB implements Colleague {

    private ConcreteMediator mediator;

    private String name;

    ColleagueB(ConcreteMediator mediator) {
        this.mediator = mediator;
        mediator.registerColleagueB(this);
    }

    public void giveMess(String[] mess) {
        mediator.deliverMess(this, mess);
    }

    public void receiveMess(String mess) {
        System.out.println(name + "收到的信息：");
        System.out.println("\t" + mess);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
