//<script>
///* 							window.onload = function() {
//												 console.log("숨김완료");
//												 console.log('${ pageNumNo }');
//												 $("#mgBlackFinish").css("display","none");
//
//												 } */
//
//$("#modifyButton")
//.click(
//		function() {
//			$(
//					"#modifyButton")
//			.css(
//					"display",
//					"none");
//			$(
//					"#mgBlackFinish")
//			.css(
//					"display",
//					"block");
//			$(
//					"#mgBlackReason")
//			.attr(
//					'readonly',
//					false);
//			alert("변경을 진행합니다");
//
//			$(
//					"#finallyFinish")
//			.click(
//					function() {
//
//						if (confirm("블랙리스트 변경을 완료하시겠습니까?")) {
//							const reason = document
//									.getElementById("mgBlackReason").value;
//							const status = document
//									.getElementById("ajaxStatus").value;
//							const pageNo = '${ pageNumNo }';
//							const loginNo = '${ sessionScope.loginMember.no }';
//
//							$
//							.ajax({
//								url : "${ pageContext.servletContext.contextPath }/admin/member/manage/updateBlackList",
//								type : "post",
//								data : {
//								reason : reason,
//								status : status,
//								pageNo : pageNo,
//								loginNo : loginNo
//							},
//								success : function(
//										data,
//										textStatus,
//										xhr) {
//								document
//								.getElementById("mgBlackReason").innerHTML = data;
//								/* 			$("#mgBlackFinish").css("display", "none");
//																														$("#mgBlackReason").attr('readonly', true);
//																														$("#modifyButton").css("display", "block"); */
//								console
//								.log("변경 완료");
//								console
//								.log(data);
//								location.href = "${ pageContext.servletContext.contextPath }/admin/member/manage/detail?no="
//										+ pageNo;
//							},
//								error : function(
//										xhr,
//										status,
//										error) {
//								console
//								.log(error);
//								console
//								.log("에러에러에러");
//							}
//							});
//
//							alert("변경 완료");
//						} else {
//							alert("변경 취소");
//						}
//
//					});
//		});
//</script>