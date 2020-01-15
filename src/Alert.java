import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alert extends AbstractAlert
{
    void newBookAlert(String book)
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("INF\\user_inf.properties")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.matches("user=(.)*")) {
                    strLine = strLine.substring(strLine.lastIndexOf("=") + 1);
                    newBook(strLine,book);
                }
            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    void newDescriptionAlert(String book)
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("INF\\user_inf.properties")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.matches("user=(.)*")) {
                    strLine = strLine.substring(strLine.lastIndexOf("=") + 1);
                    description(strLine,book);
                }
            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
