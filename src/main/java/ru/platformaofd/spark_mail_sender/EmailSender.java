package ru.platformaofd.spark_mail_sender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    public void sendEmail(String emailAddress, String emailSubject) {
        try {

            Properties props =  new Properties();
            props.put("mail.smtp.host", "mail.evotor.local");
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.ssl.trust", "mail.evotor.local");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.connectiontimeout", "10000");

            final String EmailUser = "evotor\\zeppelin";
            final String EmailPassword = "Bo9aihah7h";

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            EmailUser,EmailPassword);
                }
            });

            session.setDebug(true);
            InternetAddress fromAddress = new InternetAddress("zeppelin@platformaofd.ru");
            InternetAddress toAddress = new InternetAddress(emailAddress);
            String msgBody = "This email send from a Java program.";

            Message msg = new MimeMessage(session);
            msg.setFrom(fromAddress);
            msg.addRecipient(Message.RecipientType.TO,toAddress);
            msg.setSubject(emailSubject);
            msg.setText(msgBody);

            Transport transport = session.getTransport("smtp");
            transport.connect();
            transport.sendMessage(msg, msg.getAllRecipients());

        }
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
