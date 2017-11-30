import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			System.out.println("Adesso provo a connettermi a 127.0.0.1");
			Socket client = new Socket("127.0.0.1" , 9000);
			System.out.println("Connesso");
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}
