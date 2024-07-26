import akka.actor.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.ActorSystem;
import java.util.concurrent.CompletionStage;
public class MainApp {
    public static void main(String[] args) {
        final akka.actor.ActorSystem system = akka.actor.ActorSystem.create("akka-system");
        final ActorRef actor2 = system.actorOf(Actor2.props(), "actor2");
        final ActorRef actor1 = system.actorOf(Actor1.props(actor2), "actor1");

        actor1.tell("start", ActorRef.noSender());

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            system.terminate();
        }));
    }
}