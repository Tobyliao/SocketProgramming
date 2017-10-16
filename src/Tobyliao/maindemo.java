package Tobyliao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//Client
public class maindemo {
	public static void main(String args[]) {
		Socket MyClient = null;
		DataInputStream input = null;
		DataOutputStream output = null;
		
		//Initialize Section
		//set up the port to connect
		try {
			MyClient = new Socket("Tobyliao",1024);
			input = new DataInputStream(MyClient.getInputStream());
			output = new DataOutputStream(MyClient.getOutputStream());
			
		} catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
		
		//Initialize Section Finish	
		
		if(MyClient!=null && input!=null && output!=null) {
			try {
				output.writeBytes("Hello! \n");
				output.writeBytes("My Name is Tobyliao! \n");
				output.writeBytes("My StdID is B10307108 \n");
				output.writeBytes("Quit");
				
				String responseLine;
				while((responseLine=input.readLine())!=null) {
					System.out.println("Server:"+responseLine);
					if (responseLine.indexOf("Ok") != -1) {
	                      break;
	                    }
					
				}
				
				// clean up:
		        output.close();
		        input.close();
		        MyClient.close();
				
			} catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
			
		}	
	}
}
