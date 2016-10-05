package infraClient;

import java.io.Serializable;

public class ClientProxy implements Serializable{
	private static final long serialVersionUID = 3162556545791876201L;
		
	protected String host;
	protected int port;
	protected int objectID;
	
	public ClientProxy(String host, int port, int objectID) {
		super();
		this.host = host;
		this.port = port;
		this.objectID = objectID;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void setObjectID(int objectID) {
		this.objectID = objectID;
	}
	public int getObjectID(){
		return this.objectID;
	}
	
}
