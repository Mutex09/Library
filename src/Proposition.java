import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Proposition
{
    void makeProposition(String str1,String str2)
    {
        final Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(Proposition.class.getClassLoader().getResourceAsStream("Mail/mail.properties")));
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress("Myemail"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress("Andreymak99@yandex.ru"));
            message.setSubject(str1);
            message.setText(str2);
            Transport tr = mailSession.getTransport();
            tr.connect(null,"pxufgjzyzkjrszrh");
            tr.sendMessage(message,message.getAllRecipients());
            tr.close();
        } catch (MessagingException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
