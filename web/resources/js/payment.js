
  app.use(bodyParser.json());
  ...
  // "/payments/complete"에 대한 POST 요청을 처리
  app.post("/payments/complete", async (req, res) => {
    try {
      const { imp_uid, merchant_uid } = req.body; // req의 body에서 imp_uid, merchant_uid 추출
      
      // 액세스 토큰(access token) 발급 받기
      const getToken = await axios({
        url: "https://api.iamport.kr/users/getToken",
        method: "post", // POST method
        headers: { "Content-Type": "application/json" }, // "Content-Type": "application/json"
        data: {
          imp_key: "imp_apikey", // REST API키
          imp_secret: "ekKoeW8RyKuT0zgaZsUtXXTLQ4AhPFW3ZGseDA6bkA5lamv9OqDMnxyeB9wqOsuO9W3Mx9YSJ4dTqJ3f" // REST API Secret
        }
      });
      const { access_token } = getToken.data.response; // 인증 토큰
      
      // imp_uid로 아임포트 서버에서 결제 정보 조회
      const getPaymentData = await axios({
        url: `https://api.iamport.kr/payments/${imp_uid}`, // imp_uid 전달
        method: "get", // GET method
        headers: { "Authorization": access_token } // 인증 토큰 Authorization header에 추가
      });
      const paymentData = getPaymentData.data.response; // 조회한 결제 정보
      
      // DB에서 결제되어야 하는 금액 조회
      const order = await Orders.findById(paymentData.merchant_uid);
      const amountToBePaid = order.amount; // 결제 되어야 하는 금액
      
      // 결제 검증하기
      const { amount, status } = paymentData;
      if (amount === amountToBePaid) { // 결제 금액 일치. 결제 된 금액 === 결제 되어야 하는 금액
        await Orders.findByIdAndUpdate(merchant_uid, { $set: paymentData }); // DB에 결제 정보 저장
        
        switch (status) {
          case "paid": // 결제 완료
            res.send({ status: "success", message: "일반 결제 성공" });
            break;
        }
      } else { // 결제 금액 불일치. 위/변조 된 결제
        throw { status: "forgery", message: "위조된 결제시도" };
      }
    } catch (e) {
      res.status(400).send(e);
    }
  });