window.onload = function() {
	if(document.getElementById("insertAdmin")) {
		const $insertAdmin = document.getElementById("insertAdmin");
		$insertAdmin.onclick = function() {
			location.href = "/mg/admin/regist";
		}
	}
	
	if(document.getElementById("logoutAdmin")) {
		const $logout = document.getElementById("logoutAdmin");
		$logout.onclick = function() {
			location.href = "/mg/admin/logout";
		}

	}
	
	if(document.getElementById("adminNotice")) {
		const $logout = document.getElementById("adminNotice");
		$logout.onclick = function() {
			location.href = "/mg/admin/notice";
		}

	}
	
	if(document.getElementById("writeNotice")) {
		const $writeNotice = document.getElementById("writeNotice");
		$writeNotice.onclick = function() {
			location.href = "/mg/admin/notice/insert";
		}
	}
	
	if(document.getElementById("writeAnswer")) {
		const $writeNotice = document.getElementById("writeAnswer");
		$writeNotice.onclick = function() {
			location.href = "/mg/admin/answer/insert";
		}
	}

	if(document.getElementById("sweetHome")) {
		const $writeNotice = document.getElementById("sweetHome");
		$writeNotice.onclick = function() {
			location.href = "/mg/admin/mainIndex";
		}
	}
	
	if(document.getElementById("adminTransit")) {
		const $logout = document.getElementById("adminTransit");
		$logout.onclick = function() {
			location.href = "/mg/admin/transit";
		}
		
	}
	if(document.getElementById("sweetHome2")) {
		const $writeNotice = document.getElementById("sweetHome2");
		$writeNotice.onclick = function() {
			location.href = "/mg/admin/mainIndex";
		}
	}
	
	if(document.getElementById("answer")) {
		const $answer = document.getElementById("answer");
		$answer.onclick = function() {
			location.href = "/mg/admin/answer";
		}
	}
	
	if(document.getElementById("review")) {
		const $review = document.getElementById("review");
		$review.onclick = function() {
			location.href = "/mg/admin/review";
		}
	}
	
	if(document.getElementById("generalQna")) {
		const $generalQna = document.getElementById("generalQna");
		$generalQna.onclick = function() {
			location.href = "/mg/admin/generalQna";
		}
	}
	
	if(document.getElementById("test")) {
		const $writeNotice = document.getElementById("test");
		$writeNotice.onclick = function() {
			location.href = "/mg/admin/test";
		}
	}
	
	if(document.getElementById("registMd")) {
		const $registMd = document.getElementById("registMd");
		$registMd.onclick = function() {
			location.href = "/mg/admin/registProduct";
		}
	}
	
	if(document.getElementById("notice")) {
		const $notice = document.getElementById("notice");
		$notice.onclick = function() {
			location.href = "/mg/notice/list";
		}
		
	}
	
	/* 02/21(일) 한지훈 회원관리부터 작성 */

	if(document.getElementById("adminMemberList")) {
		const $adminMemberList = document.getElementById("adminMemberList");
		$adminMemberList.onclick = function() {
			location.href = "/mg/admin/member/manage";
			console.log("왜 안되냐 ")
		}
	}
	
	if(document.getElementById("adminMemberAdList")) {
		const $adminMemberAdList = document.getElementById("adminMemberAdList");
		$adminMemberAdList.onclick = function() {
			location.href = "/mg/admin/member/manageAd";
			console.log("왜 안되냐 ")
		}
	}
	
	console.log("숨김완료");
	console.log('${ pageNumNo }');
	$("#mgBlackFinish").css("display","none");
	
	
}

/*$("#modifyButton").click(function() {
	$("#modifyButton").css("display","none");
	$("#mgBlackFinish").css("display","block");
	$("#mgBlackReason").attr('readonly', false);
	alert("변경을 진행합니다");
	
	$("#finallyFinish").click(function() {
		
		if(confirm("블랙리스트 변경을 완료하시겠습니까?")) {
			const reason = document.getElementById("mgBlackReason").value;
			const status = document.getElementById("ajaxStatus").value;
			const pageNo = '${ pageNumNo }';
			const loginNo = '${ sessionScope.loginMember.no }';
			
			$.ajax({
				url: "${ pageContext.servletContext.contextPath }/admin/member/manage/updateBlackList",
				type: "post",
				data: {reason : reason, status : status, pageNo : pageNo, loginNo : loginNo },
				success: function(data, textStatus, xhr) {
					document.getElementById("mgBlackReason").innerHTML = data;
		 			$("#mgBlackFinish").css("display", "none");
					$("#mgBlackReason").attr('readonly', true);
					$("#modifyButton").css("display", "block"); 
					console.log("변경 완료");
					console.log(data);
					location.href = "${ pageContext.servletContext.contextPath }/admin/member/manage/detail?no=" + pageNo;
				},
				error: function(xhr, status, error) {
					console.log(error);
					console.log("에러에러에러");
				}
			});
			
			
			
			alert("변경 완료");
		} else {
			alert("변경 취소");
		}
		
	});
});*/
	