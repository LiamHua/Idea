package pers.liam.decorator;

public class SparrowDecorator extends Decorator {
    public final int DISINSTANCE = 50;
    SparrowDecorator(Bird bird){
        super(bird);
    }
    @Override
    public int fly() {
        int disinstance = 0;
        disinstance = bird.fly() + eleFly();
        return disinstance;
    }

    private int eleFly() {
        return DISINSTANCE;
    }
}
