import member.Member;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Filehandler {

    private final File f;

    public Filehandler(String fileName){
        f = new File(fileName);
    }

    public void savePersonToCSV(ArrayList<Member> memberList) throws IOException {
        PrintStream output = new PrintStream(f);
        for (Member member : memberList) {
            String line =
                    member.getName() + " , " +
                            member.getAge() + " , " +
                            member.getPhoneNumber() + " , " +
                            member.getEmail() + " , " +
                            member.getActivity() + " , " +
                            member.getAdress() + " , " +
                            member.getSwimmingTime();
            output.println(line);
        }
        output.close();
    }
}