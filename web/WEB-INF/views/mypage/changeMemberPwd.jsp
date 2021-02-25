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
	href="/mg/resources/css/mymapge/changeMemberInfo.css">
</head>
<style>
#reconfirmPasswd { padding: 60px 60px 120px; font-size: 12px; font-family: dotum; }
#reconfirmPasswd h2 { text-align: center; font-size: 0; line-height: 0; }
#reconfirmPasswd .txt { margin-top: 15px; color: #666; font-size: 14px; line-height: 1.5; letter-spacing: -1px; text-align: center; }
#reconfirmPasswd .frm { margin-top: 40px; padding: 20px 0 40px 0; background: #fcfcfc; }
#reconfirmPasswd .frm ul { zoom: 1; width: 270px; margin: 0 auto; }
#reconfirmPasswd .frm ul:after { content: ''; clear: both; display: block; }
#reconfirmPasswd .frm li { float: left; width: 100%; position: relative; margin-top: 5px; padding-left: 95px; color: #777; font-size: 14px; line-height: 37px; font-weight: bold; text-align: left; }
#reconfirmPasswd .frm li strong { color: #555; }
#reconfirmPasswd .frm li label { position: relative; display: block; }
#reconfirmPasswd .frm li label span { position: absolute; top: 0; left: 5px; color: #dadada; }
#reconfirmPasswd .frm li .lab { position: absolute; top: 0; left: 0; }
#reconfirmPasswd .frm li .warn { display: none; position: absolute; top: 44px; left: 95px; color: #ff0000; font-size: 12px; font-weight: normal; line-height: 1.25; white-space: nowrap; }
#reconfirmPasswd .frm li .txt-input { width: 165px; height: 35px; line-height: 35px; padding-left: 10px; color: #727272; font-size: 14px; font-family: dotum; border: 1px solid #d6d6d6; background: #fff; }
#reconfirmPasswd .btns { margin-top: 40px; text-align: center; font-size: 0; line-height: 0; }
#reconfirmPasswd .btns a { display: inline-block; margin: 0 5px; }
</style>
<body>

	<jsp:include page="../common/header.jsp" />
	
	<hr />            <div id="subContent">
	
		<div id="reconfirmPasswd">
		    <div class="reconfirm">
		    <script src="/mg/resources/js/adminjihun.js"></script>
			<h2><img src="/mg/resources/image/member/pwdCheck3.png" alt="비밀번호 재확인" width="600px" height="300px" /></h2>
			<p class="txt">저희 쇼핑몰에서는 회원님의 소중한 개인정보를 안전하게 보호하고<br />개인정보 도용으로 인한 피해를 예방하기 위하여 비밀번호를 확인합니다.<br />비밀번호는 타인에게 노출되지 않도록 주의해주세요.</p>
			<form name="form_pw" id="form_pw" action="/shop/reconfirm_password.action.html" method="POST" autocomplete="off" onsubmit="return false;">
<input type="hidden" name="page_mode" value="PC">
<input type="hidden" name="hidden_login_id" value="kim112">
<input type="hidden" name="msecure_key"     value="">
<input type="hidden" name="formname"        value="form_pw" />
<input type="hidden" name="ssl"             value="" />
<input type="hidden" name="ssl2"            value="" />
<input type="hidden" name="sslid"           value="slimcook">
<input type="hidden" name="sslip"           value="www.slimcook.co.kr">
<input type="hidden" name="sendfunc"        value="">

			    <fieldset>
				<div class="frm">
				    <ul>
					<li>
					    <span class="lab">아이디</span>
					    <strong>${ sessionScope.loginMember.id }</strong>
					</li>
					<li>
					    <span class="lab">비밀번호</span>
					    <label><span>비밀번호 입력</span><input type="password" id="user_password" name="user_password" class="txt-input" onkeyup="javascript:check_key(event);"></label>
					</li>
				    </ul>
				</div><!-- .frm -->
				<div class="btns">
				    <a href="javascript:pw_check();" class="btn_default btn_color_point">확인</a>
				    <a href="/index.html" class="btn_default btn_color">취소</a>
				</div><!-- .btns -->
			    </fieldset>
			</form>		    </div><!-- .reconfirm -->
		</div><!-- #reconfirmPasswd -->



            </div><!-- #content -->

          </div><!-- #contentSub -->
	
	
	<div class="ud">
		<div class="img_area">
			<img src="image/Logo1.png">
		</div> 
        <h1 align="center">모닝글로리
            <strong>회원정보수정</strong>
        </h1>
       
        <hr class="hr">
		<br>
		<h2 align="center" class="update">* 필수입력항목</h2>
		<form id="updateForm" action="" method="post">
            <div id="personInfo">
			<table align="center" class="person-tb">
                <tbody>
				<tr>
					<td width="200px" class="red">* 아이디</td>
					<td><input type="text" maxlength="13" name="memberId" id="memberId" class="a" readonly value="${ sessionScope.loginMember.id }"></td>
					
				</tr>
				<tr>
					<td class="red">* 비밀번호</td>
					<td><input type="password" maxlength="13" name="memberPwd" id="memberPwd" class="a"></td>
					
				</tr>
				<tr>
					<td class="red">* 비밀번호 확인</td>
					<td><input type="password" maxlength="13" name="memberPwd2" class="a"></td>
				
				</tr>
				<tr>
					<td class="red">* 이름</td>
					<td><input type="text" maxlength="5" name="name"  class="a" value="${ sessionScope.loginMember.name }"></td>
				</tr>
				<tr>
					<td class="red1">연락처</td>
					<td><input type="tel" name="phone" class="a" value="${ sessionScope.loginMember.phone }"></td>
					
				</tr>
				<tr>
					<td class="red1">이메일</td>
					<td><input type="email" name="email" class="a" value="${ sessionScope.loginMember.email }"></td>
					
				</tr>
				<tr>
					<td class="red1"> 우편번호</td>
					<td><input type="text" name="zipCode" id="zipCode" class="a" >&nbsp;&nbsp;&nbsp;<input type="button" value="검색" class="btn-ygs" id="searchZipCode" class="a"></td>
					
				</tr>
				<tr>
					<td class="red1">주소</td>
					<td><input type="text" name="address1" id="address1"  class="a" ></td>
					
				</tr>
				<tr>
					<td class="red1">상세주소</td>
					<td><input type="text" name="address2" id="address2" class="a"></td>
					
				</tr>
            </tbody>
			</table>
        </div>
			<br>
			<div class="btns" align="center">
				<input type="submit" value="수정하기" class="btn-or" 
				onclick="${ pageContext.servletContext.contextPath }/change/memberInfo">
                <input type="reset" value="메인으로" class="btn-yg" id="goMain">
			</div>
		</form>
		
	</div>	<!-- 회원 정보 수정 영역 끝 -->
    
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		const $searchZipCode = document.getElementById("searchZipCode");
		
		$searchZipCode.onclick = function() {
			new daum.Postcode({
		        oncomplete: function(data) {
		            console.log(data.zonecode);
		            console.log(data.address);
		            
		            document.getElementById("zipCode").value = data.zonecode;
		            document.getElementById("address1").value = data.address;
		            document.getElementById("address2").focus();
		        }
		    }).open();
		}
	    
	</script>
	<script>
		var result = '${ sessionScope.loginMember.address }'.split('$');
		console.log(result);

		document.getElementById("zipCode").value = "[" + result[0] + "] ";
		document.getElementById("address1").value = result[1];
		document.getElementById("address2").value = result[2];
	</script>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>