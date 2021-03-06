package kr.or.ddit.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// CoC : Convention over Configuration : 명시적이 없으면 기존의 관행을 따라가는 패러다임
/**
 * 서블릿
 *  : 자바를 기반으로 웹상의 요청을 처리할 수 있는 객체에 대한 조건의 집합 
 *  동적 요청 분석 + 동적 응답 생성 (서블릿의 역할)
 *  
 *  서블릿 개발 단계
 *  1. HttpServlet 을 상복받은 클래스 정의
 *  2. 컴파일 -> context 의 classpath (WEB-INF/classes) 에 배포.
 *  3. 서블릿 컨테이너에 등록
 *  	1) web.xml(배포 서술자 사용/deployment descripot) : servlet 2.5 까지
 *  	   servlet -> servlet-name, servlet-class
 *  	2) @WebServlet(name...) : servlet 3.0 부터
 *  4. 웹상의 요청을 받기 위한 매핑 정보 설정
 *  	1) web.xml(	배포 서술자 사용/deployment descripot)
 *  	   servlet -> servlet-mapping -> servlet-name, url-pattern
 *  	2) @WebServlet(value, urlPatterns...)
 *  5. servlet container 재구동
 *  
 *  servlet container ? 서블릿의 라이프 사이클에 대한 관리자.
 *  
 *  callback $("btn).on("click, function(event){alert});
 *  	: 특정 조건(event) 이 발생했을때 시스템 내부적으로 호출되는 구조.
 *  
 *  서블릿에 대해 정의할 수 있는 callback 메소드 종류
 *  	1) lifecycle callback(1) : init, destroy
 *  	2) request callback(n) : service, doXXX
 *  
 *  
 *  
 *    (spec : 명세)
 *
 */

@WebServlet("/desc")
public class DescriptionServlet extends HttpServlet{
	
	
	public DescriptionServlet() {
		System.out.printf("%s 객체 생성을 위한 생성자 호출\n", this.getClass().getName());
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.printf("%s 객체 초기화완료 \n", this.getClass().getName());
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service 호출");
		super.service(arg0, arg1); // request method 에 따라 do 계열의 콜백을 호출하는 역할.
		System.out.println("service 실행종료");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 호출");
		//MIME(Multipurposed Internet Mail Extension)
		// main_type / sub_type
		String mime = "text/html; charset=utf-8";
		//resp.setCharacterEncoding("utf-8"); // 생략이 정말로 가능한 것인가? ****** 생략가능
		resp.setContentType(mime);
		
		String ip = req.getRemoteAddr();
		StringBuffer html = new StringBuffer();
		html.append("<html>                           \n");
		html.append("<body>                           \n");
		html.append(String.format("<h4>클라이언트 ip address : %s </h4>\n", ip));
		html.append("</body>                          \n");
		html.append("</html>                          \n");
		
		PrintWriter out = resp.getWriter();
		out.println(html);
		out.close();
		
	}
	
	@Override
	public void destroy() {
	System.out.printf("%s 객체 소멸 \n", this.getClass().getName());
	
	}


	
}
