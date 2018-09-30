package ClientPart;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client2 {
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("127.0.0.1",9999);
		
		//妈蛋，相对路径很坑
//		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("../testFile.txt"));

		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("F:/eclipseworkespace/NetCoding/src/testFile.txt"));
		
		OutputStream os = socket.getOutputStream();
		BufferedOutputStream bos =new BufferedOutputStream(os);
		
		byte[] b=new byte[1024*8];
		int len;
		while((len=bis.read(b))!=-1){
			bos.write(b,0,len);
			bos.flush();
		}
		
		socket.shutdownOutput();//通知服务器写完了
		System.out.println("客户端发送数据完成");
		
		InputStream in = socket.getInputStream();//解析服务器的回写
		in.read();
		System.out.println(in);
		in.close();
		
		
		bis.close();
		socket.close();
		
		
	}
}
