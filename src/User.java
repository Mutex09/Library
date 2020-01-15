import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class User extends UserInterface implements Account
{
    protected Scanner in = new Scanner(System.in);
    protected StringBuilder command = new StringBuilder();

    @Override
    public void mainWindow() {
        Commands.commandsUser();
        command.append(in.nextLine());
        change();
    }




    public void change()
    {
        switch (command.toString())
        {
            case ("1"):
                command.delete(0,command.length());
                System.out.println("----Search---\n");
                Commands.commandsAdmin();
                search();
                mainWindow();
                break;
            case ("2"):
                pageNumber = 1;
                command.delete(0,command.length());
                try {
                    messageFile.close();
                    System.out.println("---Catalog---");
                    messageFile = new BufferedReader(new FileReader("src\\Books.txt"));
                } catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                catalog();
                mainWindow();
                break;
            case ("3"):
                command.delete(0,command.length());
                System.out.println("-Proposition-\n");
                proposition();
                mainWindow();
                break;
            case ("11"):
                command.delete(0,command.length());
                exit();
                break;
            default:
                pageNumber = 1;
                command.delete(0,command.length());
                try {
                    messageFile.close();
                }catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                System.out.println("No such command\n");
                mainWindow();
                break;
        }
    }


    void proposition()
    {
        Proposition prop = new Proposition();

        System.out.println("Enter subject of your mail");
        String subject = in.nextLine();
        System.out.println("Type your mail");
        String mail = in.nextLine();

        prop.makeProposition(subject,mail);
        System.out.println("Message was sent successfully!");
        mainWindow();
    }




    @Override
    public void exit() {
        System.out.println("Are you sure?");
        System.out.println("1----No\n2----Yes");
        command.append(in.nextLine());

        switch (command.toString())
        {
            case ("1"):
                command.delete(0,command.length());
                mainWindow();
                break;
            case ("2"):
                command.delete(0,command.length());
                System.exit(0);
                break;
            default:
                command.delete(0,command.length());
                System.out.println("Not a command");
                exit();
                break;
        }
    }

    User() throws IOException
    {

    }

}
