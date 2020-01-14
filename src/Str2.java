import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Properties;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Str2
{
    public static void main(String[] args) throws IOException, MessagingException
    {
       final Properties properties = new Properties();
       properties.load(Objects.requireNonNull(Str2.class.getClassLoader().getResourceAsStream("mail.properties")));

       Session mailSession = Session.getDefaultInstance(properties);
       MimeMessage message = new MimeMessage(mailSession);
       message.setFrom(new InternetAddress("Myemail"));
       message.addRecipient(Message.RecipientType.TO,new InternetAddress("andreymak99@yandex.ru"));
       message.setSubject("Hello");
       message.setText("My test letter");

       Transport tr = mailSession.getTransport();
       tr.connect(null,"pxufgjzyzkjrszrh");
       tr.sendMessage(message,message.getAllRecipients());
       tr.close();



    }
}
