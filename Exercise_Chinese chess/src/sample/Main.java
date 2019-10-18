package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class Main extends Application {
    Pane pane = new Pane();
    @Override
    public void start(Stage primaryStage){
        ImageView background = new ImageView("image/chess.jpg");
        background.setFitWidth(900);
        background.setFitHeight(1000);
        pane.getChildren().add(background);
        Rectangle boundary_outside = new Rectangle(40,40,820,920);
        boundary_outside.setStroke(Color.BLACK);
        boundary_outside.setStrokeWidth(4);
        boundary_outside.setFill(null);
        pane.getChildren().add(boundary_outside);

        Rectangle boundary_inside = new Rectangle(50,50,800,900);
        boundary_inside.setStroke(Color.BLACK);
        boundary_inside.setStrokeWidth(2);
        boundary_inside.setFill(null);
        pane.getChildren().add(boundary_inside);

        int num = 1;
        for(int y=150;y<900;y+=100) {
            Line line_across = new Line();
            line_across.setStartX(50);
            line_across.setStartY(y);
            line_across.setEndX(850);
            line_across.setEndY(y);
            if(num == 4||num == 5)
                line_across.setStrokeWidth(3);
            num+=1;
            pane.getChildren().add(line_across);
        }
        
        for(int x=150;x<900;x+=100) {
            Line line_vertical_top = new Line();
            line_vertical_top.setStartX(x);
            line_vertical_top.setStartY(50);
            line_vertical_top.setEndX(x);
            line_vertical_top.setEndY(450);
            pane.getChildren().add(line_vertical_top);
        }

        for(double x=150;x<900;x+=100) {
            Line line_vertical_bottom = new Line();
            line_vertical_bottom.setStartX(x);
            line_vertical_bottom.setStartY(550);
            line_vertical_bottom.setEndX(x);
            line_vertical_bottom.setEndY(950);
            pane.getChildren().add(line_vertical_bottom);
        }

        pane.getChildren().add(new Line(350,50,550,250));
        pane.getChildren().add(new Line(350,250,550,50));
        pane.getChildren().add(new Line(350,750,550,950));
        pane.getChildren().add(new Line(350,950,550,750));

        Text text1 = new Text(130,520,"楚河           漢界");
        text1.setFont(Font.font("KaiTi",65));
        pane.getChildren().add(text1);

        int i = 0,flag = 0,x = 50;
        while(true) {
            if(x==1050) break;
            if(x>850) x=50;
            if(i<9){
                Circle chessBlack1 = chess("BLACK",0,i,x,50);
                Circle chessRed1 = chess("RED",1,i,x,950);
                i++;
                x+=100;
            }
            else if (i<10){
                while (flag<2) {
                    Circle chessBlack2 = chess("BLACK",0, i, x + 100, 250);
                    Circle chessRed2 = chess("RED",1, i , x + 100, 750);
                    x += 600;
                    flag++;
                }
                i = 10;
            }
            else if (i<11){
                Circle chessBlack3 = chess("BLACK",0,i,x,350);
                Circle chessRed3 = chess("RED",1,i,x,650);
                x+=200;
            }
        }

        Scene scene = new Scene(pane,900,1000);
        primaryStage.setTitle("Chinese chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle chess(String co,int n,int m,int X,int Y){
        String[][] chessMen = {
                {"車", "馬", "象", "士", "將", "士", "象", "馬", "車", "炮", "卒"},
                {"車", "馬", "相", "仕", "帥", "仕", "相", "馬", "車", "砲", "兵"},
        };
        Text text = new Text(chessMen[n][m]);
        text.setFill(Color.valueOf(co));
        text.setFont(Font.font("KaiTi",70));
        Circle chessOut = new Circle(45);
        Circle chessIn = new Circle(40);
        chessOut.setFill(Color.rgb(255,203,154));
        chessOut.setStroke(null /*Color.valueOf(co)*/);
        chessOut.setStrokeWidth(4);
        chessOut.setCenterX(X);
        chessOut.setCenterY(Y);
        chessIn.setFill(null);
        chessIn.setStroke(Color.valueOf(co));
        chessIn.setStrokeWidth(2);
        chessIn.setCenterX(X);
        chessIn.setCenterY(Y);
        text.xProperty().bind(chessOut.centerXProperty().subtract(33));
        text.yProperty().bind(chessOut.centerYProperty().add(25));
        pane.getChildren().addAll(chessOut,chessIn,text);
        return chessOut;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
