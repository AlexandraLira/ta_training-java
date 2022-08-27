package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {

    private final int capacity;
    private final int ticketsLimit;
    private Ticket[] tickets = new Ticket[0];

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory != null && !userStory.isCompleted() && isEligible(userStory) && areAllDependenciesInSprint(userStory)) {
            tickets = Arrays.copyOf(tickets, tickets.length + 1);
            tickets[tickets.length - 1] = userStory;
            return true;
        } else return false;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport != null && !bugReport.isCompleted() && isEligible(bugReport)) {
            tickets = Arrays.copyOf(tickets, tickets.length + 1);
            tickets[tickets.length - 1] = bugReport;
            return true;
        } else return false;
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, tickets.length);
    }

    public int getTotalEstimate() {
        int sum = 0;
        for (Ticket ticket : tickets) {
            sum += ticket.getEstimate();
        }
        return sum;
    }

    private boolean isEligible(Ticket ticket) {
        int resultEstimate = getTotalEstimate() + ticket.getEstimate();
        return resultEstimate <= capacity && tickets.length < ticketsLimit;
    }

    private boolean areAllDependenciesInSprint(UserStory userStory) {
        boolean isDependencyInSprint = false;
        if (userStory.getDependencies().length == 0) return true;
        for (UserStory dependency : userStory.getDependencies()) {
            for (Ticket ticket : tickets) {
                if (ticket == dependency) {
                    isDependencyInSprint = true;
                    break;
                } else isDependencyInSprint = false;
            }
            if (!isDependencyInSprint) return false;
        }
        return isDependencyInSprint;
    }
}
