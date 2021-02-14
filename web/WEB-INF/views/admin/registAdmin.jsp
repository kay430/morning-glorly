<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Morning Glory Admin</title>
        <link href="/mg/resources/css/regist.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="card shadow-lg border-0 rounded-lg mt-5">
                        <div class="card-header">
                            <h3 class="text-center font-weight-light my-4">Create Account</h3>
                        </div>
                        <div class="card-body">
                            <form id="joinAdForm" action="${ pageContext.servletContext.contextPath }/admin/regist" method="post">
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="small mb-1" for="inputFirstName">이름 <label id="nameresult"></label></label>
                                            <input class="form-control py-4" type="text"
                                                name="adminName" id="adminName" required
                                                placeholder="이름을 입력하세요" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="small mb-1" for="inputLastName">아이디<label id="overlapIdResult"></label> <button type="button" id="overlapId">중복확인</button></label>
                                            <input class="form-control py-4" type="text"
                                               name="adminId" id="adminId" required
                                                placeholder="아이디를 입력하세요" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="small mb-1" for="inputPassword">비밀번호</label>
                                            <input class="form-control py-4" type="password"
                                                 name="adminPwd" id="adminPwd" required
                                                placeholder="비밀번호를 입력하세요" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="small mb-1" for="inputConfirmPassword">비밀번호 확인 <label id="pwdresult"></label></label>
                                            <input class="form-control py-4" type="password"
                                            name="adminPwd2" id="adminPwd2" required
                                                placeholder="비밀번호를 확인해주세요" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="small mb-1" for="inputFirstName">생년월일</label>
                                            <input class="form-control py-4" name="adminPno" type="text" placeholder="ex) 930101" required />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="small mb-1" for="inputLastName">이메일</label>
                                            <input class="form-control py-4" name="email" type="email" placeholder="이메일을 입력해주세요" required />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mt-4 mb-0"><a class="btn btn-primary btn-block"><input type="submit" value="가입하기" class="btn btn-or"></a></div>
                            </form>
                                <script>
                                	$("#overlapId").click(function() {
                                			const idOverlap = document.getElementById("adminId").value;
                                		
                                		$.ajax({
                                			url: "${ pageContext.servletContext.contextPath }/admin/regist/overlapid",
                                			type: "post",
                                			data: { idOverlap : idOverlap },
                                			success: function(data, textStatus, xhr) {
                                				if(data == "can") {
                                					alert("사용할수 있습니다.");
                                					/* console.log(idOverlap); */
                                                    $("#adminId").css("background", "#7fd113");
                                                    $("#overlapIdResult").html("[사용가능]").css("color", "green");
                                				} else if(data == "not") {
                                					alert("아이디를 입력해주세요.");
                                					 $("#adminId").focus().css("background", "#b82909");
                                					 $("#overlapIdResult").html("[사용불가]").css("color", "red");
                                				} else {
                                					alert("중복된 아이디가 존재합니다.");
                                					console.log("사용 불가");
                                					 $("#adminId").focus().css("background", "#b82909");
                                					 $("#overlapIdResult").html("[사용불가]").css("color", "red");
                                				}
                                			},
                                			error: function(xhr, status, error) {
                                				console.log(error);
                                			}
                                		});
                                	});
                                	
                                	$("#joinAdForm").submit(function() {
                                		var pwd1 = document.getElementById("adminPwd").value;
                                		var pwd2 = document.getElementById("adminPwd2").value;
                                		console.log(pwd1);
                                		console.log(pwd2);
                                		
                                		if(pwd1 == pwd2) {
                                			alert("회원 가입을 축하드립니다.");
                                			console.log("가입 완료");
                                			return true;
                                		} else {
                                			alert("비밀번호가 일치하지 않습니다.");
                                			console.log("입구컷");
                                			return false;
                                		}
                                		console.log("끝");
                                	});
                                </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(function() {
                
                $("#adminName").change(function() {
                
                var regExp = /[가-힣]/g;
                
                if(!regExp.test($(this).val())) {
                    $("#nameresult").html("[잘못입력]").css("color", "red");
                } else {
                    $("#nameresult").html("[정상입력]").css("color", "green");
                }
                    
                });
                
                $("#adminPwd2").change(function() {
                    if($("#adminPwd").val() !== $(this).val()) {
                        $("#pwdresult").html("[비밀번호불일치]").css("color", "red");
                        $("#adminPwd2").focus().css("background", "#b82909");
                    } else {
                        $("#pwdresult").html("[비밀번호일치]").css("color", "green");
                        $("#adminPwd2").css("background", "#7fd113");
                    }
                    
                });
                
                //focusin, focusout : 버블링 발생 함
                //focus, blur : 버블링 발생 안함 -> focusin과 focusout처럼 사용하자
                $("#name").focus(function() {
                    console.log("focus 이벤트 가동");
                }).focusin(function() {
                    console.log("focusin 이벤트 가동");
                }).focusout(function() {
                    console.log("focusout 이벤트 가동");
                }).blur(function() {
                    console.log("blur 이벤트 가동");
                }).change(function() {
                    console.log("change 이벤트 가동");
                }).select(function() {
                    console.log("select 이벤트 가동");
                })
                
    /*         	$("form").submit(function(event) {
                    event.preventDefault();
                }); */
                
            });
        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="/mg/resources/admin/jquery/jquery.min.js"></script>
  <script src="/mg/resources/admin/bootstrap/js/bootstrap.min.js"></script>
  <!--BACKSTRETCH-->
  <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
  <script type="text/javascript" src="/mg/resources/admin/jquery.backstretch.min.js"></script>
  <script>
    $.backstretch("/mg/resources/image/admin/login-bg.jpg", {
      speed: 500
    });
  </script>
</body>

</html>