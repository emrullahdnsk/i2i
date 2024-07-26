import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.Behaviors;

public class Actor2 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("Hi from Actor1", s -> {
                    System.out.println("Actor2 received: " + s);
                    getSender().tell("Hi from Actor2", getSelf());
                })
                .build();
    }

    public static Props props() {
        return Props.create(Actor2.class, Actor2::new);
    }
}
