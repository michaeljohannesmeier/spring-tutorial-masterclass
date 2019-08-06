package academy.learnprogramming;

import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    // private static final Logger log = LoggerFactory.getLogger(Main.class);

    //private static final String CONFIG_LOCATION = "beans_.xml";

   public static void main(String[] args) {
       log.info("Guess the number game");

       // create context (container)
       //ConfigurableApplicationContext context
       //        = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

       ConfigurableApplicationContext context
               = new AnnotationConfigApplicationContext(GameConfig.class);

       // get numberGenerator from context (container)
       //NumberGenerator numberGenerator
       //        = context.getBean(NumberGenerator.class);

       // call method next() to get a random number
       //int number = numberGenerator.next();

       //log.info("number = {}", number);

       // get game bean from context (container)
       //MessageGenerator messageGenerator =
       //        context.getBean(MessageGenerator.class);

       //log.info("getMainMessage= {}", messageGenerator.getMainMessage());
       //log.info("getResultMessage= {}", messageGenerator.getResultMessage());

       // call reset method --> now called when bean was initialized
       // game.reset();

       // close context (container)
       context.close();
   }
}
