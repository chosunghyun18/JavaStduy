package gnuvil.simplejpa5.object.tickets;

public class Audience {
    private Bag bag;
     public Audience(Bag bag){
         this.bag = bag;
     }
     public Bag getBag(){
         return bag ;
     }
}
