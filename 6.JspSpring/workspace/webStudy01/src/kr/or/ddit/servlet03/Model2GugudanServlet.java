package kr.or.ddit.servlet03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/model2/gugudan.do")
public class Model2GugudanServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Calendar now = Calendar.getInstance();
		
		resp.setContentType("text/html; charset=utf-8");
		StringBuffer html = new StringBuffer();

		for(int i = 2; i <= 9; i ++) {
			html.append(String.format("<tr><td> %d단 </td>", i));
			for(int j = 1; j <= 9; j ++) {
				html.append(String.format("<td> %d %s %d %s %d </td> ", 
						i,"X",j,"=",i*j));				
			}
			html.append("</tr>\n");
		}
		
					
		req.setAttribute("now", String.format("%tc", now));
		req.setAttribute("gugudan", html);
		String goPage = "/WEB-INF/views/gugudan.jsp";
		req.getRequestDispatcher(goPage).forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String minStr = req.getParameter("minDan");
		String maxStr = req.getParameter("maxDan");
		
		if(minStr == null || maxStr == null || !minStr.matches("[2-9]") || !maxStr.matches("[2-9]")) {
			resp.sendError(400);
			return;
		}
		
		int minDan = Integer.parseInt(minStr);
		int maxDan = Integer.parseInt(maxStr);
		resp.setContentType("text/html; charset=utf-8");
		StringBuffer html = new StringBuffer();

		for(int i = minDan; i <= maxDan; i ++) {
			html.append(String.format("<tr><td> %d단 </td>", i));
			for(int j = 1; j <= 9; j ++) {
				html.append(String.format("<td> %d %s %d %s %d </td> ", 
						i,"X",j,"=",i*j));				
			}
			html.append("</tr>\n");
		}
		
		try (
			PrintWriter out = resp.getWriter();
				)			
		{
			out.print(html);
		}
	}
	
	
}
