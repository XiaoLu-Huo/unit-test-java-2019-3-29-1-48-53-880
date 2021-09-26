package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    @Test
    public void should_return_true_when_num_is_correct() {
        //given
        InputValidator inputValidator = new InputValidator();
        String num = "1 7 3 4";
        //when
        Boolean validate = inputValidator.validate(num);
        //then
        Assert.assertTrue(validate);
    }

    @Test
    public void should_return_false_when_the_number_of_num_is_less_then_four() {
        //given
        InputValidator inputValidator = new InputValidator();
        String num = "1 7 4";
        //when
        Boolean validate = inputValidator.validate(num);
        //then
        Assert.assertFalse(validate);
    }

    @Test
    public void should_return_false_when_the__num_is_more_then_ten() {
        //given
        InputValidator inputValidator = new InputValidator();
        String num = "1 7 4 19";
        //when
        Boolean validate = inputValidator.validate(num);
        //then
        Assert.assertFalse(validate);
    }

    @Test
    public void should_return_false_when_the__num_has_repeat_number() {
        //given
        InputValidator inputValidator = new InputValidator();
        String num = "1 7 4 4";
        //when
        Boolean validate = inputValidator.validate(num);
        //then
        Assert.assertFalse(validate);
    }
}
