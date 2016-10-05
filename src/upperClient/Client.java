package upperClient;

import java.io.IOException;

import extra.Marshaller;

public class Client {

	public static void main(String[] args) {
		String msg= "testando...";
		Marshaller ms= new Marshaller();
		char protocol='h'; //u=udp, t=tcp, h=http
		ClientRequestHandler crh=new ClientRequestHandler("192.168.0.101",1313);
		
		try {
			//primeiro ele manda o protocolo de comunicacao
			byte [] msgMarshalled=ms.marshall(protocol+"");
			crh.sendTCP(msgMarshalled);
			
			byte[] echo=crh.receiveTCP();
			String echoUnmarshalled=ms.unmarshall(echo);
			//depois ele manda a mensagem em si
			ClientRequestHandler messager=new ClientRequestHandler("192.168.0.101",1515);
			byte [] testMessage = ms.marshall(msg);
			
			switch(protocol){
			case 'u':
				messager.sendUDP(testMessage);
				echo=messager.receiveUDP();
				echoUnmarshalled=ms.unmarshall(echo);
				break;
			case 't':
				messager.sendTCP(testMessage);
				echo=messager.receiveTCP();
				echoUnmarshalled=ms.unmarshall(echo);
				break;
			case 'h':
				messager.sendHTTP(testMessage);
				echoUnmarshalled=messager.receiveHTTP(); 
				break;
			}
			System.out.println(echoUnmarshalled);
			
		} catch (IOException e) {
			System.out.println("IO error");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("Interruption error");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		

	}

}
