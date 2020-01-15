import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Admin extends AdminInterface implements Account
{
    Admin() throws IOException{}
    protected Scanner in = new Scanner(System.in);
    protected StringBuilder command = new StringBuilder();

    @Override
    public void mainWindow() {
        Commands.commandsAdmin();
        command.append(in.nextLine());
        change();
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


    public void change()
    {
        switch (command.toString())
        {
            case ("1"):
                command.delete(0,command.length());
                System.out.println("---AddBook---");
                addBook();
                mainWindow();
                break;
            case ("2"):
                command.delete(0,command.length());
                System.out.println("--EditMode---");
                editMode();
                mainWindow();
                break;
            case ("3"):
                command.delete(0,command.length());
                System.out.println("-RemoveBook--");
                removeBook();
                mainWindow();
                break;
            case ("4"):
                command.delete(0,command.length());
                System.out.println("----Search---\n");
                Commands.commandsAdmin();
                search();
                mainWindow();
                break;
            case ("5"):
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



    public static void main(String[] args) {



    }
}
