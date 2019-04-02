
import java.io.*;
import java.net.*;
import java.util.*;

public class server{
	public static void main(String[] args) throws IOException{
		ServerSocket s = new ServerSocket(55555);
		Socket s1= s.accept();
		System.out.println("connection received");
		DataOutputStream dos=new DataOutputStream(s1.getOutputStream());

		Date date = new Date();
		dos.writeUTF(""+date);

		dos.close();
		s1.close();
		s.close();
		
	}
}