package tw.core;


import org.junit.Assert;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    @Test
    public void should_return_4_num_when_input_is_less_then_10() {
        //given
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        //when
        String nums = randomIntGenerator.generateNums(9, 4);
        //then
        Assert.assertEquals(nums.split(" ").length, 4);
        Assert.assertEquals(nums.length(), 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_input_is_incorrect() {
        //given
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        //when
        randomIntGenerator.generateNums(2, 4);
    }

    @Test
    public void should_throw_exception() {
        //given
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        //when
        //then
        assertThrows(IllegalArgumentException.class,()->randomIntGenerator.generateNums(2,4));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> randomIntGenerator.generateNums(2, 4),
                "Can't ask for more numbers than are available");
        assertEquals("Can't ask for more numbers than are available", exception.getMessage());
    }
}