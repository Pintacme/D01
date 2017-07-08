package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import domain.TimePreference;

@Component
@Transactional
public class StringToTimePreferenceConverter implements Converter<String, TimePreference> {

	@Override
	public TimePreference convert(String text) {
		TimePreference result;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				result = new TimePreference();
				result.setTimePreference(text);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}
}
