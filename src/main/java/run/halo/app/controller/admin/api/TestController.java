package run.halo.app.controller.admin.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import run.halo.app.enums.TestEnum;

/**
 * DESCRIPTION:
 * <P>
 *     枚举测试
 * </p>
 *
 * @author WangMin
 * @since 2019-07-13 17:07
 */
@RestController
@Slf4j
@RequestMapping("/api/admin/test")
public class TestController {
    @GetMapping
    @ApiOperation("test")
    public TestEnum test(
            @ApiParam("test enum")
            @RequestParam(name = "testEnum", required = false, defaultValue = "WHITE") TestEnum testEnum) {
        log.info("testEnum:{}", testEnum);
        return testEnum;
    }

}
