package com.mycompany.bd25;

// reprsents a member of the DIG team for an activity
import java.util.Set;

public class DIGMemeber {
// basic deatils for each member
    private int id;
    private String name;
    private Role role;
    private Set<Task> assignedTasks; // what they are going to do 

    public enum Role {
        COLLECTOR, 
        LABELLER, 
        PREPROCESSOR, 
        ML_ENGINEER, 
        TESTER // possible roles 
    }

    public enum Task {
        DATA_COLLECTION, 
        LABELLING, 
        PREPROCESSING, 
        MODEL_TRAINING, 
        MODEL_TESTING // type of work
    }

    public DIGMemeber(int id, String name, Role role, Set<Task> assignedTasks) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.assignedTasks = assignedTasks;
    } // constructor to create member

    public int getId() {
        return id; //getters
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public Set<Task> getAssignedTasks() {
        return assignedTasks;
    }

    @Override
    public String toString() {
        return name + " (" + role + ") - Tasks: " + assignedTasks;
    } // prints a readable version of the member info
}
