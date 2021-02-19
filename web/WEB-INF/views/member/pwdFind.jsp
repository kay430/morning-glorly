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
	href="/mg/resources/css/pwdFind.css">
	<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<div class="d1">
	
	<h2 align="center">비밀번호 찾기</h2>
	<form method="post" action="${ pageContext.servletContext.contextPath }/member/findpwd">
	<fieldset>
	<table>
		<tbody>
        	<tr class="userid" height="58" >
        		<th>
        		<div>아&nbsp;이&nbsp;디&nbsp;</div>
        		</th>
        		<td>
        			<div>
        				<input type="text" id="name" name="id" class="input" title="아이디">
        			</div>
        		</td>
			</tr>
        <tr class="userName"  height="58">
            <th>
            <div>&nbsp;&nbsp;이&nbsp;&nbsp;&nbsp;&nbsp;름&nbsp;&nbsp;	</div>
            </th>
            <td>
             <input name="name" type="text"  class="input" title="이름">
            </td>
            </tr>
            <tr class="pno" height="58">
            <th>
            <div>핸&nbsp;&nbsp;드&nbsp;&nbsp;폰&nbsp;&nbsp;번&nbsp;&nbsp;호	</div>
            </th>
            <td>
             <input name="phone" type="text"  class="input" title="핸드폰번호">
            </td>
            </tr>
             <tr class="email" height="58">
            <th>
            <div>&nbsp;&nbsp;이&nbsp;&nbsp;메&nbsp;&nbsp;일&nbsp;&nbsp;	</div>
            </th>
            <td>
             <input name="email" type="text"  class="input" title="이메일">
            </td>
            </tr>
            </tbody>
		</table>
		
		<br><br>
		
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" id="pwd">확인</button>
        </fieldset>
        </form>
        </div>
<!-- <body>
 <h2>비밀번호 찾기</h2>
    <label for="userId">아이디</label><br>
    <input type="text" id="userId" ><br>

    <label for="userName">이름</label><br>
    <input type="text" id="userName"><br>

    <label for="mPhone1">전화번호</label><br>
        <select>
            <option value="010">010</option>
            <option value="selected">직접 입력</option>
        </select>-

        
        <input name="Phone2" type="number">-
        <input name="Phone3" type="number"><br>
    
                
    <label for="email">이메일</label><br>
    <input type="text">
    <span>@</span>
    <input type="text">   
    <input type="text"><br>
 

    <p>
        가입시 입력하신 이메일 주소를 입력해 주세요.<br>
        이메일 주소로 임시 비밀번호를 발송합니다.
    </p>     -->
   <!--  <button type="submit" id="pwd">확인</button> -->
       <script>
       	$(document).ready(function() {
       		var id = document.getElementById('name');
       		console.log(id);
       		$("#pwd").click(function(){
       			
       			if(id.value==""){
       				alert('모든정보를 입력해주세요');
       			} else{
       			alert('임시비밀번호를 전달드렸습니다.');
       			}
       			
       			});
       		
       	});
       </script>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>