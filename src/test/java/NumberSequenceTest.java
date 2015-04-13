import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * NumberSequenceFormatterTest.java
 */
public class NumberSequenceTest {

    private List<Integer> oneToTwenty =
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

    @Test
    public void testThatNumbersAddedToSequenceAreRetrievedAndInCorrectSequence() {
        //GIVEN
        NumberSequence numberSequence = new NumberSequence(oneToTwenty);

        //WHEN
        List<Integer> numberSequenceToTest = numberSequence.getNumberSequence();

        //THEN
        Assert.assertEquals(oneToTwenty, numberSequenceToTest);
    }

}
