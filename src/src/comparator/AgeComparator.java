package comparator;

import .Member;
import java.util.Comparator;

public class AgeComparator implements Comparator<> {

    @Override
    public int compare(Member m1, Member m2){
        return m1.get().compareTo(m2.getSwimmingTime);
    }
}
