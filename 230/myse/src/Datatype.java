class Datatype{
	public static void main(String[]args){
        // ������
        byte b = 127; 
        b = 127;
        //b = 128; //error �߻� 
   
        int i = 5; 
	System.out.println(i); //5
	System.out.println(5); // �����Ϸ��� 5�� int�� �Ǵ�

	//long lo = 123456789012345; 
 	//long lo1 = 12345678901234;
	long lo2 = 12345678901234L;
	
	double d = 45.67;
	System.out.println(d); //45.67 
	
	//i = 45.67;  //  error �߻� : �Ǽ� ���� �����ؼ� �����Ϸ��� ������ �߻���Ŵ  
	System.out.println(45.67F); // float Ÿ���� �ڿ� F�� ����. 


	// ������ 
	char c; 
	c = 'A'; 
	c = 49; //'1'�� ����
	System.out.println(c); 


	c= 44032; //'��'�� ����
	System.out.print(c); 


	//����
	boolean flag; 
	//flag = True; //TRUE; //error �߻�
	flag = true;


	//�ڷ��� ��ȯ 
	//�ڵ� ����ȯ : byte-> short-> int-> long -> float -> double
	//              char-> 
	i = b;  // intŸ�� ������ �ڵ�����ȯ�Ǿ intŸ������ ��ȯ�� ��. 
	d = i; 
	System.out.println(b); //127
	System.out.println(i);  // 127
	System.out.println(d); //127.0 

	i = c; //'��'�� utf-16���� i�� ���� 
	System.out.println(i); // 44032 

	//���� ����ȯ : �� ū �ڷ����� ���� �� ���� ������ �ִٰܳ�... �׷����� ���� �߰��� �Ҿ���� �� ���� 
	i = 128; 
	//b = i;  // error�߻� 
	b = (byte)i; //��������ȯ������() cast�����ڶ�� ��. 
	System.out.println(b); //-128~127���� �����ѵ� �� ���� �Ѿ 128�� ���Ե�.   //-128�� ���� �Ѿ ���� Ȯ���� �� �ִ�. 
	
	i = 129; 
	b= (byte)i; 
	System.out.println(b); //�ּҰ����� ���ư��� -127�� �� 

	d = 45.67;
	i = (int)d; 
	System.out.println(i); // �Ҽ������ϰ� �߷�����. //45 
	

	
	
	}
}