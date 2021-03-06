<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>02/factorial.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>


</head>


      
<body>
<h4>팩토리얼 연산 수행</h4>
<form method="post" name="factorialForm">
   <input type="number" name="operand">
   <input type="text" name="param1">
   <select name="param2">
      <option>value1</option>
      <option>value2z</option>
   </select>
   <button type="submit"> = </button>
</form>
<!-- 선언부 기호(를 사용해서, 10! 연산의 결과를 브라우저에 랜더링. -->
<%
   Object data = request.getAttribute("result");
   long result = 0;
   
   if(data != null)
      result = (Long)data;
%>
<div id="resultArea">
<%= result %>
</div>
<script type="text/javascript">
$(function() {
	let resultArea = $("#resultArea");
	
   	$('[name=factorialForm]').on('submit', function(event) {
      event.preventDefault();
      let url = this.action;
      let method = this.method;
      let data = $(this).serialize();
      
      console.log(data);
      
      $.ajax({
         url : url,
         method : method,
         data : data,
         dataType : "json",
         success : function(resp) {
            console.log(resp)
            resultArea.html(resp.result);
         },
         error : function(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
         }

      });
      
      
      
      
   });
})
</script>
</body>
</html>