package kr.or.ddit.servlet03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

@WebServlet("/02/factorial.do")
public class FactorialServlet extends HttpServlet{
	
	
	// 클라이언트에게 UI를 제공하기 위한 doGet메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goPage = "/WEB-INF/views/factorial.jsp";
		
		req.getRequestDispatcher(goPage).forward(req, resp);
	}
	
	
	// JSP를 들러, requeset를 가지고 doPost로 왔다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int operand = 10;
		String inputNum = req.getParameter("operand");
		operand =  Integer.parseInt(inputNum);	
 		if(inputNum==null || inputNum.isEmpty() || !inputNum.matches("\\d+")){
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "메롱이다`");
			return;
		}; 
		
		/*if(inputNum!=null && !inputNum.isEmpty() && inputNum.matches("\\d+")){
			operand =  Integer.parseInt(inputNum);		
		}*/
		
		String accept = req.getHeader("Accept");
		long result = factorial(operand);
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("prop", "value");
		
		if(accept.contains("json")) {
			// Marshalling : 가지고 있는 data를 json형태로 변환하는 것
			String pattern = "\"%s\" : \"%s\",";
			StringBuffer json = new StringBuffer();
			json.append("{");
			for(Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				json.append(String.format(pattern, key, value));
			}
			int lastIdx = json.lastIndexOf(",");
			json.deleteCharAt(lastIdx);
			json.append("}");
			resp.setContentType("application/json; charset=utf-8");
			try(
			PrintWriter out = resp.getWriter();
				){	
			out.print(json);
			}
		}else {
			req.setAttribute("result", result);
			String goPage = "/WEB-INF/views/factorial.jsp";
			req.getRequestDispatcher(goPage).forward(req, resp);			
		}
		
		
				
	
	
	}
	
	public long factorial(long num){
		if(num < 0) throw new IllegalArgumentException("움수 피연산자는 처리 불가");
		else if(num == 1)
			return 1;
		return num * factorial (num -1 );	
	}
	
	
	
}
