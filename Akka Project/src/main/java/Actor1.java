import akka.actor.typed.Behavior;
import akka.actor.typed.PostStop;
import akka.actor.typed.PreRestart;
import akka.actor.typed.SupervisorStrategy;
import akka.actor.typed.javadsl.Behaviors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Actor1 extends AbstractActor {
    private final akka.actor.ActorRef actor2;

    public Actor1(akka.actor.ActorRef actor2) {
        this.actor2 = actor2;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("start", s -> {

                    actor2.tell("Hi from Actor1", getSelf());
                })
                .matchEquals("Hi from Actor2", s -> {
                    System.out.println("Actor1 received: " + s);
                })
                .build();
    }

    public static Props props(ActorRef actor2) {
        return Props.create(Actor1.class, () -> new Actor1(actor2));
    }
}


