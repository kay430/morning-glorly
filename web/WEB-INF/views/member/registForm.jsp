<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Morning Glory</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/mg/resources/css/signup.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

    <div class="container">
            <h1 class="txt2"><strong>회원정보입력</strong></h1>
            <div class="txt1">* 필수입력항목</div>
            <div class="body_line"></div>
            <form id="joinForm" action="${ pageContext.servletContext.contextPath }/member/regist" method="post">
            <table boder="" cellspacing="1" class="signup_detail">
                <div>
                    <tr class="name">
                        <td class="signup_cate"><sup class="required">*</sup> 이름 </td>
                        <td class="signup_cate_detail"> <input type="text" maxlength="5" name="memberName" id="memberName" required>
                        <label id="nameresult"></label></td>
                    </tr>
                    
                    <tr class="id">
                        <td text-align="center" class="signup_cate"><sup class="required">*</sup> 아이디 </td>
                        <td class="signup_cate_detail">
                            <input type="text" maxlength="13" name="memberId" id="memberId" required>&nbsp;&nbsp;
                            <input type="button" value="중복확인" class="btn btn-or" id="duplicationCheck">
                        </td>
                    </tr>



                    <tr class="password">
                        <td class="signup_cate"><sup class="required">*</sup> 비밀번호 </td>
                        <td class="signup_cate_detail"> <input type="password" maxlength="13" name="memberPwd" id="memberPwd"> </td>
                    </tr>


                    <tr class="check_password">
                        <td class="signup_cate"><sup class="required">*</sup> 비밀번호 확인 </td>
                        <td class="signup_cate_detail"> <input type="password" maxlength="13" name="memberPwd2" id="memberPwd2">&nbsp;
                        <label id="pwdresult"></label></td>
                    </tr>



                    <tr class="gender">
                        <td class="signup_cate"><sup class="required">*</sup> 생일/성별 </td>
                        <td class="signup_cate_detail">
                            <input type="date" name="date" />
                            <input type="radio" name="gender" value="남자" checked> 남자
                            <input type="radio" name="gender" value="여자"> 여자
                        </td>
                    </tr>




                    <tr class="email">
                        <td class="signup_cate"><sup class="required">*</sup> 이메일 </td>
                        <td class="signup_cate_detail">
                            <input type="text" name="email01"> @ <input type="text" name="email02"> &nbsp;&nbsp;
                            <select class="email_sel">
                                <option> 선택 </option>
                                <option> naver.com </option>
                                <option> daum.net </option>
                                <option> google.com </option>
                            </select>&nbsp;&nbsp;
                            <input type="button" value="중복확인" class="btn">
                        </td>
                    </tr>




                    <tr class="postal_code">
                        <td class="signup_cate"><sup class="required">*</sup> 우편번호 </td>
                        <td class="signup_cate_detail">
                            <input type="text" name="zipCode" id="zipCode" readonly>&nbsp;&nbsp;
                            <input type="button" value="우편번호검색" class="btn btn-yg" id="searchZipCode">
                        </td>
                    </tr>
                    <tr class="address">
                        <td class="signup_cate"><sup class="required">*</sup> 집주소 </td>
                        <td class="signup_cate_detail">
                            <input type="text" name="address1" id="address1" readonly>
                        </td>
                    </tr>
                    <tr class="address_detail">
                        <td class="signup_cate"><sup class="required">*</sup> 상세주소 </td>
                        <td class="signup_cate_detail">
                            <input type="text" name="address2" id="address2">
                        </td>
                    </tr>



                    <tr class="phone1">
                        <td class="signup_cate"><sup class="required">*</sup> 휴대폰 </td>
                        <td class="signup_cate_detail">
                            <select name="phone01" class="phone_num_sel1">
                                <option>선택</option>
                                <option value="010"> 010 </option>
                                <option value="011"> 011 </option>
                                <option value="016"> 016 </option>
                                <option value="018"> 018 </option>
                            </select>
                            - <input name="phone02" type="text" size="6"> - <input name="phone03" type="text" size="6">
                        </td>
                    </tr>

                    <tr class="phone2">
                        <td class="signup_cate"> 전화번호 </td>
                        <td class="signup_cate_detail">
                            <select class="phone_num_sel2">
                                <option>선택</option>
                                <option> 02 </option>
                                <option> 031 </option>
                                <option> 032 </option>
                                <option> 033 </option>
                                <option> 041 </option>
                                <option> 042 </option>
                                <option> 043 </option>
                                <option> 051 </option>
                                <option> 052 </option>
                                <option> 053 </option>
                                <option> 054 </option>
                                <option> 055 </option>
                                <option> 061 </option>
                                <option> 062 </option>
                                <option> 063 </option>
                                <option> 064 </option>
                            </select>
                            - <input type="text" size="6"> - <input type="text" size="6">
                        </td>
                    </tr>
                </div>
            </table>

            <div class="body_line"></div>
            <br>
            <br>
            <div class="body_line"></div>

            <input type="submit" value="동의하고 가입완료" class="submit_btn btn-or" id="insert">
    </div>
    </form>
    <script>
        $(function() {
           
           $("#memberName").change(function() {
           
           var regExp = /[가-힣]/g;
           
           if(!regExp.test($(this).val())) {
              $("#nameresult").html("잘못입력").css("color", "red");
           } else {
              $("#nameresult").html("정상입력").css("color", "green");
           }
              
           });
           
           $("#memberPwd2").change(function() {
               if($("#memberPwd").val() !== $(this).val()) {
                  $("#pwdresult").html("비밀번호불일치").css("color", "red");
                  $("#memberPwd2").focus().css("background", "red");
               } else {
                  $("#pwdresult").html("비밀번호일치").css("color", "green");
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
           
/*            $("form").submit(function(event) {
              event.preventDefault();
           }); */
           
        });
    </script>

   <script
      src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
      const $searchZipCode = document.getElementById("searchZipCode");
      
      $searchZipCode.onclick = function() {
         
      new daum.Postcode({
         oncomplete : function(data) {
            console.log(data.zonecode);
            console.log(data.address);
            document.getElementById("zipCode").value = data.zonecode;
            document.getElementById("address1").value = data.address;
             document.getElementById("address2").focus();
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
         }
      }).open();
      }
   </script>
   </div>

   <jsp:include page="../common/footer.jsp"/> 
</body>
</html>