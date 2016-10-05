package extra;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Marshaller {
	public byte [] marshall(String message) throws IOException, InterruptedException{
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(byteStream);
		os.writeObject(message);
		
		return byteStream.toByteArray();
	}
	public String unmarshall(byte [] message) throws IOException,InterruptedException,ClassNotFoundException{
		ByteArrayInputStream byteStream = new ByteArrayInputStream(message);
		ObjectInputStream is = new ObjectInputStream(byteStream);
		return (String) is.readObject();
	}
}
