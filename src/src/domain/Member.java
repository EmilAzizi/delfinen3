package domain;

import java.time.LocalDate;
import java.time.Period;

public class Member {
    private int age = 0;
    private String name;
    private int phoneNumber;
    private String email;
    private String activity;
    private String address;
    private double swimmingTime;
    private boolean isCompeting = false;
    private String activityForm;
    private int day;
    private int month;
    private int year;
    private boolean hasPaid = true;
    public Member(String name, int phoneNumber, String email, String activity, String address, int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activity = activity;
        this.address = address;
        this.swimmingTime = 0;
        this.activityForm = null;
    }
    public Member(String name, int phoneNumber, String email, String activity, double swimmingTime, String address, String activityForm, int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activity = activity;
        this.address = address;
        this.swimmingTime = swimmingTime;
        this.activityForm = activityForm;
    }
    public void setIsCompeting(){
        isCompeting = true;
    }

    public boolean getIsCompeting(){
        return isCompeting;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        LocalDate localDate = LocalDate.now();
        LocalDate birthdate = LocalDate.of(year, month, day);
        Period period = Period.between(birthdate, localDate);
        age = period.getYears();

        return age;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public String getActivity(){
        return activity;
    }

    public double getSwimmingTime(){
        return swimmingTime;
    }

    public String getAdress() {
        return address;
    }
    public String getActivityForm(){
        return activityForm;
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public void setActivity(int choice){
        switch(choice){
            case 1 -> this.activity = "competing";
            case 2 -> this.activity = "motionist";
            case 3 -> this.activity = "passive";
            case 4 -> {
                if(hasPaid == true){
                    this.hasPaid = false;
                } else {
                    this.hasPaid = true;
                }
            }
        }
    }
    public void setActivityForm(int activityFormChoice){
        switch (activityFormChoice) {
            case 1 -> this.activityForm = "butterfly";
            case 2 -> this.activityForm = "crawl";
            case 3 -> this.activityForm = "rygcrawl";
            case 4 -> this.activityForm = "brystsvømning";
        }
    }

    public void setSwimmingTime(double swimmingTime) {
        this.swimmingTime = swimmingTime;
    }
    public boolean getHasPaid(){
        return hasPaid;
    }
}
