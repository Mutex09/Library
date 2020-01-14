import java.io.*;

public class Str
{
    public static void main(String[] args) throws IOException
    {

        //Search Book
        BufferedReader messageFile;
        String message = "";
        StringBuilder messageB = new StringBuilder();
        try {
            messageFile = new BufferedReader(new FileReader("src\\Books.txt"));
            while ((message=messageFile.readLine())!=null) {
                messageB.append(message).append("\n");
            }
            messageFile.close();
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println(messageB);
        //Change/add description
        String searchWord = "sasss";
        String changeWord = "This book is about adventure";

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\Books.txt")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (!strLine.matches("(.)*\"" + searchWord + "\"(.)*"))
                sb.append(strLine).append("\n");
            }
        }

        try (FileWriter fileWriter = new FileWriter("src\\Books.txt")){

            fileWriter.write(sb.toString());
        }


    }
}
