import java.io.IOException;
import java.net.Socket;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;


public class Client {
	public static void main(String[] args) {
		//byte[] buffer = new byte[500];
		try {
			System.out.println("Adesso provo a connettermi a 127.0.0.1");
			Socket client = new Socket("127.0.0.1" , 9000);
			System.out.println("Connesso");
			
			//BufferedReader byServer = new BufferedReader (new InputStreamReader(client.getInputStream()));
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}
