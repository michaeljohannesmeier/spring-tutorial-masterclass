package academy.learnprogramming;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {


    // == fields ==
    private final Random random = new Random();

    // == constructors ==
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //@Autowired
    //@MaxNumber
    @Getter
    private final int maxNumber;

    //@Autowired
    //@MinNumber
    @Getter
    private final int minNumber;


    // == public methods ==
    @Override
    public int next() {
        // min=5, max = 20 --> range 0-15 + min --> 5-20
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    //@Override
    //public int getMaxNumber() {
    //    return maxNumber;
    //}

    //@Override
    //public int getMinNumber() {
    //    return minNumber;
    //}


}
