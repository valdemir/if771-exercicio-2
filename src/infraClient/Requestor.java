package infraClient;

import java.rmi.UnknownHostException;

import upperClient.ClientRequestHandler;

public class Requestor {
	private ClientRequestHandler crh= new ClientRequestHandler("192.168.0.101",1313);
	
	public Termination invoke(Invocation req)throws UnknownHostException{
		
	}
}
