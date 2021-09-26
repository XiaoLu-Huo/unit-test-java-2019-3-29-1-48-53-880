package tw.core;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    private final Answer actualAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;

    @Before
    public void setUp() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
    }

    @Test
    public void should_get_a_guessResult_list_when_call_getHistory() {
        //given
        game.guess(Answer.createAnswer("2 5 6 3"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        //when
        List<GuessResult> guessResultList = game.guessHistory();
        //then
        Assert.assertEquals(guessResultList.size(),2);
        Assert.assertEquals(guessResultList.get(0).getResult(),"0A2B");
        Assert.assertEquals(guessResultList.get(1).getResult(),"4A0B");
        Assert.assertEquals(guessResultList.get(0).getInputAnswer().toString(),"2 5 6 3");
        Assert.assertEquals(guessResultList.get(1).getInputAnswer().toString(),"1 2 3 4");
    }

    @Test
    public void should_return_false_when_call_checkContinue_while_answer_is_correct() {
        //given
        game.guess(Answer.createAnswer("1 2 3 4"));
        //when
        boolean isContinue = game.checkCoutinue();
        String status = game.checkStatus();
        //then
        Assert.assertFalse(isContinue);
        Assert.assertEquals("success",status);
    }

    @Test
    public void should_return_success_when_call_checkStatus_while_answer_is_correct() {
        //given
        game.guess(Answer.createAnswer("1 2 3 4"));
        //when
        String status = game.checkStatus();
        //then
        Assert.assertEquals("success",status);
    }

    @Test
    public void should_return_true_when_call_checkContinue_while_answer_is_incorrect() {
        //given
        game.guess(Answer.createAnswer("4 2 3 9"));
        //when
        boolean isContinue = game.checkCoutinue();
        //then
        Assert.assertTrue(isContinue);
    }

    @Test
    public void should_return_continue_when_call_checkStatus_while_answer_is_incorrect() {
        //given
        game.guess(Answer.createAnswer("4 2 3 9"));
        //when
        String status = game.checkStatus();
        //then
        Assert.assertEquals("continue",status);
    }

    @Test
    public void should_return_fail_when_call_checkStatus_while_incorrect_answer_more_than_six() {
        //given
        game.guess(Answer.createAnswer("4 2 3 9"));
        game.guess(Answer.createAnswer("7 2 3 9"));
        game.guess(Answer.createAnswer("1 5 3 9"));
        game.guess(Answer.createAnswer("4 2 6 9"));
        game.guess(Answer.createAnswer("8 2 3 9"));
        game.guess(Answer.createAnswer("4 2 1 9"));
        //when
        String status = game.checkStatus();
        //then
        Assert.assertEquals("fail",status);
    }

}
