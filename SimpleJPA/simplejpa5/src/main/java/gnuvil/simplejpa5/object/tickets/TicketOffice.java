package gnuvil.simplejpa5.object.tickets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount , Ticket ... tickets){
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket getTicket(){
        return  tickets.remove(0);
    }
    public void minusAmount(){
        this.amount -= amount ;
    }
    public void plusAmount(){
        this.amount += amount ;
    }
}
