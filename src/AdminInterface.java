import java.io.*;

public abstract class AdminInterface extends UserInterface
{

    void addBook()
    {
        Alert alert = new Alert();

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
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        try (FileWriter fileWriter = new FileWriter("src\\Books.txt")){

            fileWriter.write(sb.toString());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("All done!");
        alert.newBookAlert(name);
    }

    void editMode()
    {
        Alert alert = new Alert();
        int check = 0;

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
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        try (FileWriter fileWriter = new FileWriter("src\\Books.txt")){

            fileWriter.write(sb.toString());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        if (check == 0) {
            System.out.println("Sorry, we didn't have this one");
        }else {
            System.out.println("Edit finished");
            alert.newDescriptionAlert(searchName);
        }
    }

    void removeBook()
    {
        System.out.println("Enter name of the book");
        String name = in.nextLine();

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Books.txt")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (!strLine.matches("(.)*\"" + name + "\"(.)*"))
                    sb.append(strLine).append("\n");
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        try (FileWriter fileWriter = new FileWriter("src\\Books.txt")){

            fileWriter.write(sb.toString());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Book removed!");
    }


    AdminInterface() throws IOException {
    }
}
