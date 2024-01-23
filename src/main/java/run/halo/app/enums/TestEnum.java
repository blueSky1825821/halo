package run.halo.app.enums;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019-07-13 17:11
 */
public enum TestEnum implements BaseEnum{
    /**
     *
     */
    BLACK("BLACK"),
    WHITE("WHITE"),
    ;
    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    TestEnum(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
