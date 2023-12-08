package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Subscribtion {
    ArrayList<Member> senior;
    ArrayList<Member> junior;
    ArrayList<Member> passive;
    ArrayList<Member> members;
    ArrayList<Member> notActive;

    private final int juniorPrice = 1000;
    private final int seniorPrice = 1600;
    private final int passivePrice = 500;

    private int seniorPriceTotal;
    private int juniorPriceTotal;
    private int passivePriceTotal;
    private int deptTotal;
    private int seniorDiscount;
    Member membersToBeRemoved;


    private final int seniorAge = 18;

    public Subscribtion(ArrayList<Member> members){
        this.members = members;
        senior = new ArrayList<>();
        junior = new ArrayList<>();
        passive = new ArrayList<>();
        notActive = new ArrayList<>();
    }

    public void assignSubscribtion(){
        checkForDept();
        for(Member member : members){
            if(member.getHasPaid()) {
                membersToBeRemoved = member;
                if (!junior.contains(member) && member.getAge() < seniorAge && (member.getActivity().equals("competing") || member.getActivity().equals("motionist"))) {
                    junior.add(member);
                    passive.remove(member);
                } else if (!senior.contains(member) && member.getAge() >= seniorAge && (member.getActivity().equals("competing") || member.getActivity().equals("motionist"))) {
                    senior.add(member);
                    passive.remove(member);
                } else if (!passive.contains(member) && member.getActivity().equals("passive")) {
                    passive.add(member);
                    senior.remove(member);
                    junior.remove(member);
                }
            } else if(!notActive.contains(member)){
                notActive.add(member);
                if(senior.contains(membersToBeRemoved)){
                    senior.remove(member);
                } else if(junior.contains(member)){
                    junior.remove(membersToBeRemoved);
                } else if(passive.contains(membersToBeRemoved)){
                    passive.remove(membersToBeRemoved);
                }
            }
        }
    }

    public void checkForDept(){
        Member memberToBeRemoved = null;
        for(Member member : notActive){
            if(member.getAge() < seniorAge && member.getHasPaid()){
                memberToBeRemoved = member;
                junior.add(member);
            } else if(member.getAge() >= seniorAge && member.getHasPaid()){
                memberToBeRemoved = member;
                senior.add(member);
            } else if(member.getActivity().equals("passive") && member.getHasPaid()){
                memberToBeRemoved = member;
                passive.add(member);
            }
        }
        notActive.remove(memberToBeRemoved);
    }

    public void assignPriceToSubscribtion(){
        for(Member member : senior){
            if(member.getAge() >= 60){
                seniorDiscount = (seniorPrice * 25) / 100;
                seniorPriceTotal += seniorDiscount;
            } else {
                seniorPriceTotal += seniorPrice;
            }
        }
        for(Member member : junior){
            juniorPriceTotal += juniorPrice;
        }
        for(Member member : passive){
            passivePriceTotal += passivePrice;
        }
        for(Member member : notActive){
            if(member.getAge() >= seniorAge && (member.getActivity().equals("competing") || member.getActivity().equals("motionist"))){
                deptTotal -= seniorPrice;
            } else if(member.getAge() >= 60 ){
                seniorDiscount = (seniorPrice * 25) / 100;
                deptTotal -= seniorDiscount;
            } else if(member.getAge() < juniorPrice && (member.getActivity().equals("competing") || member.getActivity().equals("motionist"))){
                deptTotal -= juniorPrice;
            } else if(member.getActivity().equals("passive")){
                deptTotal -= passivePrice;
            }
        }
    }

    public int getSeniorPriceTotal(){
        return seniorPriceTotal;
    }

    public int getPassivePriceTotal() {
        return passivePriceTotal;
    }

    public int getJuniorPriceTotal() {
        return juniorPriceTotal;
    }

    public ArrayList<Member> getJunior() {
        return junior;
    }

    public ArrayList<Member> getPassive() {
        return passive;
    }

    public ArrayList<Member> getSenior() {
        return senior;
    }

    public int getJuniorPrice(){
        return juniorPrice;
    }

    public int getPassivePrice() {
        return passivePrice;
    }

    public int getSeniorPrice() {
        return seniorPrice;
    }

    public ArrayList<Member> getNotActive() {
        return notActive;
    }

    public int getDeptTotal() {
        return deptTotal;
    }

    public void resetPrice(){
        deptTotal = 0;
        seniorPriceTotal = 0;
        juniorPriceTotal = 0;
        passivePriceTotal = 0;
    }
}
