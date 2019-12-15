package team.bug.chat.model;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import team.bug.chat.Info.CurrentChatObj;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author liam
 */
public class FileStream {
    public void sentFile(File file, String fileName) throws IOException {
        Socket socket = new Socket(CurrentChatObj.address, 9998);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        long length = file.length();
        DataInputStream inStream = new DataInputStream(new FileInputStream(file));
        out.writeUTF(MyInfo.username);
        out.writeUTF("file");
        out.writeUTF(fileName);
        out.writeLong(length);
        byte[] bytes = new byte[(int) length];
        int len = -1;
        while ((len = inStream.read(bytes)) != -1){
            out.write(bytes);
        }
        out.flush();
        out.close();
        System.out.println("文件发送完毕！");
    }

    public String saveFile(){
        Stage stage = new Stage();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(stage);
        return file.getPath();
    }
}
