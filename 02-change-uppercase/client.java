import java.io.*;
import java.net.*;
import java.util.*;

public class client{
	public static void main(String[] args) throws IOException{
		Socket s= new Socket("localhost",55555);
		DataInputStream dis= new DataInputStream(s.getInputStream());
		DataOutputStream dos= new DataOutputStream(s.getOutputStream());

		Scanner sc= new Scanner(System.in);

		System.out.println("Enetr the message ");
		String msg=sc.nextLine();
		dos.writeUTF(msg);

		msg= new String(dis.readUTF());
		System.out.println("Server reply:"+ msg);

		dis.close();
		dos.close();
		s.close();

	}
}