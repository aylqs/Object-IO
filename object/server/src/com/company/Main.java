//***********************************************************************
// 《物联网系统设计》 实践项目1 客户端与服务器端程序的通讯——服务端程序
// 栗青生  2020年2月
// 程序执行结果：
// 服务器程序已经运行，请运行客户端程序..，
// 等客户端上线运行后，显示客户端发来的信息
// 连接客户端成功
// 接收到的学生是Id = 1 ; Name = XXX
//************************************************************************
package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) {
	    System.out.println("服务器程序已经运行，请运行客户端程序...");
        Server server = new Server();
        server.communicate();

    }
}

class Server {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private ObjectInputStream inStream = null;

    public Server() {
    }

    public void communicate() {
        try {
            serverSocket = new ServerSocket(443);
            socket = serverSocket.accept();
            System.out.println("连接客户端成功");
            inStream = new ObjectInputStream(socket.getInputStream());
            Student student = (Student) inStream.readObject();
            System.out.println("接收到的学生是" + student);
            socket.close();
        } catch (SocketException se) {
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
    }
}
