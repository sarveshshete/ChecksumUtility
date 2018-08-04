/*******************AUTHOR: SARVESH SHETE***********************************/

package checksum;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Scanner;

public class Checksum {

	public static void main(String args[]) throws Exception {

		Scanner in = new Scanner(System.in);
	      System.out.println("Enter the filepath :");
	      String s = in.nextLine();
	      System.out.println("You entered : "+s);
		//String filepath = "C:\\Users\\sarvesh.p.shete\\Test\\testfile.docx";
		String filepath = s;
		
		MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
		
		FileInputStream fileInput = new FileInputStream(filepath);
		byte[] dataBytes = new byte[1024];

		int bytesRead = 0;

		while ((bytesRead = fileInput.read(dataBytes)) != -1) {
			messageDigest.update(dataBytes, 0, bytesRead);
		}
		

		byte[] digestBytes = messageDigest.digest();

		StringBuffer sb = new StringBuffer("");
		
		for (int i = 0; i < digestBytes.length; i++) {
			sb.append(Integer.toString((digestBytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		System.out.println("Checksum for the File: " + sb.toString());
		in.close();
		fileInput.close();

	}
}
