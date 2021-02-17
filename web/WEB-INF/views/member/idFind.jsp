<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/customer_main.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/idFind.css">
	<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<div class="d1">
	
	<h2 align="center">아이디 찾기</h2>
	<fieldset>
	<table>
		<tbody>
        	<tr class="userName" height="58" >
        		<th>
        		<div>이&nbsp;&nbsp;&nbsp;름</div>
        		</th>
        		<td>
        			<div>
        				<input type="text" id="name" name="name" class="input" title="이름">
        			</div>
        		</td>
			</tr>
        <tr class="mPhone1">
            <th>
            <div>핸&nbsp;&nbsp;드&nbsp;&nbsp;폰&nbsp;&nbsp;번&nbsp;&nbsp;호	</div>
            </th>
            <td>
             <input name="Phone2" type="text" name="phonenumber" class="input" title="핸드폰번호">
            </td>
            </tbody>
		</table>
		
		<br><br>
		
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;<button type="submit" id="fid">아이디 찾기</button>
        </fieldset>
        </div>
        
           <script>
       	$(document).ready(function() {
       		var id = document.getElementById('name');
       		console.log(id);
       		$("#fid").click(function(){
       			
       			if(id.value==""){
       				alert('모든정보를 입력해주세요');
       			} else{
       			alert('당신의 아이디는  ooo입니다.');
       			}
       			
       			});
       		
       	});
       </script>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>