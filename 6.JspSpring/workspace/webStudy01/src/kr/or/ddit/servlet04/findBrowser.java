package kr.or.ddit.servlet04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.BrowserInfo;


@WebServlet("/04/findBrowser")
public class findBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agent = request.getHeader("user-agent");
		
		String res = BrowserInfo.findBrowser(agent);
		
		
		// 내 원본 코드
		//String message = String.format("당신의 브라우저는 %s 입니다.", res);
		//StringBuffer code = new StringBuffer();
		//code.append(String.format("{\"%s\" : \"%s\" }", "sw", message));
		
		
		Map<String, Object> result = Collections.singletonMap("browser", res);
		// Marshalling
				// new Gson().toJSON();
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json; charset=utf-8");		
		try(
			PrintWriter out = response.getWriter();
				){
			mapper.writeValue(out, result);
		}
		
		
		
		
		
		//out.print(code);
		
		// Map<String, Object> result = Collections.singletonMap("browser", res);
		
		
		
		
		
		
		
	}

}
