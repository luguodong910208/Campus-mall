package practise2;

public class SplitString {
	public static void splitString(String src, int len) {
		int byteNum = 0;
		if(null == src) {
			System.out.println("The source String is null!");
			return;
		}
		byteNum = src.length();
		//將String轉化為byte字節
		byte bt[] = src.getBytes();
		if(len > byteNum) {
			len = byteNum;
		}
		//判断是否出现了截半，截半的话字节对应的ASC码小于0
		if(bt[len] < 0) {
			String subStrx = new String(bt,0,--len);
			System.out.println("subStrx=="+subStrx);
		}else {
			String subStrx = new String(bt,0,len);
			System.out.println("subStrx=="+subStrx);
		}
	}
}
