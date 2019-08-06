package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Slf4j
public class ConsoleNumberGuess {
//public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {

    // == constants ==
    // private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == constructors ==
    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == fields ==
    //@Autowired
    private final Game game;

    //@Autowired
    private final MessageGenerator messageGenerator;


    // == events ==
    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent() {
        log.info("Container ready for use!");

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");
                String playAgain = scanner.nextLine().trim();
                if(!playAgain.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }
        }
    }
}
