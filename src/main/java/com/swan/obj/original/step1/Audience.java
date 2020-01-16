package com.swan.obj.original.step1;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long setTicket(Ticket ticket) {
        return bag.setTicket(ticket);
    }
}
