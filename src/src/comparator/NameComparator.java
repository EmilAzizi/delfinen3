package comparator;

import java.util.Collections;
import java.util.Comparator;

public class NameComparator implements Comparator<Member> {

    @Override
    public int compare(Member m1, Member m2) {
        return m1.getSwimmingTime().compareTo(m2.getSwimmingTime);
    }

    public void amountOfAttributes() {
        System.out.println("""
                    Would you like to sort by one or two attributes?
                """);

        int userChoiseForAttributesAmount = 0;
        switch (userChoiseForAttributesAmount) {
            case 1 -> sortSwimmersByOneAttribute();
            case 2 -> sortSwimmersByTwoAttributes();
        }
    }

    public void sortSwimmersByOneAttribute() {
        System.out.println("""
                    What would you like to sort by?
                    1. Name
                    2. Age
                    3. Swimming time
                """);
        int userChoise = input.nextInt();
        switch (userChoise) {
            case 1 -> Collections.sort(memberList, new NameComparator());
            case 2 -> Collections.sort(memberList, new AgeComparator());
            case 3 -> Collections.sort(memberList, new SwimmingTimeComparator());
            System.out.println("The members are now sorted! Press (X) to display the sorted list.");
        }
    }

    public void sortSwimmersByTwoAttributes(int userChoice1, int userChoice2) {
        System.out.println("""
                What would you like to sort by?
                1. Name
                2. Age
                3. Swimming time
                """);
        Comparator comparator1 = null;
        Comparator comparator2 = null;

        switch (userChoice1) {
            case 1 -> comparator1 = new NameComparator();
            case 2 -> comparator1 = new AgeComparator();
            case 3 -> {
                comparator1 = new SwimmingTimeComparator();
                System.out.println("""
                        What would you like the second attribute to be?
                        1. Name
                        2. Age
                        3. Swimming time
                        4. Brystsvømning
                        5. Butterfly
                        6. Crawl
                        7. Rygcrawl
                        """);
            }
        }
        switch (userChoice2) {
            case 1 -> comparator2 = new NameComparator();
            case 2 -> comparator2 = new AgeComparator();
            case 3 -> comparator2 = new SwimmingTimeComparator();
            case 4 -> comparator2 = new BrystsvømningComparator();
            case 5 -> comparator2 = new ButterflyComparator();
            case 6 -> comparator2 = new CrawlComparator();
            case 7 -> comparator2 = new RygcrawlComparator();
        }
        Collections.sort(memberList, comparator1.thenComparing(comparator2));
        System.out.println("The members are now sorted! Press (X) to display the sorted list.");
    }
}