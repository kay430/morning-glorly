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
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/mg/resources/css/signup.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/main-common.css">
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
                            <input type="button" value="중복확인" class="duplication_check_btn btn-or" id="duplicationCheck">
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
                            <select name="email03" class="email_sel">
                                <option> 선택 </option>
                                <option> naver.com </option>
                                <option> daum.net </option>
                                <option> google.com </option>
                            </select>&nbsp;&nbsp;
                            <input type="button" value="중복확인" class="duplication_check_btn">
                        </td>
                    </tr>




                    <tr class="postal_code">
                        <td class="signup_cate"><sup class="required">*</sup> 우편번호 </td>
                        <td class="signup_cate_detail">
                            <input type="text" name="zipCode" id="zipCode" readonly>&nbsp;&nbsp;
                            <input type="button" value="우편번호검색" class="postal_btn btn-yg" id="searchZipCode">
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
                            <select name="subPhone01" class="phone_num_sel2">
                                <option>선택</option>
                                <option value="02"> 02 </option>
                                <option value="031"> 031 </option>
                                <option value="032"> 032 </option>
                                <option value="033"> 033 </option>
                                <option value="041"> 041 </option>
                                <option value="042"> 042 </option>
                                <option value="043"> 043 </option>
                                <option value="051"> 051 </option>
                                <option value="052"> 052 </option>
                                <option value="053"> 053 </option>
                                <option value="054"> 054 </option>
                                <option value="055"> 055 </option>
                                <option value="061"> 061 </option>
                                <option value="062"> 062 </option>
                                <option value="063"> 063 </option>
                                <option value="064"> 064 </option>
                            </select>
                            - <input name="subPhone02" type="text" size="6"> - <input name="subPhone03" type="text" size="6">
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