import java.io.*;
import java.net.*;
import java.util.*;

public class server{
	 public static void main(String[] args) throws IOException {
		ServerSocket s= new ServerSocket(55555);
		Socket s1=s.accept();

		DataInputStream dis= new DataInputStream(s1.getInputStream());
		DataOutputStream dos= new DataOutputStream(s1.getOutputStream());

		String msg =new String(dis.readUTF());
		msg=msg.toUpperCase();
		dos.writeUTF(msg);

		dos.close();
		dis.close();
		s1.close();
		s.close();


	}
}