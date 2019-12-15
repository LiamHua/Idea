package team.bug.chat.model;

import java.io.*;
import java.net.Socket;

public class SentFile {
    public static void sentFile(String address, String msg, File file,String fileName) throws IOException {
        Socket socket = new Socket(address, 9998);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        long length = file.length();
        DataInputStream inStream = new DataInputStream(new FileInputStream(file));
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
}
