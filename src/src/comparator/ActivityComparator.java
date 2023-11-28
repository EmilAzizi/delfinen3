package comparator;

import member.Member;

import java.util.Comparator;

public class ActivityComparator implements Comparator<Member> {


    @Override
    public int compare(Member m1, Member m2) {
        return m1.getActivity().compareTo(m2.getActivity());
    }
}