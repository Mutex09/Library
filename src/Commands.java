public abstract class Commands
{
    static void commandsAdmin()
    {
        System.out.println("1----AddBook");
        System.out.println("2----EditMode");
        System.out.println("3----RemoveBook");
        System.out.println("4----Search");
        System.out.println("5----Catalog");
        System.out.println("11---Exit");
    }

    static void commandsUser()
    {
        System.out.println("1----Search");
        System.out.println("2----Catalog");
        System.out.println("3----Proposition");
        System.out.println("11---Exit");
    }
}
