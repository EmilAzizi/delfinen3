package member;

public class Member {
    private int age;
    private String name;
    private int phoneNumber;
    private String email;
    private String activity;
    private String address;
    private double swimmingTime;
    private String competing;
    private String competitionPlace;
    private String competitionPlacement;
    private String competitionTime;


    public Member(int age, String name, int phoneNumber, String email, String activity, String address) {
        this.age = age;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activity = activity;
        this.address = address;
        this.swimmingTime = 0;
    }


    public Member(int age, String name, int phoneNumber, String email, String activity, double swimmingTime, String address) {
        this.age = age;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activity = activity;
        this.address = address;
        this.swimmingTime = swimmingTime;
    }

    // competing swimmer with competitions
    public Member(int age, String name, int phoneNumber, String email, String competing, String activity, String address, String competitionPlace, String competitionPlacement, String competitionTime) {
        this.age = age;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activity = activity;
        this.address = address;
        this.swimmingTime = swimmingTime;
        this.competing = competing;
        this.competitionPlace = competitionPlace;
        this.competitionPlacement = competitionPlacement;
        this.competitionTime = competitionTime;
    }

    // competing swimmer with no competitions
    public Member(int age, String name, int phoneNumber, String email, String competing, String activity, double swimmingTime, String address) {
        this.age = age;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activity = activity;
        this.address = address;
        this.swimmingTime = swimmingTime;
        this.competing = competing;
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

    @Override
    public String toString() {
        return "member.Member{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", activity='" + activity + '\'' +
                ", address='" + address + '\'' +
                ", swimmingTime=" + swimmingTime +
                '}';
    }

    public String getCompeting() {
        return competing;
    }

    public String getCompetitionPlace() {
        return competitionPlace;
    }

    public String getCompetitionPlacement() {
        return competitionPlacement;
    }
}
