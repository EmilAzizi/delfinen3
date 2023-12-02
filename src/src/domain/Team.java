package domain;

import java.util.ArrayList;

public class Team {
    private Member trainer;
    private ArrayList<Member> team;
    private boolean hasBeenAssigned = false;

    public Team(Member trainer, ArrayList<Member> team){
        this.trainer = trainer;
        this.team = team;
        hasBeenAssigned = true;
    }

    public boolean getAssignment(){
        return hasBeenAssigned;
    }

    public Team(){
        this.team = null;
        this.trainer = null;
    }

    public String getTrainer() {
        return trainer.getName();
    }

    public ArrayList<Member> getTeam() {
        return team;
    }
}
