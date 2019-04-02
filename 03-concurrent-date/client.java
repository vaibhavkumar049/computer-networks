import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class client{
	public static void main(String[] args) throws IOException {
		Socket s =new Socket("localhost",55555);
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		Scanner sc= new Scanner(System.in);

		while(true){
			String reply=new String(dis.readUTF());
			System.out.println("server :"+reply);
			String msg=sc.nextLine();
			dos.writeUTF(msg);
			reply=new String(dis.readUTF());
			if(reply.equalsIgnoreCase("Quit")){
				System.out.println("CLosing connection");
				break;
			}
			System.out.println("From server:" +reply);
		}
		dis.close();
		dos.close();
		s.close();
		sc.close();

	}
}