package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.model.Record;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer actualAnswer;

    @Before
    public void setUp() throws Exception {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_return_0A0B_when_no_number_is_correct() {
        //given
        String expected = "0A0B";
        //when
        String input = "5 6 7 8";
        //then
        validateGuessNumber(input,expected);
    }

    @Test
    public void should_return_4A0B_when_answer_is_correct() {
        //given
        String expected = "4A0B";
        //when
        String input = "1 2 3 4";
        //then
        validateGuessNumber(input, expected);
    }

    @Test
    public void should_return_2A2B_when_2_number_is_correct() {
        //given
        String expected = "2A0B";
        //when
        String input = "1 2 5 7";
        //then
        validateGuessNumber(input,expected);
    }

    @Test
    public void should_return_1A1B_when_1_is_correct_and_2_are_include() {
        //when
        String input = "1 5 8 2";
        String expected = "1A1B";
        //then
        validateGuessNumber(input, expected);
    }

    private void validateGuessNumber(String input, String expected) {
        //given
        Answer answer = Answer.createAnswer(input);
        //when
        Record check = actualAnswer.check(answer);
        //then
        Assert.assertEquals(expected,check.getValue());
    }
}