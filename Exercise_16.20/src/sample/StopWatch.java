//模拟秒表

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class StopWatch extends Application
{
    int counter = 0;   //记录第一个按钮的点击次数
    int min = 0,sec = 0, msec = 0;
    boolean flag = true;   //线程结束控制，不知为何值为false时无法生效
    boolean watch_start = false;  //线程状态控制

    Button bt_start = new Button("Start");
    Button bt_clear = new Button("Clear");
    Text timeText = new Text();;


    public  void start (Stage primaryStage)
    {
        BorderPane pane = new BorderPane();

        timeText.setFont(Font.font("KaiTi", 50));
        timeText.setText("00:00:00");


        pane.setCenter(timeText);
        pane.setBottom(getHBox());

        state thread = new state();

        bt_start.setOnAction(e -> {
            if (counter == 0)
            {
                bt_start.setText("Pause");
                counter = 1;
                watch_start = true;
                thread.start();
            }
            else if (counter == 1)
            {
                bt_start.setText("Resume");
                counter = 2;
                thread.pauseThread();
            }
            else if(counter == 2)
            {
                bt_start.setText("Pause");
                counter = 1;
                thread.resumeThread();
            }
        });

        bt_clear.setOnAction(e -> {
            thread.pauseThread();
            timeText.setText("00:00:00");
            min = sec = msec = 0;
            bt_start.setText("Start");
            counter = 2;       //第一次是在此改动flag标志妄图结束线程，却不知为何线程无法结束，故第二次采用暂停与恢复的方法
    });

        Scene scene = new Scene(pane,450,200);
        primaryStage.setTitle("Exercise 16_20     累计秒表");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private HBox getHBox()
    {
        HBox paneForButtons = new HBox(20);

        paneForButtons.getChildren().addAll(bt_start, bt_clear);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color:red");

        return paneForButtons;
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
                        sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                onPause();
            }
        }
    }

}