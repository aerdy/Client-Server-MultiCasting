import java.net.*;
import java.io.*;

public class Mcreceive{
	public static final int MAX_LEN = 1024;
	public static final int MIN_PORT = 1024;
	public static final int MAX_PORT = 65535;
	
	public static void main(String [] args){

	InetAddress mcAddress = null;
	int mcPort = 0;
	int tt1=1;
	boolean done = false;

	if(args.length != 2){
	System.out.println("Usege : mcreceive <Multicast IP> <Multicast Port>");
	System.exit(1);
	}
	
	try{
	mcAddress = InetAddress.getByName(args[0]);
	}catch(UnknowHostException e){
	System.err.println(args[0]+"is not a valid IP Adress");
	System.exit(1);
	}

	if(!mcAddress.isMulticastAddress()){
	System.err.println(mcAddress.getHostAddress()+"is not multicast IP address");	
	System.exit(1);
	}

	try{
	mcPort = Integer.parseInt(args[1]);
	}catch(NumberFormatException nfe){
	System.out.println("Invalid port number " +args[1]);
	System.exit(1);
	}
	
	if((mcPort < MIN_PORT) || (mcPort > MAX_PORT)){

	}
}

}
