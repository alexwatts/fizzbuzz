import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * NumberSequenceFormatterTest.java
 */
public class NumberSequenceTest {

    private List<Integer> oneToTwenty = Arrays.asList(1, 3, 5, 7, 9);

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
