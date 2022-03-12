import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopy {
	public static void main(String[] args) {
		File file = new File("a.txt");
		String str = "금요일이다";

		try {
		    FileWriter fileWriter = new FileWriter(file);
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.println("오늘은 금요일이에요.\n");
		    printWriter.println("강사님!");
		    printWriter.println("오늘 3시에 기업설명회 있습니다.");
		    printWriter.println("잊어버리실까봐 미리 말씀드리는 거예요.");
		    printWriter.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		//읽기 
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			
			char[] cbuf = new char[1000];
			int offset = 0;
			int length = 1000;// 밖으로 빼면 재사용하겠다.
			while(true) {
				
				
				int size = fr.read(cbuf, offset, length);
				if(size== -1) {
					break;
				}
				for(char c: cbuf) {
					System.out.print(c);
					
				}
				
				
				
			}
			

			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//붙여넣기 
		
//		FileWriter fw = null;
//		
//		file1 = new File("a.txt");
//		File newFile = new File("acopy.txt");
//		FileInputStream input = new FileInputStream(file);
//		FileOutputStream output = new FileOutputStream(newFile);
//
//		byte[] buf = new byte[1024];
		//나중 
		String oriFilePath= "a.txt";
		String copyFilePath = "acopy.txt";
//		//파일객체생성
        File oriFile = new File(oriFilePath);
//        //복사파일객체생성
        File copyFile = new File(copyFilePath);
		
//		String fileName = "acopy.txt";
////		FileWriter fw = null;
////		fw = new FileWriter(fileName);
////		fw.write("a.txt");
//		String oriFilePath = "a.txt";
//		FileWriter fw1 = null;
//		String copyFilePath = "acopy.txt";
//		try {
//			fw1= new FileOutputStream(fileName);
//			fw1.write("")
      //파일객체생성
        
        
        try {
            
            FileInputStream fis = new FileInputStream(oriFile); //읽을파일
            FileOutputStream fos = new FileOutputStream(copyFile); //복사할파일
            
            int fileByte = 0; 
            // fis.read()가 -1 이면 파일을 다 읽은것
            while((fileByte = fis.read()) != -1) {
                fos.write(fileByte);
            }
            //자원사용종료
            fis.close();
            fos.close();
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

			
		
		

		
		
		
		
		
	}

	