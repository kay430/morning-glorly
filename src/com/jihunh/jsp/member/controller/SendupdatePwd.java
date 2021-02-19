package com.jihunh.jsp.member.controller;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.jihunh.jsp.member.model.dto.MgDTO;

public class SendupdatePwd {
   
	   
//  static final String user = "ohppajio@gmail.com"; //발신자의 이메일 아이디를 입력
//  static final String password = "oh571364";         //발신자 이메일의 패스워드를 입력
	
	static final String user = "semiproject888@gmail.com";
	static final String password = "abcd1234!@";
  
   public static String getEmail(String emailAdress) {
      
      
      // Property에 SMTP 서버 정보를 설정
      Properties prop = new Properties();
      prop.put("mail.smtp.host", "smtp.gmail.com"); 
      prop.put("mail.smtp.port", 465); 
      prop.put("mail.smtp.auth", "true"); 
      prop.put("mail.smtp.ssl.enable", "true"); 
      prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      
      //SMTP 서버 정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스를 생성한다.
      Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(user, password);
            }
        });
      
      String uuid = null;
      //3.4) Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다. 3.5) Transport 클래스를 사용하여 작성한 메세지를 전달한다.
      try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            //수신자메일주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAdress)); 
            //임시비밀번호 소스코드
            
            
            for (int i = 0; i < 5; i++) {
                uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
                uuid = uuid.substring(0, 10); //uuid를 앞에서부터 10자리 잘라줌.
                System.out.println(i + ") " +uuid);
              };
             
            // Subject
            message.setSubject("비밀번호 변경 "); //메일 제목을 입력
            
            // Text
            String massageText = "변경된 임시비밀번호입니다  "
                  + "(to reset your password)." + uuid + "감사합니다. 아침밥은먹어야죠!";
            message.setText(massageText);    //메일 내용을 입력
            MgDTO updatePwd = new MgDTO();
            updatePwd.setPwd(uuid);
            
            System.out.println("set 된거"+uuid);
            // send the message
            Transport.send(message); ////전송
            System.out.println("message sent successfully...");
            
            
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
      return uuid;
   }
   

   
   
}

