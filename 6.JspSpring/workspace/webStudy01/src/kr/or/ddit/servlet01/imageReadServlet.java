package kr.or.ddit.servlet01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageRead.do")
public class imageReadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpeg; charset=utf-8");
		String imagePath ="/kr/or/ddit/images/Penguins.jpg";
		InputStream is = null;
		OutputStream os = null;
		try {
		
		is = imageReadServlet.class.getResourceAsStream(imagePath);
		byte[] buffer = new byte[1024];
		
		os = resp.getOutputStream();
		
		// EOF : -1 (End of File 파일의 끝가지 작업을 계속 해야함)
		int length = -1;
		while((length = is.read(buffer)) != -1) {
			os.write(buffer, 0, length);
			}
		}finally {
			if(is != null)is.close();
			if(os != null)os.close();			
		}
		
	}
	
}
