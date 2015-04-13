import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * NumberSequenceFormatterTest.java
 */
public class NumberSequenceTest {

    @Test
    public void testThatNumbersAddededToSequenceAreRetrievedAndInCorrectSequence() {
        //GIVEN
        NumberSequence numberSequence = new NumberSequence(Arrays.asList(1, 3, 5, 7, 9));

        //WHEN
        List<Integer> numberSequenceToTest = numberSequence.getNumberSequence();

        //THEN
        Assert.assertEquals(Arrays.asList(1, 3, 5, 7, 9), numberSequenceToTest);
    }

}
