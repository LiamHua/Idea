import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JFrame;

public class nEmpress {
    JFrame frame;
    int n=5;			//问题规模
    int waitTime=500;	//时间间隔
    Label mp[][]=new Label[n+1][n+1];
    Thread thread;
    public void create(){
        frame=new JFrame(String.valueOf(n)+"皇后问题");
        frame.setLayout(new GridLayout(n,n));
        Font font=new Font("",Font.BOLD,32);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                mp[i][j]=new Label();
                if((i+j)%2==0){
                    mp[i][j].setBackground(Color.black);
                }
                else{
                    mp[i][j].setBackground(Color.white);
                }
                mp[i][j].setFont(font);
                mp[i][j].setForeground(Color.blue);
                frame.add(mp[i][j]);
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(n*60, n*60);
        frame.setVisible(true);
        thread=Thread.currentThread();

        try {
            dfs(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    int vis[]=new int[n+1];
    int ans=0;
    public void dfs(int row) throws InterruptedException{
        if(row==n+1){
            ans++;
            System.out.print("第"+ans+"种摆法为：");
            for(int i=1;i<=n;i++){
                System.out.print(vis[i]+",");
            }
            System.out.println();
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    mp[i][j].setForeground(Color.green);
                }
            }
            thread.sleep(3*waitTime);
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){s
                    mp[i][j].setForeground(Color.blue);
                }
            }
            return;
        }
        else{
            for(int i=1;i<=n;i++){
                vis[row]=i;
                if(i>1)
                    mp[row][i-1].setText("");
                mp[row][i].setText("皇");
                boolean state=check(row);
                thread.sleep(waitTime);
                for(int z=1;z<=n;z++){
                    for(int j=1;j<=n;j++){
                        if((z+j)%2==0){
                            mp[z][j].setBackground(Color.black);
                        }
                        else{
                            mp[z][j].setBackground(Color.white);
                        }
                    }
                }
                if(state){
                    dfs(row+1);
                }
                mp[row][i].setText("");
            }
        }
    }

    public boolean check(int row){
        boolean flag1=true,flag2=true,flag3=true;
        int row1=1,row2=1,row3=1;
        for(int i=1;i<row;i++){
            if(vis[i]==vis[row]){
                flag1=false;
                row1=i;
            }
            if( (i-row)==(vis[i]-vis[row])){
                flag2=false;
                row2=i;
            }
            if((i-row)==-(vis[i]-vis[row])){
                flag3=false;
                row3=i;
            }
        }
        if(!flag1){
            for(int i=row;i>=row1;i--)
                mp[i][vis[row]].setBackground(Color.red);
        }
        if(!flag2){
            for(int i=row,j=vis[row];i>=row2;i--,j--){
                mp[i][j].setBackground(Color.red);
            }
        }
        if(!flag3){
            for(int i=row,j=vis[row];i>=row3;i--,j++){
                mp[i][j].setBackground(Color.red);
            }
        }
        if(!flag1 || !flag2 || !flag3)
            return false;
        return true;
    }

    public static void main(String args[]){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                (new nEmpress()).create();
            }
        });
    }
}