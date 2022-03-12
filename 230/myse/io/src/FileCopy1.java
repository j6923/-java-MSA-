import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy1 {

	public static void main(String[] args) {
		String originFileName= "a.txt"; //원본
		String destFileNmae = "acopy.txt";  //대상 
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(originFileName);
			fos = new FileOutputStream(destFileNmae);
			int readValue = -1;
//			while((readValue = fis.read())!= -1) {
//				fos.write(readValue);
//			}
			byte [] buf = new byte[100];
			while(true) {
				int count = fis.read(buf, 0, buf.length);
				if(count==-1) {
					break;
				}
				fos.write(buf, 0, count);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
}
			
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
