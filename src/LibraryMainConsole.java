import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LibraryMainConsole implements Application
{

    private BufferedReader messageFile = new BufferedReader(new FileReader("src\\Books.txt"));
    private String message = "";
    private StringBuilder messageB = new StringBuilder();
    private int page = 1;
    protected Admin admin = new Admin();
    protected User user = new User();
    protected Check check = new Check();
    public LibraryMainConsole() throws IOException {
    }

    @Override
    public void start()
    {
        System.out.println("Welcome to Library");
        System.out.println("1----LogIn\n2----SignIn\n3----Exit");
        command.append(in.nextLine());
        switch (command.toString())
        {
            case ("1"):
                command.delete(0,command.length());
                logIn();
                break;
            case ("2"):
                command.delete(0,command.length());
                signIn();
                break;
            case ("3"):
                command.delete(0,command.length());
                exit();
                break;
            default:
                System.out.println(command.toString() + " : not a command");
                command.delete(0,command.length());
                start();
                break;
        }
    }

    @Override
    public void logIn()
    {

        System.out.print("Enter your login: ");
        StringBuilder login = new StringBuilder(in.nextLine());
        System.out.print("Enter your password: ");
        StringBuilder password = new StringBuilder(in.nextLine());

        if (Login.login(login.toString(), password.toString())) {
            System.out.println("Welcome " + login  + "\n");
            if (check.checkRights(login.toString()))
            {
                admin.mainWindow();
            }else
                user.mainWindow();
        }
        else {
            System.out.println("Invalid Login or Password");
            start();
        }
    }

    @Override
    public void signIn() {

        CreateAccount signIn = new CreateAccount();

        System.out.print("Enter your login: ");
        StringBuilder login = new StringBuilder(in.nextLine());
        if (!check.checkLogin(login.toString())){
            System.out.println("This Login is already used.");
            start();
            return;
        }

        System.out.print("Enter your email: ");
        StringBuilder email = new StringBuilder(in.nextLine());
        if (!check.checkEmail(email.toString())) {
            System.out.println("This Email is already used.");
            start();
            return;
        }

        System.out.print("Enter your password: ");
        StringBuilder password = new StringBuilder(in.nextLine());

        if (signIn.createAccount(login.toString(),password.toString(),email.toString()))
            System.out.println("Account was created");

        start();
    }

    public void exit() {
        System.out.println("Are you sure?");
        System.out.println("1----No\n2----Yes");
        command.append(in.nextLine());

        switch (command.toString())
        {
            case ("1"):
                command.delete(0,command.length());
                start();
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

    public static void main(String[] args) throws IOException {
        LibraryMainConsole myLib = new LibraryMainConsole();
        myLib.start();
    }
}
