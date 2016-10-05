package upperServer;

import java.io.IOException;

import extra.Marshaller;

public class Server {

	public static void main(String[] args) {
		ServerRequestHandler srh=new ServerRequestHandler(1313);
		Marshaller ms2= new Marshaller();
		try {
			byte [] msg=srh.receiveTCP();
			char msgReady=ms2.unmarshall(msg).charAt(0);
			srh.sendTCP(msg);
			ServerRequestHandler srh2=new ServerRequestHandler(1515);
			switch(msgReady){
			case 'u':
				msg=srh2.receiveUDP();
				System.out.println("message received");
				srh2.sendUDP(msg);
				break;
			case 't':
				msg=srh2.receiveTCP();
				System.out.println("message received");
				srh2.sendTCP(msg);
				break;
			case 'h':
				String msg2=srh2.receiveHTTP();
				System.out.println("message received");
				srh2.sendHTTP(msg2);
				break;
			}
			System.out.println(msgReady);
		} catch (IOException e) {
			System.out.println("IO error");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("Interrupted error");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
		}

	}

}
