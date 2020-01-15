import java.util.Scanner;

public interface Application
{
    Scanner in = new Scanner(System.in);
    StringBuilder command = new StringBuilder();

    void start();
    void logIn();
    void signIn();
}
