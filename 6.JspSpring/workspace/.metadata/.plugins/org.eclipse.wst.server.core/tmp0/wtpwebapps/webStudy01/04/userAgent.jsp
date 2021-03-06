<%@page import="kr.or.ddit.enumpkg.BrowserInfo"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/userAgent.jsp</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
<script>
	<%
		/* 
		Enumeration<String> headerNames = request.getAttributeNames();
		
		1. request객체에 들어있는 모든 Header의 이름들을 Enumeration객체에 담고
		2. while문을 수행하면서 name과 value값을 뽑아서 td에 넣어준다.
		while(headerNames.hasMoreElements()){
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
		} */
		
		//String userAgent = request.getHeader("user-agent");
		
		//String res = BrowserInfo.findBrowser(userAgent);
		// 모든 문자를 대문자처리
		
		
		
		/* Map<String, String> browserInfo = new LinkedHashMap<>();
		browserInfo.put("EDG", "엣지");
		browserInfo.put("CHROME", "크롬");
		browserInfo.put("SAFARI", "사파리"); */
		
/* 		for(Entry<String,String> entry :browserInfo.entrySet()){
			String key = entry.getKey();
			if(userAgent.contains(key)){
				res = entry.getValue();
				break;
			}
		} */
		
		
		/* if(userAgent.contains("EDG")){
			res = "엣지";
		}else if(userAgent.contains("CHROME")){
			res = "크롬";						
		}else if(userAgent.contains("SAFARI")){
			res = "사파리";	
		} */
		
		//String message = String.format("당신의 브라우저는 %s 입니다.", res);
		
		
		
		
		/* 
		 	1. 비동기 요청 발생(/04/findBrowser)
			2. 응답 데이터 JSON 형식(browser 포르퍼티)
			3. 응답이 전송되면, alert 창 
		*/
	%>
	
	$(function(){
		$("#clickBtn").on("click", function(event){
			// 기존의 이벤트를 삭제하는 과정
			event.preventDefault();
			const PTRN = "당신의 브라우저는 %s 입니다.";
			$.ajax({
				url : "<%=request.getContextPath()%>/04/findBrowser",
				method : "get",
				success : function(res) {
					let message = PTRN.replace("%s", res.browser)
					alert(message);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(jqXHR);
					console.log(textStatus);
					console.log(errorThrown);
				},
				dataType : "JSON"
			})
			
			
		})
	})
	
	
	
</script>
</head>
<body>
<a href="#" id="clickBtn">클릭</a>
<!-- 
enum 문법 활용 추천
사용자의 브라우저 종류를 확인하고
"당신의 브라우저는 크롬[사파리, 엣지] 입니다."
와 같은 형태의 메시지를 alert 창으로 출력. 
-->
</body>
</html>