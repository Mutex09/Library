import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login extends Md5Hex
{
    private static int marker = 0;


    public static boolean login(String login, String password)
    {
        String pswdHex = md5Hex(password);
        search(login,pswdHex);
        return marker == 1;
    }

    private static void search(String login, String pswd)
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("INF\\user_inf.properties")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if(strLine.matches("(.)*"+ login + "=" + pswd + "=(.)*")) {
                    marker++;
                }

            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
