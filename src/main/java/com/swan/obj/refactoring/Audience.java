package com.swan.obj.refactoring;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    //2 Audience이 처리 캡슐화
    /*
    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
    */

    //3 Bag안으로 처리 요청
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
