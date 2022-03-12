package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient3 {
	Socket s;
	OutputStream os;
	String serverIP;
	DataOutputStream dos;
	
	Scanner sc; //키보드 입력스트림 
	
	int serverPort;
	public TCPClient3() {
//		serverIP = "127.0.0.1";
//		serverPort = 5432;
		this("127.0.0.1", 5432);
	}
	public TCPClient3(String serverIp, int serverPort) {
		this.serverIP = serverIp;
		this.serverPort = serverPort;
		try {
			s = new Socket(serverIP, serverPort);
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			
//			dos.writeUTF("가나다");
			sc = new Scanner(System.in);
//			String line = sc.nextLine();
//			dos.writeUTF(line);
			String line = "quit";
			do {
				line = sc.nextLine();
				dos.writeUTF(line);
			}while(!line.equals("quit"));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch(ConnectException e){
			System.out.println("서버와 연결실패. 서버가 켜져있는지 확인하세요");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sc!= null) {
				sc.close();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new TCPClient3();
		//new TCPClient1("192.168.75.64", 6543);
	}

}
