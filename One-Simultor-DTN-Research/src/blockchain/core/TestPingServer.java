package blockchain.core;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestPingServer {
	 public static void main(String[] args) throws IOException, InterruptedException {
		
		 URL url = new URL("http://localhost:8080/blockchain");
	        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.connect();

        int code = connection.getResponseCode();
//	        System.out.println("Response code of the object is "+code);
//	        if (code==200)
//	        {
//	            System.out.println("OK");
//	            System.out.println("OK");
//	            System.out.println("OK");
//	            System.out.println("OK");
//	            System.out.println("OK");
//	            System.out.println("OK");
//	            System.out.println("OK");
//	            System.out.println("OK");
//	            
//	        }
	    }
}
