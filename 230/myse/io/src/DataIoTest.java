import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIoTest {
	public static void write() {
		String fileName = "a.dat";
		FileOutputStream fos = null;
		DataOutputStream dos = null; 
		try {
			fos = new FileOutputStream(fileName);
			dos = new DataOutputStream(fos);
			dos.writeInt(10);
			dos.writeBoolean(true);
			dos.writeDouble(12.3);
			dos.writeUTF("가나다");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(dos != null) {
				try {
					dos.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  //여기까지 쓰기 작업 //외부에서 아무나 보지 못하게 하려고 만든 것이 filter stream 
		}
		

	}
	}
	public static void read() {
		String fileName = "a.dat";
		FileInputStream fis = null;
		DataInputStream dis = null;
	try {
		fis = new FileInputStream(fileName);
		dis = new DataInputStream(fis);
		int i = dis.readInt();
		boolean b = dis.readBoolean();
		double d = dis.readDouble();
		String s = dis.readUTF();
		System.out.println("int값=" + i);
		System.out.println("boolean값=" + b);
		System.out.println("double값=" + d);
		System.out.println("UTF값=" + s );
		
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}finally {
	if(fis != null) {
		try {
			fis.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
			
	}
	}

	public static void main(String[] args) {
		
//		write(); // 이미 써서 코맴트 
		read();
	}
}
