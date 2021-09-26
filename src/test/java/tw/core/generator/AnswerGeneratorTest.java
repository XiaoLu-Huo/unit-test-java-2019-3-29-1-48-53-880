package tw.core.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    @Test
    void should_get_num_when_input_is_correct() throws OutOfRangeAnswerException {
        //given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        when(randomIntGenerator.generateNums(anyInt(),anyInt())).thenReturn("1 2 3 4");
        //when
        Answer answer = answerGenerator.generate();
        Assertions.assertNotNull(answer);
    }

    @Test()
    void should_throw_exception_when_input_is_incorrect() throws OutOfRangeAnswerException {
        //given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(anyInt(),anyInt())).thenReturn("1 2 3 15");
        //when
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        OutOfRangeAnswerException exception = assertThrows(OutOfRangeAnswerException.class,
                answerGenerator::generate,
                "Answer format is incorrect");
        assertEquals("Answer format is incorrect",exception.getMessage());
    }
}

