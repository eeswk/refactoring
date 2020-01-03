package com.swan.obj.original;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }

    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket(100L);

        Bag bag = new Bag(null, 1000L);
        Audience audience = new Audience(bag);

        TicketOffice ticketOffice = new TicketOffice(0L, ticket);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);

        System.out.println("Ticket 가격: " + ticket.getFee());
        System.out.println("TicketOffice 수입 전: " + ticketOffice.getAmount());
        System.out.println("Audience 보유 금액 전: " + audience.getBag().getAmount());

        theater.enter(audience);

        System.out.println("TicketOffice 수입 후: " + ticketOffice.getAmount());
        System.out.println("Audience 보유 금액 후: " + audience.getBag().getAmount());
    }
}
