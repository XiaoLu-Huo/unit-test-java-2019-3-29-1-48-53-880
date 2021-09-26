package tw.core.generator;

import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jxzhong on 2017/5/17.
 */
public class AnswerGeneratorTest {
    @Test(expected = OutOfRangeAnswerException.class)
    public void should_throw_OutOfRangeAnswerException_which_is_not_between_0_and_9() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 10");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        answerGenerator.generate();

    }

    @Test
    public void should_get_radam_number() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        Answer answer = answerGenerator.generate();
        assertNotNull(answer);
        assertThat(answer.getIndexOfNum("4"), is(3));
    }
}
