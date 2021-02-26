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
#reconfirmPasswd .frm ul:after { content: ''; clear: both; display: block;}
#reconfirmPasswd .frm li { float: left; width: 100%; position: relative; margin-top: 5px; padding-left: 95px; color: #777; font-size: 14px; line-height: 37px; font-weight: bold; text-align: left; }
#reconfirmPasswd .frm li strong { color: #555; }
#reconfirmPasswd .frm li label { position: relative; display: block; }
#reconfirmPasswd .frm li label span { position: absolute; top: 0; left: 5px; color: #dadada; }
#reconfirmPasswd .frm li .lab { position: absolute; top: 0; left: 0; }
#reconfirmPasswd .frm li .warn { display: none; position: absolute; top: 44px; left: 95px; color: #ff0000; font-size: 12px; font-weight: normal; line-height: 1.25; white-space: nowrap; }
#reconfirmPasswd .frm li .txt-input { width: 135px; height: 35px; line-height: 35px; padding-left: 10px; color: #727272; font-size: 14px; font-family: dotum; border: 1px solid #d6d6d6; background: #fff; }
.btns { margin-top: 40px; text-align: center; font-size: 20px; line-height: 0; baackground-color: "red";}
.btns a { display: inline-block; margin: 0 5px; }
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

			    <fieldset>
				<div class="frm">
				    <ul>
					<li>
					    <span class="lab">아이디</span>
					    <strong>${ sessionScope.loginMember.id }</strong>
					</li>
					<li>
					    <span class="lab">기존 비번</span>
					    <label><input type="password" id="user_password1" name="user_password" class="txt-input" placeholder="기본 비번 입력"></label>
					</li>
					<li>
					    <span class="lab">변경 비번</span>
					    <label><input type="password" id="user_password2" name="user_password" class="txt-input" placeholder="변경할 비번 입력"></label>
					</li>
					<li>
					    <span class="lab">변경 비번확인</span>
					    <label><input type="password" id="user_password3" name="user_password" class="txt-input" placeholder="변경할 비번 확인"><label></label></label>
					</li>
				    </ul>
				    <script>
					    $("#user_password1").change(function() {
				    		if($("user_password1").val() == "") {
				    			alert("입력해");
				    			console.log($("user_password1").innerHTML)
				    		}
				    	});
				    
				    	$("#user_password3").change(function() {
				    		if($("#user_password2").val() !== $(this).val()) {
				    			alert("변경할 비밀번호가 일치하지 않습니다.");
				    			$("#reconfirmPasswd ul :nth-child(4) input").css("background", "red");
				    			$("#reconfirmPasswd ul :nth-child(4) label :nth-child(2)").html("[비번 확인 불일치]").css("color", "red");
				    		} else {
				    			$("#reconfirmPasswd ul :nth-child(4) input").css("background", "green");
				    			$("#reconfirmPasswd ul :nth-child(4) label :nth-child(2)").html("[비번 확인 일치]").css("color", "green");
				    		}
				    	});
				    </script>
				</div><!-- .frm -->
				<div class="btns">
				    <button id="enterButton" type="button">확인</button>
				    <a id="returnButton" class="btn_default btn_color">취소</a>
				</div><!-- .btns -->
			    </fieldset>
			</form>		    </div><!-- .reconfirm -->
		</div><!-- #reconfirmPasswd -->

		<script>
			$("#enterButton").click(function() {
				console.log("버튼");
				
 				$.ajax({
        			url: "${ pageContext.servletContext.contextPath }/change/memberPwd",
        			type: "post",
        			data: { pwd1 : $("#user_password1").val(),
        					pwd2 : $("#user_password2").val(),
        					pwd3 : $("#user_password3").val()
        			      },
        			success: function(data, textStatus, xhr) {
        				if(data == "성공") {
        					alert("비밀번호를 변경하였습니다.");
        					location.href = '${ pageContext.servletContext.contextPath }/mypage/main'
        				} else if(data == "빈값") {
        					alert("기존 비밀번호를 입력해주세요.");
        				} else {
        					alert("기존 비밀번호가 일치하지 않습니다.");
        				}
        				
        				
        			},
        			error: function(xhr, status, error) {
        				console.log(error);
        			}
        		});
			});
		</script>

	
	
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>