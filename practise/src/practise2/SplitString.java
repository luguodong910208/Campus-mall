package practise2;

public class SplitString {
	public static void splitString(String src, int len) {
		int byteNum = 0;
		if(null == src) {
			System.out.println("The source String is null!");
			return;
		}
		byteNum = src.length();
		//��String�D����byte�ֹ�
		byte bt[] = src.getBytes();
		if(len > byteNum) {
			len = byteNum;
		}
		//�ж��Ƿ�����˽ذ룬�ذ�Ļ��ֽڶ�Ӧ��ASC��С��0
		if(bt[len] < 0) {
			String subStrx = new String(bt,0,--len);
			System.out.println("subStrx=="+subStrx);
		}else {
			String subStrx = new String(bt,0,len);
			System.out.println("subStrx=="+subStrx);
		}
	}
}
