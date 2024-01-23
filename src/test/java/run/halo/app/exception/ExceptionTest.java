package run.halo.app.exception;

import org.junit.Test;
import run.halo.app.utils.ExceptionUtils;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019-07-08 21:26
 */
public class ExceptionTest {
    @Test
    public void test() {
        System.out.println(ExceptionUtils.getStackTrace(new NullPointerException()));
    }

}
