package domain;

public class Trainer extends Member{
    String role;
    public Trainer(String name, int phoneNumber, String email, String activity, String address, int day, int month, int year, String role){
        super(name, phoneNumber, email, activity, address, day, month, year);
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
