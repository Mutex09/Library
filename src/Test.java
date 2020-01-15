import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test
{
    private StringBuilder command = new StringBuilder();
    private Scanner in = new Scanner(System.in);
    private BufferedReader messageFile = new BufferedReader(new FileReader("src\\Books.txt"));
    private String message = "";
    private StringBuilder messageB = new StringBuilder();
    private int page = 1;

    public Test() throws IOException {
        System.out.println("Welcome to Library.");
        MainWindow();
    }

    public void MainWindow() throws IOException {
        System.out.println("0----Log In\n1----Sign Up");

        command.append(in.nextLine());

        switch (command.toString())
        {
            case ("0"):
                command.delete(0,command.length());
                System.out.println("Welcome User");
                System.exit(0);
                break;
            case ("1"):
                command.delete(0,command.length());
                System.out.println("Please, enter the password");
                String password = in.nextLine();
                if (password.equals("1122")) {
                    System.out.println("Welcome Administrator");
                    MainWindowAdmin();
                    break;
                }
            default:
                command.delete(0,command.length());
                System.out.println("No such command");
                MainWindow();
                break;
        }
    }

    public void MainWindowAdmin() throws IOException {
        System.out.println("1----AddBook");
        System.out.println("2----EditMode");
        System.out.println("3----RemoveBook");
        System.out.println("4----Search");
        System.out.println("5----Catalog");
        System.out.println("11---Exit");

        command.append(in.nextLine());
        ChangeAdmin(command);
    }

    public void ChangeAdmin(StringBuilder e) throws IOException {
        switch (e.toString())
        {
            case ("1"):
                command.delete(0,command.length());
                System.out.println("---AddBook---");
                AddBook();
                break;
            case ("2"):
                command.delete(0,command.length());
                System.out.println("--EditMode---");
                EditMode();
                break;
            case ("3"):
                command.delete(0,command.length());
                System.out.println("-RemoveBook--");
                RemoveBook();
                break;
            case ("4"):
                command.delete(0,command.length());
                System.out.println("----Search---");
                Search();
                break;
            case ("5"):
                page = 1;
                command.delete(0,command.length());
                messageFile.close();
                System.out.println("---Catalog---");
                messageFile = new BufferedReader(new FileReader("src\\Books.txt"));
                Catalog();
                break;
            case ("11"):
                System.out.println("Bye!");
                System.exit(0);
            default:
                page = 1;
                command.delete(0,command.length());
                messageFile.close();
                System.out.println("No such command\n");
                System.out.println("1----AddBook");
                System.out.println("2----EditMode");
                System.out.println("3----RemoveBook");
                System.out.println("4----Search");
                System.out.println("5----Catalog");
                System.out.println("11---Exit");
                command.append(in.nextLine());
                ChangeAdmin(command);
                break;
        }
    }



    public void Catalog() throws IOException {
        command.delete(0,command.length());

        System.out.println("0----NextPage");
        System.out.println("1----AddBook");
        System.out.println("2----EditMode");
        System.out.println("3----RemoveBook");
        System.out.println("4----Search");
        System.out.println("5----Catalog");
        System.out.println("11---Exit");
        System.out.println("\n" + page + " page\n");

        try {
            for (int i =0; i < 5; i++){
                message = messageFile.readLine();
                if (message!=null) {
                    messageB.append(message).append("\n");
                }else
                {
                    messageB.append("End of Catalog").append("\n");
                    break;
                }
            }
        } catch (IOException e)
        {
            System.out.print(e.getMessage());
        }

        System.out.println(messageB);

        messageB.delete(0, messageB.length());
        command.append(in.nextLine());

        if (command.toString().equals("0") && message!=null) {
            command.delete(0,command.length());
            page++;
            Catalog();

        }
        if (command.toString().equals("0") && message == null)
        {
            page++;
            command.delete(0,command.length());
            System.out.println("End of Catalog\n");
            Catalog();
        }
        if (!command.toString().equals("0"));
            ChangeAdmin(command);

    }

    public void Search() throws IOException
    {
        int check = 0;
        command.delete(0,command.length());
        System.out.println("Enter name of the book:");

        String searchWord = in.nextLine();

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Books.txt")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains(searchWord)) {
                    sb.append(strLine).append("\r\n");
                    check++;
                }
            }
        }

        if (check == 0) {
            System.out.println("Sorry, we don't have this one");
        }else
        System.out.println(sb.toString());

        System.out.println("1----AddBook");
        System.out.println("2----EditMode");
        System.out.println("3----RemoveBook");
        System.out.println("4----Search");
        System.out.println("5----Catalog");
        System.out.println("11---Exit");

        command.append(in.nextLine());
        ChangeAdmin(command);
    }


    public void AddBook() throws IOException
    {
        command.delete(0,command.length());

        System.out.println("Format");
        String format = in.nextLine();
        System.out.println("Name");
        String name = in.nextLine();
        System.out.println("Description");
        String description = in.nextLine();

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Books.txt")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine).append("\n");
            }
            sb.append(format).append("|\"").append(name).append("\"| \"").append(description).append("\"");
        }

        try (FileWriter fileWriter = new FileWriter("src\\Books.txt")){

            fileWriter.write(sb.toString());
        }

        System.out.println("All done!");

        System.out.println("1----AddBook");
        System.out.println("2----EditMode");
        System.out.println("3----RemoveBook");
        System.out.println("4----Search");
        System.out.println("5----Catalog");
        System.out.println("11---Exit");
        ChangeAdmin(command);
    }

    public void EditMode() throws IOException
    {
        int check = 0;
        command.delete(0,command.length());

        System.out.println("Enter name of the book:");
        String searchName = in.nextLine();
        System.out.println("Enter the description");
        String description = in.nextLine();

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Books.txt")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.matches("(.)*\"" + searchName + "\"(.)*")) {
                    strLine = strLine.substring(0,strLine.lastIndexOf("|") + 1)+ " \"" + description + "\"";
                    check++;
                }
                sb.append(strLine).append("\n");
            }
        }

        try (FileWriter fileWriter = new FileWriter("src\\Books.txt")){

            fileWriter.write(sb.toString());
        }

        if (check == 0) {
            System.out.println("Sorry, we don't have this one");
        }else
        System.out.println("Edit finished");

        System.out.println("1----AddBook");
        System.out.println("2----EditMode");
        System.out.println("3----RemoveBook");
        System.out.println("3----Search");
        System.out.println("4----Catalog");
        System.out.println("11---Exit");
        ChangeAdmin(command);
    }

    public void RemoveBook() throws IOException
    {
        command.delete(0,command.length());

        System.out.println("Enter name of the book");
        String name = in.nextLine();

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Books.txt")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (!strLine.matches("(.)*\"" + name + "\"(.)*"))
                    sb.append(strLine).append("\n");
            }
        }

        try (FileWriter fileWriter = new FileWriter("src\\Books.txt")){

            fileWriter.write(sb.toString());
        }

        System.out.println("Book removed!");

        System.out.println("1----AddBook");
        System.out.println("2----EditMode");
        System.out.println("3----RemoveBook");
        System.out.println("4----Search");
        System.out.println("5----Catalog");
        System.out.println("11---Exit");

        command.append(in.nextLine());

        ChangeAdmin(command);
    }




    public static void main(String[] args) throws InputMismatchException, IOException {
        Test Graw = new Test();
    }
}
