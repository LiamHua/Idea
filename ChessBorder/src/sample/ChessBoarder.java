package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class ChessBoarder extends Application{
    public void start(Stage primaryStage){

        Scene scene=new Scene(new ChessPane(),900,1000);
        primaryStage.setTitle("Chinese Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
class ChessPane extends Pane {
    public ChessPane() {
        Rectangle rectangle_outside = new Rectangle(40, 40, 820, 920); //棋盘边界外矩形
        rectangle_outside.setStrokeWidth(5);
        rectangle_outside.setStroke(Color.GREEN);
        rectangle_outside.setFill(Color.WHITE);
        getChildren().add(rectangle_outside);
        Rectangle rectangle_inside = new Rectangle(50, 50, 800, 900);//棋盘边界内矩形
        rectangle_inside.setStroke(Color.GREEN);
        rectangle_inside.setFill(Color.WHITE);
        getChildren().add(rectangle_inside);
        for (int i = 150; i < 900; i += 100) {
            Line line_H = new Line(50, i, 850, i);      //绘制棋盘的8条横线
            line_H.setStroke(Color.GREEN);
            getChildren().add(line_H);
        }
        for (int i = 150; i < 800; i += 100) {
            Line line_up = new Line(i, 50, i, 450);    //绘制棋盘上半部分的7条竖线
            line_up.setStroke(Color.GREEN);
            getChildren().add(line_up);
            Line line_down = new Line(i, 550, i, 950);  //绘制棋盘下半部分的7条竖线
            line_down.setStroke(Color.GREEN);
            getChildren().add(line_down);
        }
        Line line1 = new Line(350, 50, 550, 250);//绘制4条肋道
        line1.setStroke(Color.GREEN);
        getChildren().add(line1);
        Line line2 = new Line(550, 50, 350, 250);
        line2.setStroke(Color.GREEN);
        getChildren().add(line2);
        Line line3 = new Line(350, 950, 550, 750);
        line3.setStroke(Color.GREEN);
        getChildren().add(line3);
        Line line4 = new Line(550, 950, 350, 750);
        line4.setStroke(Color.GREEN);
        getChildren().add(line4);
        Text text_1 = new Text(140, 520, "楚河");   //楚河
        text_1.setFont(Font.font("KaiTi", 60));
        getChildren().add(text_1);
        Text text_2 = new Text(640, 520, "汉界");   //汉界
        text_2.setFont(Font.font("KaiTi", 60));
        getChildren().add(text_2);

       String[] chess_name = {
                "車", "马", "相", "仕", "帅", "仕", "相", "马", "車",
                "炮", "炮", "兵", "兵", "兵", "兵", "兵",              //红方16个棋子
                "卒", "卒", "卒", "卒", "卒", "炮", "炮",
                "車", "马", "象", "士", "将", "士", "象", "马", "車"     //黑方16个棋子
        };
        for (int i = 0; i < 9; i++)     //绘制      車 马 相 仕 帅 仕 相 马 車(红)
        {
            Circle circle_out = new Circle(50 + i * 100, 50, 48);
            circle_out.setFill(Color.rgb(230, 195, 157));
            getChildren().add(circle_out);
            Circle circle_in = new Circle(50 + i * 100, 50, 44);
            circle_in.setStroke(Color.RED);
            circle_in.setFill(null);
            circle_in.centerXProperty().bind(circle_out.centerXProperty());//与外面的圆形属性绑定
            circle_in.centerYProperty().bind(circle_out.centerYProperty());
            getChildren().add(circle_in);
            Text text_red_name = new Text(20 + i * 100, 70, chess_name[i]);
            text_red_name.setFill(Color.RED);
            text_red_name.setFont(Font.font("KaiTi", 60));
            text_red_name.xProperty().bind(circle_out.centerXProperty().subtract(30));//与外面的圆形属性绑定
            text_red_name.yProperty().bind(circle_out.centerYProperty().add(20));
            getChildren().add(text_red_name);
            circle_out.setOnMouseDragged(e -> {
                circle_out.setCenterX((int) (e.getX() / 100) * 100 + 50);
                circle_out.setCenterY((int) (e.getY() / 100) * 100 + 50);
            });
        }
        for (int i = 9; i < 11; i++)       //绘制       炮      炮(红)
        {
            Circle circle_out = new Circle(150 + (i - 9) * 600, 250, 48);
            circle_out.setFill(Color.rgb(230, 195, 157));
            getChildren().add(circle_out);
            Circle circle_in = new Circle(150 + (i - 9) * 600, 250, 44);
            circle_in.setStroke(Color.RED);
            circle_in.setFill(null);
            circle_in.centerXProperty().bind(circle_out.centerXProperty());
            circle_in.centerYProperty().bind(circle_out.centerYProperty());
            getChildren().add(circle_in);
            Text text_red_name = new Text(-30 + 150 + (i - 9) * 600, 70 + 200, chess_name[i]);
            text_red_name.setFill(Color.RED);
            text_red_name.setFont(Font.font("KaiTi", 60));
            text_red_name.xProperty().bind(circle_out.centerXProperty().subtract(30));
            text_red_name.yProperty().bind(circle_out.centerYProperty().add(20));
            getChildren().add(text_red_name);
            circle_out.setOnMouseDragged(e -> {
                circle_out.setCenterX((int) (e.getX() / 100) * 100 + 50);
                circle_out.setCenterY((int) (e.getY() / 100) * 100 + 50);
            });
        }
        for (int i = 11; i < 16; i++)    //绘制         兵 兵 兵 兵 兵(红)
        {
            Circle circle_out = new Circle(50 + (i - 11) * 200, 350, 48);
            circle_out.setFill(Color.rgb(230, 195, 157));
            getChildren().add(circle_out);
            Circle circle_in = new Circle(50 + (i - 11) * 200, 350, 44);
            circle_in.setStroke(Color.RED);
            circle_in.setFill(null);
            circle_in.centerXProperty().bind(circle_out.centerXProperty());
            circle_in.centerYProperty().bind(circle_out.centerYProperty());
            getChildren().add(circle_in);
            Text text_red_name = new Text(-30 + 50 + (i - 11) * 200, 70 + 300, chess_name[i]);
            text_red_name.setFill(Color.RED);
            text_red_name.setFont(Font.font("KaiTi", 60));
            text_red_name.xProperty().bind(circle_out.centerXProperty().subtract(30));
            text_red_name.yProperty().bind(circle_out.centerYProperty().add(20));
            getChildren().add(text_red_name);
            circle_out.setOnMouseDragged(e -> {
                circle_out.setCenterX((int) (e.getX() / 100) * 100 + 50);
                circle_out.setCenterY((int) (e.getY() / 100) * 100 + 50);
            });
        }
        for (int i = 16; i < 21; i++)         //绘制       卒 卒 卒 卒 卒(黑)
        {
            Circle circle_out = new Circle(50 + (i - 16) * 200, 650, 48);
            circle_out.setFill(Color.rgb(230, 195, 157));
            getChildren().add(circle_out);
            Circle circle_in = new Circle(50 + (i - 16) * 200, 650, 44);
            circle_in.setStroke(Color.BLACK);
            circle_in.setFill(null);
            circle_in.centerXProperty().bind(circle_out.centerXProperty());
            circle_in.centerYProperty().bind(circle_out.centerYProperty());
            getChildren().add(circle_in);
            Text text_black_name = new Text(-30 + 50 + (i - 16) * 200, 70 + 600, chess_name[i]);
            text_black_name.setFill(Color.BLACK);
            text_black_name.setFont(Font.font("KaiTi", 60));
            text_black_name.xProperty().bind(circle_out.centerXProperty().subtract(30));
            text_black_name.yProperty().bind(circle_out.centerYProperty().add(20));
            getChildren().add(text_black_name);
            circle_out.setOnMouseDragged(e -> {
                circle_out.setCenterX((int) (e.getX() / 100) * 100 + 50);
                circle_out.setCenterY((int) (e.getY() / 100) * 100 + 50);
            });
        }
        for (int i = 21; i < 23; i++)         //绘制       炮      炮(黑)
        {
            Circle circle_out = new Circle(150 + (i - 21) * 600, 750, 48);
            circle_out.setFill(Color.rgb(230, 195, 157));
            getChildren().add(circle_out);
            Circle circle_in = new Circle(150 + (i - 21) * 600, 750, 44);
            circle_in.setStroke(Color.BLACK);
            circle_in.setFill(null);
            circle_in.centerXProperty().bind(circle_out.centerXProperty());
            circle_in.centerYProperty().bind(circle_out.centerYProperty());
            getChildren().add(circle_in);
            Text text_black_name = new Text(-30 + 150 + (i - 21) * 600, 70 + 700, chess_name[i]);
            text_black_name.setFill(Color.BLACK);
            text_black_name.setFont(Font.font("KaiTi", 60));
            text_black_name.xProperty().bind(circle_out.centerXProperty().subtract(30));
            text_black_name.yProperty().bind(circle_out.centerYProperty().add(20));
            getChildren().add(text_black_name);
            circle_out.setOnMouseDragged(e -> {
                circle_out.setCenterX((int) (e.getX() / 100) * 100 + 50);
                circle_out.setCenterY((int) (e.getY() / 100) * 100 + 50);
            });
        }
        for (int i = 23; i < 32; i++)    //绘制     車 马 相 仕 帅 仕 相 马 車(黑)
        {
            Circle circle_out = new Circle(50 + (i - 23) * 100, 950, 48);
            circle_out.setFill(Color.rgb(230, 195, 157));
            getChildren().add(circle_out);
            Circle circle_in = new Circle(50 + (i - 23) * 100, 950, 44);
            circle_in.setStroke(Color.BLACK);
            circle_in.setFill(null);
            circle_in.centerXProperty().bind(circle_out.centerXProperty());
            circle_in.centerYProperty().bind(circle_out.centerYProperty());
            getChildren().add(circle_in);
            Text text_black_name = new Text(20 + (i - 23) * 100, 970, chess_name[i]);
            text_black_name.setFill(Color.BLACK);
            text_black_name.setFont(Font.font("KaiTi", 60));
            text_black_name.xProperty().bind(circle_out.centerXProperty().subtract(30));
            text_black_name.yProperty().bind(circle_out.centerYProperty().add(20));
            getChildren().add(text_black_name);
            circle_out.setOnMouseDragged(e -> {
                circle_out.setCenterX((int) (e.getX() / 100) * 100 + 50);
                circle_out.setCenterY((int) (e.getY() / 100) * 100 + 50);
            });
        }
    }
}