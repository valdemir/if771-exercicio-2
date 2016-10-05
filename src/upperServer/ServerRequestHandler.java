package upperServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class ServerRequestHandler {
	private int portNumber;
	private int clientPortNumber;
	private ServerSocket welcomeSocket =null;
	private Socket connectionSocket = null;
	
	private int sentMessageSize;
	private int receivedMessageSize;
	private DataOutputStream outToClient = null;
	private DataInputStream inFromClient = null;
	
	private DatagramSocket serverUDPSocket = null;
	private DatagramPacket receivedDatagramPacket = null;
	private DatagramPacket sentDatagramPacket = null;
	private byte[] receivedData = new byte[1024];
//	private byte[] sentData = new byte[1024];
	private InetAddress IPAddress = null;
	
	BufferedReader in;
	
	public ServerRequestHandler(int portNumber){
		this.portNumber=portNumber;
	}
	
	public void sendTCP(byte[] msg) throws IOException,InterruptedException{
		sentMessageSize = msg.length;
		outToClient.writeInt(sentMessageSize);
		outToClient.write(msg);
		outToClient.flush();
		
		connectionSocket.close();
		welcomeSocket.close();
		outToClient.close();
		inFromClient.close();
	}
	
	public byte[] receiveTCP() throws IOException,InterruptedException{
		byte[] msg = null;
		
		welcomeSocket= new ServerSocket(portNumber);
		connectionSocket = welcomeSocket.accept();
		
		//daqui pra frente, ele segue o tcp
		outToClient= new DataOutputStream(connectionSocket.getOutputStream());
		inFromClient = new DataInputStream(connectionSocket.getInputStream());
		receivedMessageSize = inFromClient.readInt();
		msg = new byte[receivedMessageSize];
		inFromClient.read(msg,0,receivedMessageSize);
		
		return msg;
	}
	
	public void sendUDP(byte[] msg) throws IOException,InterruptedException{
		sentDatagramPacket = new DatagramPacket(msg, msg.length, IPAddress, clientPortNumber);
		serverUDPSocket.send(sentDatagramPacket);
		
		serverUDPSocket.close();
	}
	
	public byte[] receiveUDP() throws IOException,InterruptedException {
		byte[] msg = null;
		String msgAux = null;
		
		serverUDPSocket = new DatagramSocket(portNumber);
		receivedDatagramPacket = new DatagramPacket(receivedData, receivedData.length);
		serverUDPSocket.receive(receivedDatagramPacket);
		msgAux = new String(receivedDatagramPacket.getData());
		msg = msgAux.getBytes();
		IPAddress = receivedDatagramPacket.getAddress();
		clientPortNumber = receivedDatagramPacket.getPort();
		
		return msg;
	}
	public String receiveHTTP() throws IOException,InterruptedException{
		welcomeSocket= new ServerSocket(portNumber);
		connectionSocket = welcomeSocket.accept();
		in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		String a=in.readLine();
		in.close();
		return a;
	}
	public void sendHTTP(String a) throws IOException,InterruptedException{
		OutputStream out = connectionSocket.getOutputStream();
		String response = "HTTP/1.1 200 OK\n\r";
		response = response + "Date: Fri, 04 May 2001 20:08:11 GMT\n\r";
		response = response + "Server: Sanjits Server\n\r";
		response = response + "Connection: close\n\r";
		response = response + a; 
		byte[] bytes = response.getBytes(); 
		out.write(bytes);
		out.flush();
		out.close();
		
	}
}
