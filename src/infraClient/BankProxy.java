package infraClient;

import java.awt.event.InvocationEvent;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicComboPopup.InvocationKeyHandler;

import extra.NoMoneyException;

public class BankProxy extends ClientProxy implements Ibank{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8427265848381431450L;

	public BankProxy(String host, int port, int objectID) {
		super(host, port, objectID);
		
	}

	public int getSaldo(int id) throws Throwable {
		Invocation inv=new Invocation();
		Termination ter= new Termination();
		ArrayList<Object> parameters = new ArrayList<Object>();
		class Local{};
		String methodName=null;
		Requestor requestor= new Requestor();
		
		
		methodName=Local.class.getEnclosingMethod().getName();
		parameters.add(id);
		inv.setObjectId(this.getObjectID());
		inv.setIPAdress(this.getHost());
		inv.setPortNumber(this.getPort());
		inv.setOperationName(methodName);
		inv.setParameters(parameters);
		
		ter=requestor.invoke(inv);
		
		return (int)ter.getResult();
		
	}

	public void putMoney(int id, int valor) throws Throwable {
		Invocation inv=new Invocation();
		Termination ter= new Termination();
		ArrayList<Object> parameters = new ArrayList<Object>();
		class Local{};
		String methodName=null;
		Requestor requestor= new Requestor();
		
		
		methodName=Local.class.getEnclosingMethod().getName();
		parameters.add(id);
		parameters.add(valor);
		inv.setObjectId(this.getObjectID());
		inv.setIPAdress(this.getHost());
		inv.setPortNumber(this.getPort());
		inv.setOperationName(methodName);
		inv.setParameters(parameters);
		
		ter=requestor.invoke(inv);
		
		
	}

	public boolean hasMoney(int id, int valor) throws Throwable {
		Invocation inv=new Invocation();
		Termination ter= new Termination();
		ArrayList<Object> parameters = new ArrayList<Object>();
		class Local{};
		String methodName=null;
		Requestor requestor= new Requestor();
		
		
		methodName=Local.class.getEnclosingMethod().getName();
		parameters.add(id);
		parameters.add(valor);
		inv.setObjectId(this.getObjectID());
		inv.setIPAdress(this.getHost());
		inv.setPortNumber(this.getPort());
		inv.setOperationName(methodName);
		inv.setParameters(parameters);
		
		ter=requestor.invoke(inv);
		return (boolean) ter.getResult();
	}

	public void takeMoney(int id, int valor) throws Throwable, NoMoneyException {
		Invocation inv=new Invocation();
		Termination ter= new Termination();
		ArrayList<Object> parameters = new ArrayList<Object>();
		class Local{};
		String methodName=null;
		Requestor requestor= new Requestor();
		
		
		methodName=Local.class.getEnclosingMethod().getName();
		parameters.add(id);
		parameters.add(valor);
		inv.setObjectId(this.getObjectID());
		inv.setIPAdress(this.getHost());
		inv.setPortNumber(this.getPort());
		inv.setOperationName(methodName);
		inv.setParameters(parameters);
		
		ter=requestor.invoke(inv);
		
	}

	public void transferMoney(int id,int id2,int valor) throws Throwable, NoMoneyException,
			IOException {
		Invocation inv=new Invocation();
		Termination ter= new Termination();
		ArrayList<Object> parameters = new ArrayList<Object>();
		class Local{};
		String methodName=null;
		Requestor requestor= new Requestor();
		
		
		methodName=Local.class.getEnclosingMethod().getName();
		parameters.add(id);
		parameters.add(id2);
		parameters.add(valor);
		inv.setObjectId(this.getObjectID());
		inv.setIPAdress(this.getHost());
		inv.setPortNumber(this.getPort());
		inv.setOperationName(methodName);
		inv.setParameters(parameters);
		
		ter=requestor.invoke(inv);
		
	}

}
