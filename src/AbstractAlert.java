import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public abstract class AbstractAlert
{
   protected void description(String email, String book)
    {
        final Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(AbstractAlert.class.getClassLoader().getResourceAsStream("Mail/mail.properties")));
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress("Myemail"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
            message.setSubject("Новое описание книги");
            message.setText("Эй, у нас тут появилось новое описание этой книги: " + book + "\nЗаходи проверь, возможно захочешь себе такую.");
            Transport tr = mailSession.getTransport();
            tr.connect(null,"pxufgjzyzkjrszrh");
            tr.sendMessage(message,message.getAllRecipients());
            tr.close();
        } catch (MessagingException e)
        {
            System.out.println(e.getMessage());
        }
    }

    void newBook(String email, String book)
    {
        final Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(AbstractAlert.class.getClassLoader().getResourceAsStream("Mail/mail.properties")));
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress("Myemail"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
            message.setSubject("Новая книга");
            message.setText("Слушай, у нас тут появилась новая книга: " + book + "\nЗаходи проверь, возможно захочешь себе такую.");
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
