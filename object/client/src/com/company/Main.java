//********************************************************************
// 《物联网系统设计》 实践项目1 客户端与服务器端程序通讯——客户端程序
// 栗青生  2020年2月
// 程序执行结果：
// 连上了服务器
// 学生对像已经发送 Id = 2017 ; Name = XXX
//**********************************************************************
package com.company;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) {
	    Client client = new Client();
        client.communicate();
    }
}

 class Client {
    private Socket socket = null;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;
    private boolean isConnected = false;

    public Client() {
    }

    public void communicate() {
        while (!isConnected) {
            try {
                socket = new Socket("localHost", 443);
                System.out.println("连上了服务器");
                isConnected = true;
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                Student student = new Student(2017, "XXX");
                System.out.println("学生对像已经发送 " + student);
                outputStream.writeObject(student);
            } catch (SocketException se) {
                se.printStackTrace();
// System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}