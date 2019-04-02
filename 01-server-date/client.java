import java.io.*;
import java.net.*;
import java.util.*;

public class client{
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost",55555);
		DataInputStream dis= new DataInputStream(s.getInputStream());
		String date= new String(dis.readUTF());
		System.out.println("Server Date:"+date);
		dis.close();
		s.close();
	}
}