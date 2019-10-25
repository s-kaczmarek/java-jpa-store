package service;

import org.junit.Assert;
import org.junit.Test;

public class RandomServiceTest {

    @Test
    public void shouldReturnValidNumberFromRange() throws WrongRangeException {
        // given
        int from = 7;
        int to = 30;

        // when
        int result = RandomService.generateIntBetween(from, to);

        // then
        Assert.assertTrue("Number " + result + " is not in range: " + from + " - " + to,(result >= from) && (result <= to));
    }

    // adnotacja dzięki której sprawdzimy, czy rzucono wyjątek
    @Test(expected = WrongRangeException.class)
    public void shouldThrowWrongRangeException() throws WrongRangeException{
        // given
        int from = 30;
        int to = 7;

        // when
        int result = RandomService.generateIntBetween(from, to);
    }
}
