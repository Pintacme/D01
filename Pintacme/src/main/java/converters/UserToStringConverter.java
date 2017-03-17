package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Material;
import domain.User;

@Component
@Transactional
public class UserToStringConverter implements Converter<User, String> {

	@Override
	public String convert(User arg0) {
		String result;
		
		if(arg0 == null){
			result = null;
		}else{
			result = String.valueOf(arg0.getId());
		}
		return result;
		
	}

}
