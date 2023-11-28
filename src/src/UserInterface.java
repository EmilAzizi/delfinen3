import java.util.ArrayList;


public class UserInterface {

    Controller controller;

    public UserInterface(Controller controller) {
        this.controller = controller;
    }




    public void printMembers(String name, int age, String address, int phoneNumber, String email, String activity, double swimmingTime){
        System.out.println("Name: " + name + ", " + "Age: " + age + ", " +
                           "Address: " + address + ", " + "PhoneNumber: " + phoneNumber + ", " +
                           "Email: " + email + ", " + "Activity: " + activity + ", " + "SwimmingTime: " + swimmingTime);


    }
}
