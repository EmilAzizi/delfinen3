package comparator;

import domain.Member;

import java.util.Comparator;

public class SwimmingTimeComparator implements Comparator<Member> {

    @Override
    public int compare(Member m1, Member m2){
        return Double.compare(m1.getSwimmingTime(), m2.getSwimmingTime());
    }
}