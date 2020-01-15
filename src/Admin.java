import java.util.Scanner;

public class Admin
{


    public static void main(String[] args) {

        System.out.println(Login.login("Andrey","123"));
        Scanner in = new Scanner(System.in);

        System.out.println(Check.checkRights("Andrey"));
        System.out.println(Check.checkEmail("Andrey.renovski@gmail.com"));
        System.out.println(Check.checkLogin("Andrey"));

        System.out.print("Enter: ");

        System.out.println(Login.login("Kirill","1515"));


    }
}
