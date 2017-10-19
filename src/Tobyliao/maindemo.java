package Tobyliao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

//Client
public class maindemo {
	public static void main(String[] args) {  
		try{      
		Socket s=new Socket("localhost",1024);  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		dout.writeUTF("B10307108");  
		dout.flush();  
		  
		
		DataInputStream dis=new DataInputStream(s.getInputStream());  
		String  str=(String)dis.readUTF();  
		System.out.println("message= "+str);
		
		
		dout.close();
		s.close();  
		}catch(Exception e){System.out.println(e);}  
		}  

}
