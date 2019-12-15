package queens;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class scan {
    public static Scanner instance = new Scanner(System.in);
}

class queen{
    ImageIcon image = new ImageIcon("queen.png");//JLabel的皇后图标
    public int num = 0;	//皇后数量
    public int sum = 0;	//解的计数器
    public int set = 0;	//落子次数
    public int[] a;

    JFrame frame = new JFrame("棋盘");
    JLabel lab[][] = null;
    Scanner s;

    //构造函数，初始化问题的规模
    queen(){
        System.out.print("请输入皇后数量：");
        s = scan.instance;
        num = s.nextInt();
        sum = 0;
        a = new int[num];
    }

    queen(int n){
        num = n;
        sum = 0;
        a = new int[num];
    }

    //不带可视化计时间的n皇后回溯
    public void backtrack(int t){
        if (t >= num){
            sum++;				//解数++
        }
        else{
            for(int j = 0;j < num ;j++){
                a[t] = j;		//假设第t行第j列放棋子
                if (place(t)) {	//是否落子
                    set++;		//落子步数++
                    backtrack(t+1);	//落子，进入下一深度			//递归调用
                }
            }
        }
    }

    //带可视化不计时间的n皇后
    public void bbacktrack(int t){
        if (t >= num){			//判断是否超出棋盘大小
            sum++;
            for(int i = 0;i < num; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println();
            try {
                Thread.sleep(1000);			//休眠1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            for(int j = 0;j < num ;j++){

                a[t] = j;		//先将第t行放入j

                if (place(t)) {	//判断是否落子
                    try {
                        Thread.sleep(500);	//休眠0.1s
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    lab[t][a[t]].setIcon(image);	//落子
                    bbacktrack(t+1);					//递归调用
                }
                lab[t][a[t]].setIcon(null);
            }
        }
    }


    public boolean place(int t){	//判断是否落子，与减枝
        for(int i = 0; i < t;i++){
            //判断是否在同一列
            if(a[i] == a[t]) return false;
            //判断是否在同一斜线
            if((t-i)== Math.abs(a[t]-a[i])) return false;
        }
        return true;
    }


    public void chessboard(){		//棋盘绘制
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLocation(200,0);
        Image img = image.getImage();
        img = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        image.setImage(img);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(num,num));
        frame.setSize(num*100, num*100);
        frame.setResizable(true);
        lab = new JLabel[num][num];
        for(int i = 0;i <num;i++){
            for(int j = 0;j < num;j++){
                lab[i][j] = new JLabel();
                lab[i][j].setOpaque(true);//设置为透明，才能显示背景色
                if((i+j)%2==0){
                    lab[i][j].setBackground(Color.gray);
                }
                else{
                    lab[i][j].setBackground(Color.white);
                }
                frame.add(lab[i][j]);
            }
        }
    }



};

public class run {
    public static void run_q(int x){
        Scanner s = scan.instance;
        if (x == 0){
            System.out.println("请输入你想要测试的规模：" );
            int max = scan.instance.nextInt();
            for (int i=1 ;i <= max ;i++){
                queen q = new queen(i);
                long start = System.nanoTime();
                q.backtrack(0);
                long end = System.nanoTime();
                System.out.print( i + "皇后有" + q.sum + "种解 ，落子步数:" + q.set);
                System.out.println("用时:" + ((end-start)/1000000.000) + "ms");
            }

        }
        else if ( x == 1){
            queen q = new queen();
            q.chessboard();
            q.bbacktrack(0);
        }
        else if ( x == 2){
            System.out.print("请输入你想要测试的规模：" );
            int n = s.nextInt();
            boolean flag = true;
            System.out.println("请依此输入你想要的测试数据：");
            queen q = new queen(n);
            for(int i=0 ;i<n;i++)
                q.a[i] = -1;
            for(int i=0 ;i<n;i++){
                int index = s.nextInt()-1;
                if(q.a[index] == -1){	//判断是否之前有输入这一行的数据，有就直接失败
                    q.a[index] = s.nextInt()-1;
                    if (!q.place(i)) {flag = false;break;}//判断是否冲突
                }
                else {flag = false; break;}
            }
            if(!flag){
                System.out.println("失败");
            }
            else{
                System.out.println("成功");
            }
        }


    }

    public static void run_t() throws InterruptedException{

        boolean flag = true;
        while(flag){
            Scanner s = scan.instance;
            System.out.print("请输入数字，0测试计算时间，1代表可视化，2代表数据测试：");
            int x = s.nextInt();
            run_q(x);
            System.out.print("是否继续（y/n）：");
            String c = s.next();
            if( c.equals("n")) flag = false;

        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        run_t();

    }
}