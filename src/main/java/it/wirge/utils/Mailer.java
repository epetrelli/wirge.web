package it.wirge.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mailer {
  public static void sendMessage(String sFrom, String sTo, String sSubject, String sBody){
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);

    try {
      Message msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(sFrom));
      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(sTo));
      msg.setSubject(sSubject);
      msg.setText(sBody);
      Transport.send(msg);

    } catch (AddressException e) {
      e.printStackTrace();
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
