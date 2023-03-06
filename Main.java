import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static int processId = 0;

    public static void main(String[] args) {
        int choice = 0;
        do {
            choice = showMenu();
            switch (choice) {
                case 1:
                    System.out.println("Creating process...");
                    break;

                case 2:
                    System.out.println("Terminating process...");
                    break;

                case 3:
                    System.out.println("Displaying System Status...");
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please make a valid selection");
                    break;
            }
            System.out.println("Do you want to continue?(0 for no, 1 for yes)? : ");
            int continueProgram = scan.nextInt();
            if (continueProgram == 0)
                break;
        } while (choice != 4);
        System.out.println("Thanks for using the app. Bye :)");
    }

    public static int showMenu() {
        System.out.println("****************");
        System.out.println("1) Create Process");
        System.out.println("2) Terminate Process");
        System.out.println("3) Display System Status");
        System.out.println("4) Exit");
        System.out.println("****************");
        System.out.println("Choice: ");
        int choice = scan.nextInt();
        return choice;
    }
}