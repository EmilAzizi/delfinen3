package member;

public class Member {
    private int age;
    private String name;
    private int phoneNumber;
    private String email;
    private String activity;
    private String address;
    private double swimmingTime;
    private boolean isCompeting = false;
    private String subscribtion;
    private String activityForm;


    public Member(int age, String name, int phoneNumber, String email, String activity, String address) {
        this.age = age;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activity = activity;
        this.address = address;
        this.swimmingTime = 0;
        this.activityForm = null;
    }
    public Member(int age, String name, int phoneNumber, String email, String activity, double swimmingTime, String address, String activityForm) {
        this.age = age;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activity = activity;
        this.address = address;
        this.swimmingTime = swimmingTime;
        this.activityForm = activityForm;
    }

    /*public void setSubscribtion(){
        switch (age){
            case
    }*/

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


}
