import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

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
            	toClient.write("Dammi i numeri da sommare!! Adesso!");
            	toClient.flush();
		    
		operator = byClient.readLine();
            	System.out.println("E' stato inserito l'operatore: " + operator);
			
		number = Integer.parseInt(byClient.readLine());
            	System.out.println("E' stato inserito il 1° numero: " + number);
            
            	number2 = Integer.parseInt(byClient.readLine());
            	System.out.println("E' stato inserito il 2° numero: " + number2);
            
            	if(!operator.equals("-") )  {
                	total = number+number2;
            	}else
                	total = number-number2;
            
            	System.out.println("Il tuo risultato è: " + number + operator + number2 +"= " + total);
			
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
