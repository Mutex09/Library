import java.io.*;
import java.util.Scanner;

public abstract class UserInterface
{
    protected BufferedReader messageFile = new BufferedReader(new FileReader("src\\Books.txt"));
    protected String books = "";
    protected StringBuilder page = new StringBuilder();
    protected int pageNumber = 1;
    protected Scanner in = new Scanner(System.in);
    protected StringBuilder command = new StringBuilder();

    UserInterface() throws IOException {}

    void search()
    {

        int check = 0;

        System.out.print("Enter name of the book: ");
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
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        if (check == 0) {
            System.out.println("Sorry, we don't have this one");
        }else
            System.out.println(sb.toString());

    }

    void catalog()
    {
        command.delete(0,command.length());
        System.out.println("0----NextPage");
        System.out.println("1----Back");
        System.out.println("\n" + pageNumber + " page\n");

        try {
            for (int i =0; i < 5; i++){
                books = messageFile.readLine();
                if (books!=null) {
                    page.append(books).append("\n");
                }else
                {
                    page.append("End of Catalog").append("\n");
                    break;
                }
            }
        } catch (IOException e)
        {
            System.out.print(e.getMessage());
        }

        System.out.println(page);

        page.delete(0, page.length());
        command.append(in.nextLine());
        if (!command.toString().equals("1") && !command.toString().equals("0"))
        {
            System.out.println( command.toString() + " :not a command\n");

            command.delete(0,command.length());

            pageNumber = 1;

            try {
                messageFile.close();
                messageFile = new BufferedReader(new FileReader("src\\Books.txt"));
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            catalog();
        }
        if (command.toString().equals("0") && books!=null) {
            command.delete(0,command.length());
            pageNumber++;
            catalog();
        }
        if (command.toString().equals("0") && books == null)
        {
            pageNumber++;
            command.delete(0,command.length());
            System.out.println("End of Catalog\n");
            catalog();
        }
        if (command.toString().equals("1"))
        {
            try {
                messageFile.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            command.delete(0,command.length());
            pageNumber = 1;
        }


    }


    public abstract void exit();
}
