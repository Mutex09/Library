import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Check
{
    public boolean checkRights(String login)
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("INF\\user_inf.properties")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if(strLine.matches("admin="+login+"=(.)*")) {
                    return true;
                }
            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean checkLogin(String login)
    {
        if (login.equals("")) {
            return false;
        }
        else {

            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("INF\\user_inf.properties")))) {
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    if (strLine.matches("(.)*=" + login + "=(.)*")) {
                        return false;
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
    }

    public boolean checkEmail(String email)
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("INF\\user_inf.properties")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if(strLine.matches("(.)*="+email)) {
                    return false;
                }
            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return true;
    }

}
