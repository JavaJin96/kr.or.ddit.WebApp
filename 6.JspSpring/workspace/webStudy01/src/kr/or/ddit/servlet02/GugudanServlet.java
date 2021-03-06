package kr.or.ddit.servlet02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *	1. /02/gugudan.do 요청이 발생하면,
 *	2. 2단부터 9단까지 승수는(1~9까지)
 *	3. table 태그 UI
 *	4. 한단이 하나의 행을 구성함.
 *	5. 오늘, 현재 시각이 h4 태그를 이용한 타이틀로 출력됨.
 *	6. 요청은 get 방식으로 발생함.
 */

@WebServlet("/02/gugudan.do")
public class GugudanServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		StringBuffer html = new StringBuffer();
		html.append("<html>\n");
		html.append("<style>\n");
		html.append("table{\n");
		html.append("border : 1px solid white border-collapse:collapse;\n");
		html.append("background : black;\n");
		
		
		
		html.append("color : white;\n");
		html.append("}\n");
		
		html.append("td{ width : 100px;}");
		
		html.append("h4{\n");
		html.append("background : pink;\n");
		html.append("}\n");
		
		Calendar now = Calendar.getInstance();
		
		html.append("</style>\n");
		html.append("<body>\n");
		html.append(String.format("<h4> 현재시각 : %tc </h4>\n", now));
		html.append("<table border='1'>");
		html.append("<tr><td>단</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td>");
		for(int i = 2; i <= 9; i ++) {
			html.append(String.format("<tr><td> %d단 </td>", i));
			for(int j = 1; j <= 9; j ++) {
				html.append(String.format("<td> %d </td> ", 
						i*j));				
			}
			html.append("</tr>");
		}
		
		html.append("</table>");
		html.append("</body></table>");
		
		PrintWriter out = resp.getWriter();
		out.print(html);
		out.close();
	}
	
}
