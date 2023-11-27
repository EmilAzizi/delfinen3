import member.Member;

import java.util.ArrayList;

public class Trainer {

    ArrayList<Member> competingUnderAge = new ArrayList<>();
    ArrayList<Member> competingAboveAge = new ArrayList<>();
    private final int adultAge = 18;

    public void divideMembers(Controller controller){
        ArrayList<Member> allMembers = controller.chairman.getMemberList();

        for(Member member : allMembers){
            int memberAge = member.getAge();

            if(memberAge >= adultAge){
                competingAboveAge.add(member);
            } else {
                competingUnderAge.add(member);
            }
        }
    }
}
