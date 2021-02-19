package com.jihunh.jsp.member.controller;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendupdatePwd {
   
   static final String user = "ohppajio@gmail.com"; //발신자의 이메일 아이디를 입력
   static final String password = "oh571364";         //발신자 이메일의 패스워드를 입력
   
   public static void getEmail(String emailAdress) {
      
      
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
      
      
      //3.4) Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다. 3.5) Transport 클래스를 사용하여 작성한 메세지를 전달한다.
      try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            //수신자메일주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAdress)); 

            // Subject
            message.setSubject("비밀번호 변경 "); //메일 제목을 입력

            // Text
            String massageText = "비밀번호 변경 재설정을 위해 아래 링크를 통해 접근해주세요 "
                  + "<br><br> "
                  + "링크 클릭 "
                  + "to reset your password. <br><br><br> 감사합니다.<br>우리가요팀";
            message.setText(massageText);    //메일 내용을 입력

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
      
   }
   

   
   
}

