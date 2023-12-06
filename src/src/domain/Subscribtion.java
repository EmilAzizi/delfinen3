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


    private final int seniorAge = 18;

    public Subscribtion(ArrayList<Member> members){
        this.members = members;
        senior = new ArrayList<>();
        junior = new ArrayList<>();
        passive = new ArrayList<>();
        notActive = new ArrayList<>();
    }

    public void assignSubscribtion(){
        for(Member member : members){
            if(member.getHasPaid()) {
                if (!junior.contains(member) && member.getAge() < seniorAge && (member.getActivity().equals("competing") || member.getActivity().equals("motionist"))) {
                    junior.add(member);
                } else if (!senior.contains(member) && member.getAge() >= seniorAge && (member.getActivity().equals("competing") || member.getActivity().equals("motionist"))) {
                    senior.add(member);
                } else if (!passive.contains(member) && member.getActivity().equals("passive")) {
                    passive.add(member);
                }
            } else if(!notActive.contains(member)){
                notActive.add(member);
            } else if(notActive.contains(member) && member.getHasPaid()){
                notActive.remove(member);
            }
        }
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
