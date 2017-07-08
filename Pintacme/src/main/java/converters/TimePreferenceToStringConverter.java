package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.TimePreference;

@Component
@Transactional
public class TimePreferenceToStringConverter implements Converter<TimePreference, String> {

	@Override
	public String convert(TimePreference TimePreference) {
		String result;

		if(TimePreference == null){
			result = null;
		}else{
			result = String.valueOf(TimePreference.getTimePreference());
		}

		return result;
	}

}