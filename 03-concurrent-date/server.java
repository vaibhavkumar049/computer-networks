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
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	public void communicate() throws IOException {
		DataInputStream dis=new DataInputStream(s1.getInputStream());
		DataOutputStream dos = new DataOutputStream(s1.getOutputStream());

		dos.writeUTF("Date or Time?(Exit to Quit)");
		String command=new String(dis.readUTF());
		while(true){
			Date dt=new Date();
			if(command.equalsIgnoreCase("Date")){
				SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy a");
				String msg="Current date: "+ft.format(dt);
				dos.writeUTF(msg);
			}
			else if(command.equalsIgnoreCase("Time")){
				SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss a");
				String msg="Current time: "+ft.format(dt);
				dos.writeUTF(msg);
			}else{
				dos.writeUTF("Invalid command");
			}
				dos.writeUTF("Date or Time?(Exit to Quit)");
				 command=new String(dis.readUTF());
				if(command.equalsIgnoreCase("Exit")){
					dos.writeUTF("Quit");
					break;
				}
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
				Clients ob=new Clients(s1);
			}
		}finally{
			s.close();
		}
	}
}