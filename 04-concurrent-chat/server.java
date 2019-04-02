import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

class Clients implements Runnable{
	Socket s1;
	Clients(Socket s1){
		this.s1=s1;
		new Thread(this,"Client").start();
	}
	public void run(){
		try{
			this.communicate();
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	public void communicate() throws IOException{
		DataInputStream dis= new DataInputStream(s1.getInputStream());
		DataOutputStream dos= new DataOutputStream(s1.getOutputStream());

		Scanner sc = new Scanner(System.in);

		while(true){
			String msg= new String(dis.readUTF());
			if(msg.equalsIgnoreCase("quit")){
				System.out.println("CLosing connection"+s1);
				break;
			}
			System.out.println("From"+s1+":-"+msg+"\n reply:");
			msg=sc.nextLine();
			dos.writeUTF(msg);

		}
		dos.close();
		dis.close();
		s1.close();
	}
}

public class server{
	public static void main(String[] args) throws IOException {
		ServerSocket s=null;
		try{
			s=new ServerSocket(55555);
			while(true){
				Socket s1=s.accept();
				System.out.println("COnncetion reco"+s1);
				Clients ob= new Clients(s1);
			}
		}finally{
				s.close();
		}
		
	}
}