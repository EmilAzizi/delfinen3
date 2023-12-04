import domain.Controller;
import domain.Member;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
        for(Member member : controller.getMemberList()){
            System.out.println(member.getName());
        }
    }
}