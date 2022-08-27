package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {

    private final UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        dependencies = dependsOn;
    }

    @Override
    public void complete() {
        if (dependencies.length != 0) {
            for (UserStory dependency : dependencies) {
                if (!dependency.isCompleted()) {
                    isCompleted = false;
                    break;
                } else isCompleted = true;
            }
        } else isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public UserStory[] getDependencies() {
        return Arrays.copyOf(dependencies, dependencies.length);
    }

    @Override
    public String toString() {
        return String.format("[US %s] %s", id, name);
    }
}
