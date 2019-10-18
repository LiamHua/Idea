package sample;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.layout.Pane;

public class CarPane extends Pane
{
    private double x;//起始点x坐标
    private double y;//起始点y坐标
    private double w;//窗体宽度
    private double time;//动画时间
    private PathTransition aRoof;
    private PathTransition aBody;
    private PathTransition aWheel1;
    private PathTransition aWheel2;
    private Polygon roof;
    private Rectangle body;
    private Circle wheel1;
    private Circle wheel2;
    private Duration duration;

    public CarPane()
    {
        this(0, 100, 400, 50000);
    }

    public CarPane(double w)
    {
        this(0, 50, w, 50000);
    }

    public CarPane(double x, double y)
    {
        this(x, y, 400, 50000);
    }

    public CarPane(double x, double y, double w, double time)
    {
        this.x = x;
        this.y = y;
        this.time = time;
        this.w = w;
        aRoof = new PathTransition();
        aBody = new PathTransition();
        aWheel1 = new PathTransition();
        aWheel2 = new PathTransition();
        duration = new Duration(time);
        roof = new Polygon();
        body = new Rectangle();
        wheel1 = new Circle();
        wheel2 = new Circle();
        paintCar();
    }
    //设置速度
    public void setRate(double rate)
    {
        aRoof.setRate(rate < 0.0 ? 0.0 : rate);
        aBody.setRate(rate < 0.0 ?  0.0 : rate);
        aWheel1.setRate(rate < 0.0 ? 0.0 : rate);
        aWheel2.setRate(rate < 0.0 ? 0.0 : rate);
    }
    //动画开始
    public void play()
    {
        aRoof.play();
        aBody.play();
        aWheel1.play();
        aWheel2.play();
    }
    public void playFromStart()
    {
        aRoof.playFromStart();
        aBody.playFromStart();
        aWheel1.playFromStart();
        aWheel2.playFromStart();
    }
    //画小车
    public void paintCar()
    {
        //车顶
        roof.setFill(Color.PINK);
        roof.setStroke(Color.BLACK);
        ObservableList<Double> list = roof.getPoints();
        list.add(x + 10);
        list.add(y - 20);
        list.add(x + 20);
        list.add(y - 30);
        list.add(x + 30);
        list.add(y - 30);
        list.add(x + 40);
        list.add(y - 20);
        Line lR = new Line(x + 25, y - 25, w - 25, y - 25);
        //车体
        body.setX(x);
        body.setY(y - 20);
        body.setWidth(50);
        body.setHeight(10);
        body.setFill(Color.PINK);
        body.setStroke(Color.BLACK);
        Line lB = new Line(x + 25, y - 15, w - 25, y - 15);
        //车轮1
        wheel1.setCenterX(x + 15);
        wheel1.setCenterY(y - 5);
        wheel1.setRadius(5);
        wheel1.setFill(Color.BLACK);
        Line lW1 = new Line(x + 15, y - 5, w - 35, y - 5);
        //车轮2
        wheel2.setCenterX(x + 35);
        wheel2.setCenterY(y - 5);
        wheel2.setRadius(5);
        wheel2.setFill(Color.BLACK);
        Line lW2 = new Line(x + 35, y - 5, w - 15, y - 5);

        super.getChildren().addAll(roof, body, wheel1, wheel2);

        aRoof.setDuration(duration);
        aRoof.setPath(lR);
        aRoof.setNode(roof);
        aRoof.setCycleCount(Timeline.INDEFINITE);
        aRoof.play();

        aBody.setDuration(duration);
        aBody.setPath(lB);
        aBody.setNode(body);
        aBody.setCycleCount(Timeline.INDEFINITE);
        aBody.play();

        aWheel1.setDuration(duration);
        aWheel1.setPath(lW1);
        aWheel1.setNode(wheel1);
        aWheel1.setCycleCount(Timeline.INDEFINITE);
        aWheel1.play();

        aWheel2.setDuration(duration);
        aWheel2.setPath(lW2);
        aWheel2.setNode(wheel2);
        aWheel2.setCycleCount(Timeline.INDEFINITE);
        aWheel2.play();
    }
}