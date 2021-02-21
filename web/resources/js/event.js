window.onload = function() {
	if(document.getElementById("mainLogin")) {
		const $login = document.getElementById("mainLogin");
		$login.onclick = function() {
			location.href = "/mg/member/login";
		}
		
	}
	
	if(document.getElementById("regist2")) {
		const $regist = document.getElementById("regist2");
		$regist.onclick = function() {
			location.href = "/mg/member/regist";
		}
		
	}
	
	if(document.getElementById("goMain")) {
		const $regist = document.getElementById("goMain");
		$regist.onclick = function() {
			location.href = "/mg";
		}
		
	}
	
	if(document.getElementById("login")) {
		const $regist = document.getElementById("login");
		$regist.onclick = function() {
			location.href = "/mg/member/login";
		}
		
	}
	
	if(document.getElementById("logout")) {
		const $logout = document.getElementById("logout");
		$logout.onclick = function() {
			location.href = "/mg/member/logout";
		}

	}
	
	if(document.getElementById("update")) {
		const $update = document.getElementById("update");
		$update.onclick = function() {
			location.href = "/mg/member/update";
		}
	}
	
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
	
	/*if(document.getElementById("customer")) {
		const $main = document.getElementById("customer");
		$regist.onclick = function() {
			location.href = "/mg/";
		}
		
	}*/
	
	if(document.getElementById("notice")) {
		const $notice = document.getElementById("notice");
		$notice.onclick = function() {
			location.href = "/mg/notice/list";
		}
		
	}
	
	/*if(document.getElementById("writeNotice")) {
		const $writeNotice = document.getElementById("writeNotice");
		$writeNotice.onclick = function() {
			location.href = "/mg/notice/write";
		}*/
		
	//}
	
	
	if(document.getElementById("writeReview")) {
		const $writeReview = document.getElementById("writeReview");
		$writeReview.onclick = function() {
			location.href = "/mg/review/insert";
		}
		
	}
	if(document.getElementById("search")) {
		const $search = document.getElementById("search");
		$search.onclick = function() {
			location.href = "/mg/review/search";
		}
		
	}
}