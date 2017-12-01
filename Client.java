import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		//byte[] buffer = new byte[500];
		try {
			System.out.println("Adesso provo a connettermi a 127.0.0.1");
			Socket client = new Socket("127.0.0.1" , 9000);
			System.out.println("Connesso");
			
			BufferedReader byServer = new BufferedReader (new InputStreamReader(client.getInputStream()));
			BufferedWriter toServer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			
	/***Marco consiglia così:*/		
			PrintStream xx = new PrintStream(client.getOutputStream());
	
	/***Teoricamente dovrebbe esserci flush() di default. Questo serve ad inserire l'invio. 
	Così il Servere dovrebbe leggere una stringa alla volta**/
			
			
                        String operator, number, number2;
			Scanner input = new Scanner(System.in);
                        //toServer.write(number);
                        //toServer.flush();
                        System.out.println("Inserisci il numero :");
                        number = input.nextLine();
			xx.println(number);
                        //toServer.write(number2);
                        //toServer.flush();
                        System.out.println("Inserisci l'operazione (+/-) o stop");
                        operator = input.nextLine();
                        xx.println(operator);
                        while(!operator.equals("stop")){
                            System.out.println("Inserisci il numero :");
                            number = input.nextLine();
                            xx.println(number);
                            
                            System.out.println("Risultato: " + byServer.readLine());
                            
                            System.out.println("Inserisci l'operazione (+/-) o stop");
                            operator = input.nextLine();
                            xx.println(operator);
                        }
			/*System.out.println("Mi vedi Server?");
                        System.out.println("hai scritto: " + input);
                        byServer.read();
                        toServer.newLine();
                        toServer.flush();*/
			
			
			
			
		}
		catch(IOException e){
			System.out.println(e + "Arrivederci Server!");
		}
	}
}