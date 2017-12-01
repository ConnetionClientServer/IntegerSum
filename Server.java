import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		String operator; 
       	int number, number2;
        int total;
		
	    try {
	    	ServerSocket service = new ServerSocket(9000);
	    	service.setSoTimeout(10000);
	    	System.out.println("Apro la connessione sulla porta 9000");
	    	Socket socket = service.accept();
	    	System.out.println("Un client si è connesso!"); 
		    
		BufferedReader byClient = new BufferedReader (new InputStreamReader(socket.getInputStream()));
            	BufferedWriter toClient = new BufferedWriter (new OutputStreamWriter(socket.getOutputStream()));
                PrintStream xx = new PrintStream(socket.getOutputStream());
                
                /*operator = byClient.readLine();
                System.out.println("E' stato inserito l'operatore: " + operator);*/
                total = Integer.parseInt(byClient.readLine());
                System.out.println("E' stato inserito il numero: " + total);       
                operator = byClient.readLine();
                System.out.println("E' stato inserito l'operatore: " + operator);
                while(!operator.equals("stop")){
                    number = Integer.parseInt(byClient.readLine());
                    System.out.println("E' stato inserito il numero: " + number);
                    if(!operator.equals("-") )  {
                            total = total + number;
                    }else total = total - number;
                    xx.println("Il tuo risultato è: " + total);
                    System.out.println("Il tuo risultato è: " + total);
                    operator = byClient.readLine();
                    System.out.println("E' stato inserito l'operatore: " + operator);
                }	
	    	socket.close();
	    	service.close();
	    }
	    catch(SocketTimeoutException t){
	    	System.out.println("Tempo scaduto");
	    }
	    catch (IOException e) {
	           System.out.println(e + "ciao ciao");
	    }
	}
}