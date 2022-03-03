<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>

<script>
$(function(){
/*     // bind 'myForm' and provide a simple callback function 
    $('#myForm').ajaxForm(function() { 
        alert("Thank you for your comment!"); 
    });  */
    
    
    var option = {
    	    dataType : 'json', //JSON형태로 전달도 가능합니다.
    	    url: "/02/ajaxform.do",
    	    success: function(res){
    	        alert(res.msg); //res Object안에 msg에는 결과 메시지가 담겨있습니다.
    	    },
    	    error: function(res){
    	        alert("에러가 발생했습니다.")
    	    }
    	}

    	$('#myForm').submit(function() { //submit이 발생하면
    	    $(this).ajaxSubmit(option); //옵션값대로 ajax비동기 동작을 시키고
    	    return false; //기본 동작인 submit의 동작을 막아 페이지 reload를 막는다.
    	});
	
})
</script>

</head>
<body>
	<h4>ajaxFormTest</h4>
	<form id="myForm"  method="post"> 
    	Name: <input type="text" name="name" /> 
    	Comment: <textarea name="comment"></textarea> 
    	<input type="submit" value="Submit Comment" /> 
	</form>
	
	
	
	
</body>
</html>