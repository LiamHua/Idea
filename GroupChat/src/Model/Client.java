package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Client.class.getResource("/View/ChatGroup.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

//class Send implements Runnable{
//    private String name;
//    private DataOutputStream dos=null;
//    private boolean isRunning=true;
//
//    public Send(Socket socket,String name) {
//        try {
//            dos=new DataOutputStream(socket.getOutputStream());
//            this.name=name;
//        } catch (IOException e) {
//            e.printStackTrace();
//            isRunning=false;
//        }
//    }
//    public void send(){
//        Scanner scanner=new Scanner(System.in);
//        String message=scanner.nextLine();
//        try {
//            dos.writeUTF(name+":"+message);
//        } catch (IOException e) {
//            e.printStackTrace();
//            isRunning=false;
//        }
//    }
//    @Override
//    public void run() {
//        while (isRunning)
//        {
//            send();
//        }
//    }
//}
//
//class Receive implements Runnable{
//    private DataInputStream dis=null;
//    private boolean isRunning=true;
//
//    public Receive(Socket socket) {
//        try {
//            dis=new DataInputStream(socket.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//            isRunning=false;
//        }
//    }
//    public void receive(){
//        try {
//            String message=dis.readUTF();
//            System.out.println(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//            isRunning=false;
//        }
//    }
//    @Override
//    public void run() {
//        while (isRunning)
//        {
//            receive();
//        }
//    }
//}