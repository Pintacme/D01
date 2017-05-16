package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Discussion;

@Component
@Transactional
public class DiscussionToStringConverter implements Converter<Discussion, String> {

	@Override
	public String convert(Discussion arg0) {
		String result;
		
		if(arg0 == null){
			result = null;
		}else{
			result = String.valueOf(arg0.getId());
		}
		return result;
	}
	
}
