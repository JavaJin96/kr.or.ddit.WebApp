<%@ page contentType="text/html; charset=utf-8"%>
<html>
<style type="text/css">
      table{
         background-color: yellow;
         border-collapse: collapse;
      }
      tr{
      	height : 50px;
      }
      td{
      	width : 100px;
      }
   </style>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
<body>
	<h4><%=request.getAttribute("now")%></h4>
	<form method="post" id="gugudanForm">
		<input type="number" name="minDan" min="2" max="9">
		<select name="maxDan">
		<%
			for(int i = 2; i <= 9; i++){
		%>		
			<option value="<%=i%>"><%=i%>단</option>
		<% 	} %>
		</select>
		<input type="submit" value="구구단">
	</form>
	<table border="1" id="gugudanTable">
	<%-- 	<%=request.getAttribute("gugudan")%> --%>
	</table>
<script>
	let gugudanTable = $("#gugudanTable");
	$("#gugudanForm").on("submit", function(event){
		 event.preventDefault();
		 let url = this.action;
	     let method = this.method;
	     let data = $(this).serialize();
	     
	     $.ajax({
			url : url,
			data : data,
			method : method,
			success : function(res) {
				// DOM Tree 구조로 selecting
				// DOM Tree 구조로 찾는건 많아지면 안된다. (속도가 느려짐)
				gugudanTable.html(res);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR);
				console.log(textStatus);
				console.log(errorThrown);
			},
			dataType : "html" //Accept : text/html -> ContentType : text/html
		})
	     
	})

</script>
</body>
</html>