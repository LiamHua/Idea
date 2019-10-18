//模拟赛车
package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Car extends Application {
    Pane pane = new Pane();
    //BorderPane pane2 = new BorderPane();
    int X,Y;   //小车坐标
    private int num = 1;

    int counter = 0;   //记录第一个按钮的点击次数
    int min = 0,sec = 0, msec = 0;
    boolean flag = true;   //线程结束控制，不知为何值为false时无法生效
    boolean watch_start = false;  //线程状态控制
    //Button bt_start ;
    Button bt_clear ;
    Text timeText = new Text();;



    //ImageView car_1 = car(45);
    @Override
    public void start(Stage primaryStage) {

        Button stop = new Button("Stop");
        stop.setFont(Font.font(18));
        stop.setLayoutX(750);
        stop.setLayoutY(380);
        pane.getChildren().add(stop);

        Button Reset = new Button("Reset");
        Reset.setFont(Font.font(15));
        Reset.setLayoutX(250);
        //pane1.getChildren().add(Reset);
        Reset.setLayoutY(285);

        HBox speed = new HBox();
        pane.getChildren().add(speed);

        TextField size_1 = new TextField("10");
        size_1.setPrefColumnCount(2);

        TextField size_2 = new TextField("20");
        size_2.setPrefColumnCount(2);

        TextField size_3 = new TextField("30");
        size_3.setPrefColumnCount(2);

        TextField size_4 = new TextField("40");
        size_4.setPrefColumnCount(2);

        speed.getChildren().addAll(new Label("                      Car1:"), size_1, new Label("                             Car2:"), size_2, new Label("                          Car3:"), size_3, new Label("                              Car4:"), size_4);

        //Rectangle Car_lane1 = lane(40);  //参数为纵坐标
        //Rectangle Car_lane2 = lane(100);
        //Rectangle Car_lane3 = lane(160);
        //Rectangle Car_lane4 = lane(220);
        pane.getChildren().add(lane(40));
        pane.getChildren().add(lane(100));
        pane.getChildren().add(lane(160));
        pane.getChildren().add(lane(220));


        //pane.getChildren().add(car(45));
        //pane.getChildren().add(car(105));
        //pane.getChildren().add(car(165));
        //pane.getChildren().add(car(225));


        //pane2.setLayoutX(750);
        //pane2.setLayoutY(350);
        state thread = new state();
        timeText.setFont(Font.font("KaiTi", 50));
        timeText.setText("00:00:00");
        timeText.setLayoutX(750);
        timeText.setLayoutY(350);

        //bt_start = new Button("Start");
       // bt_start.setLayoutX(750);
        //bt_start.setLayoutY(400);
        //bt_start.setFont(Font.font(17));
        bt_clear = new Button("Clear");
        bt_clear.setFont(Font.font(18));
        bt_clear.setLayoutX(850);
        bt_clear.setLayoutY(380);

        pane.getChildren().addAll(timeText,bt_clear);





        Run car1 = new Run();
        car1.Y = 45;
        car1.y = 350;
        car1.num = 1;
        car1.Speed = Integer.parseInt(size_1.getText());
        size_1.setOnAction(e ->{
            car1.Speed = Integer.parseInt(size_1.getText());
        });
        car1.start();

        Run car2 = new Run();
        car2.Y = 105;
        car2.y = 380;
        car2.num = 2;
        car2.Speed = Integer.parseInt(size_2.getText());
        size_2.setOnAction(e ->{
            car2.Speed = Integer.parseInt(size_2.getText());
        });
        car2.start();

        Run car3 = new Run();
        car3.Y = 165;
        car3.y = 410;
        car3.num = 3;
        car3.Speed = Integer.parseInt(size_3.getText());
        size_3.setOnAction(e ->{
            car3.Speed = Integer.parseInt(size_3.getText());
        });
        car3.start();

        Run car4 = new Run();
        car4.Y = 225;
        car4.y = 440;
        car4.num =4;
        car4.Speed = Integer.parseInt(size_4.getText());
        size_4.setOnAction(e ->{
            car4.Speed = Integer.parseInt(size_4.getText());
        });
        car4.start();





        /*stop.setOnAction(e ->{
            if(num==1){
                car1.pauseThread();
                car2.pauseThread();
                car3.pauseThread();
                car4.pauseThread();
                stop.setText("Resume");
                num = 2;
            }
            else{
                car1.resumeThread();
                car2.resumeThread();
                car3.resumeThread();
                car4.resumeThread();
                stop.setText("Stop");
                num = 1;
            }
        });

        Reset.setOnAction(e->{
            car1.reset();
            car2.reset();
            car3.reset();
            car4.reset();
        });*/


        watch_start = true;
        thread.start();

        /*bt_start.setOnAction(e -> {
            if (counter == 0)
            {
                bt_start.setText("Pause");
                counter = 1;



                car2.start();
                car3.start();
                car4.start();

            }
            else if (counter == 1)
            {
                bt_start.setText("Resume");
                counter = 2;
                thread.pauseThread();

                car1.pauseThread();
                //car2.pauseThread();
                //car3.pauseThread();
                //car4.pauseThread();

            }
            else if(counter == 2)
            {
                bt_start.setText("Pause");
                counter = 1;
                thread.resumeThread();

                car1.resumeThread();
                //car2.resumeThread();
                //car3.resumeThread();
                //car4.resumeThread();
            }
        });
         */

        stop.setOnAction(e->{
            if(counter==0){
                counter = 1;
                stop.setText("Resume");
                thread.pauseThread();

                car1.pauseThread();
                car2.pauseThread();
                car3.pauseThread();
                car4.pauseThread();
            }
           else if(counter==1){
               stop.setText("Stop");
                counter = 0;
                thread.resumeThread();

                car1.resumeThread();
                car2.resumeThread();
                car3.resumeThread();
                car4.resumeThread();
            }
        });

        bt_clear.setOnAction(e -> {
            //thread.pauseThread();
            timeText.setText("00:00:00");
            min = sec = msec = 0;
            //bt_start.setText("Start");
            counter = 2;       //第一次是在此改动flag标志妄图结束线程，却不知为何线程无法结束，故第二次采用暂停与恢复的方法

            car1.reset();
            car2.reset();
            car3.reset();
            car4.reset();
        });

        //pane.getChildren().add(pane2);

        Scene scene = new Scene(pane, 1000, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 16_25   赛车");
        primaryStage.show();
    }



    private class state extends Thread {
        private final Object timer = new Object();

        void pauseThread() {
            watch_start = false;
        }

        void resumeThread() {
            watch_start = true;
            synchronized (timer) {
                timer.notify();
            }
        }

        void onPause() {
            watch_start = false;
            synchronized (timer) {
                try {
                    timer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void run() {
            super.run();
            while (flag) {
                while (watch_start) {
                    msec++;
                    if (msec == 100) {
                        msec = 0;
                        sec++;
                        if (sec == 60) {
                            sec = 0;
                            min++;
                        }
                    }

                    String format_h = String.format("%02d",min);
                    String format_min = String.format("%02d",sec);
                    String format_sec = String.format("%02d",msec);   //格式化输出

                    timeText.setText(format_h + ":" + format_min + ":" + format_sec);
                    try {
                        sleep(16);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                onPause();
            }
        }
    }


    private Rectangle lane(int Y) {
        Rectangle CarLine = new Rectangle();
        CarLine.setHeight(50);
        CarLine.setWidth(990);
        CarLine.setLayoutX(5);
        CarLine.setLayoutY(Y);
        CarLine.setFill(Color.WHITE);
        CarLine.setStroke(Color.BLACK);

        return CarLine;
    }

    private ImageView car(int Y) {
        ImageView car = new ImageView("image/car.png");
        car.setFitHeight(40);
        car.setFitWidth(60);
        car.setLayoutX(5);
        car.setLayoutY(Y);
        return car;
    }


    public class Run extends Thread {

        int Speed;
        int x;
        int Y;
        int y;
        int num;
        boolean flag = true;
        ImageView carR = new ImageView("image/car.png");

        void pauseThread() {
            flag = false;
        }

        void resumeThread() { flag = true; }

        void reset(){x = 5;}

        public void run() {
            Text time = new Text();
            time.setLayoutX(50);
            time.setLayoutY(y);
            time.setFont(Font.font(16));
            pane.getChildren().add(time);

            carR.setFitHeight(40);
            carR.setFitWidth(60);
            pane.getChildren().add(carR);
                for (x = 10; x <= 930; x += 10) {
                    if(x==930)
                        time.setText("第 "+ num +"辆小车的到达时间为 "+min+ ":" + sec + ":" + msec);
                    while (!flag){
                        try{
                            Thread.sleep(10);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    carR.setLayoutX(x);
                    carR.setLayoutY(Y);
                    System.out.println(x);
                    try {
                        Thread.sleep(2000/Speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}
