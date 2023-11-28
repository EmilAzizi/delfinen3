package comparator;

import member.Member;

import java.util.Collections;
import java.util.Comparator;

public class NameComparator implements Comparator<Member> {


    @Override
    public int compare(Member m1, Member m2) {
        return m1.getName().compareTo(m2.getName());
    }
}


