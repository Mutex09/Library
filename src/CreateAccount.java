import java.io.*;

public class CreateAccount extends SHA256
{
    public boolean createAccount(String login, String password, String email)
    {
        String pswdHex = sha(password);

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("INF\\user_inf.properties")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine).append("\n");
            }
            sb.append("user=").append(login).append("=").append(pswdHex).append("=").append(email);
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        try (FileWriter fileWriter = new FileWriter("INF\\user_inf.properties")){
            fileWriter.write(sb.toString());
            return true;
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
