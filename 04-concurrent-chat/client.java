import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class client{
	public static void main(String[] args) throws IOException {
		Socket s=new Socket("localhost",55555);
		DataInputStream dis= new DataInputStream(s.getInputStream());
		DataOutputStream dos= new DataOutputStream(s.getOutputStream());
		Scanner sc = new Scanner(System.in);
		System.out.println("Cooncetion suscceess");

		while(true){
			System.out.println("ENter message or quit");
			String msg=sc.nextLine();
			dos.writeUTF(msg);
			if(msg.equalsIgnoreCase("Quit")){
				System.out.println("CLosing connection");
				break;
			}
			msg=new String(dis.readUTF());
			System.out.println("From Server :\n"+msg);

		}
		dis.close();
		dos.close();
		s.close();
		sc.close();
	}
}