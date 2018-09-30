package ServicePart;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Service01 {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket server = serverSocket.accept();
		InputStream is = server.getInputStream();
		byte[] b=new byte[1024];
		
		int len = is.read(b);
		String msg = new String(b,0,len);
		System.out.println(msg);
		
		is.close();
		server.close();
	}

}
