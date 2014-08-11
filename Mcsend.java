import java.net.*;
import java.io.*;

public class Mcsend{
	public static final int MIN_PORT = 1024;
	public static final int MAX_PORT = 65535;
	
	public static void main(String []args){
	InetAddress mcAddress = null;
	int mcPort = 0;
	int tt1 = 1;
	BufferedReader stdin;
	String sendString;
	byte[] sendBytes;

	if(args.length != 2){
	System.out.println("Usege : mcsend <Multicast IP> <Multicast Port>");
	System.exit(1);
	}

	try{
	mcAddress = InetAddress.getByName(args[0]);
	}catch(UnknownHostException e){
	System.err.println(args[0]+"is not a valid IP Address");
	}
	
	if(! mcAddress.isMulticastAddress()){
	System.err.println(mcAddress.getHostAddress()+"is not multicast IP address");
	System.exit(1);
	}

	try{
	mcPort = Integer.parseInt(args[1]);
	}catch(NumberFormatException nfe){
	System.err.println("Invalid port number ("+args[1]+")");
	System.exit(1);
	}
	
	if((mcPort<MIN_PORT) || (mcPort > MAX_PORT)){
	System.out.println("Invalide port number " + mcPort);
	System.out.println("Port should be in range "+MIN_PORT + "to"+MAX_PORT);
	System.exit(1);
	}
		
	try{
	MulticastSocket sock = new MulticastSocket();
	
	sock.setTimeToLive (tt1);
	stdin = new BufferedReader (new InputStreamReader (System.in));

	System.out.println("Begin typing (return to send , ctrl-C to quit):");
	
	while((sendString = stdin.readLine()) !=null ){
	sendBytes = sendString.getBytes();
	
	DatagramPacket packet = new DatagramPacket (sendBytes,sendBytes.length,mcAddress,mcPort);
	sock.send(packet);
	}
	sock.close();
	}catch(IOException e){
	System.err.println(e.toString());
	System.exit(1);
	}

	}


}
