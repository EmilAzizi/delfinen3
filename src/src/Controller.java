import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
public class Controller {
    UserInterface ui = new UserInterface();
    boolean isRunning = true;
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    Chairman chairman = new Chairman();

    public void run() {
        try {
            chairman.addMembersToMembersList();
            System.out.println("Welcome to delfinen.");
            while (isRunning) {
                System.out.println("""
                        Would you like to:
                        1. Add a new member?
                        2. Display existing members?
                        3. Display swimmers with their trainer?
                        4. Display competing members with their trainer?
                        5. Display top swimmers?
                        6. Sort existing members?
                        0. Exit program.""");

                running();
            }
        } catch(IOException e){
            e.getMessage();
        }
    }

    private void running() throws IOException {
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    chairman.createMemberList();
                }
                case 2 -> chairman.display();
                case 6 -> {
                    ui.amountOfAttributes();
                }
                case 4 -> {
                    System.out.println("load");
                    chairman.loadMembers();
                }
                case 5 -> System.out.println("bluh");
                case 0 -> isRunning = false;
            }
    }
}

