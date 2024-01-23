package run.halo.app.factory;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import run.halo.app.enums.BaseEnum;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019-07-13 17:16
 */
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnumConverter(targetType);
    }

    private final class StringToEnumConverter<T extends BaseEnum> implements Converter<String, T> {

        private Class<T> enumType;

        public StringToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T convert(String source) {
            T[] enumConstants = enumType.getEnumConstants();
            for (T enumConstant : enumConstants) {
                if (StringUtils.equals(enumConstant.getCode(), source)) {
                    return enumConstant;
                }
            }
            return (T) Enum.valueOf(null, source.trim());
        }
    }
}
