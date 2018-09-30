package ServicePart;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Service2 {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(9999);
		
		while(true){
			Socket accept = serverSocket.accept();
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
						
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.file"));
						
						byte[] b=new byte[1024*8];
						int len;
						while((len=bis.read(b))!=-1){
							bos.write(b,0,len);
						}
						
						bos.close();
						bis.close();
						accept.close();
						System.out.println("文件上传成功");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
		}
		
		
	}

}
