package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Genre;

@Component
@Transactional
public class GenreToStringConverter implements Converter<Genre, String> {

	@Override
	public String convert(Genre genre) {
		String result;

		if(genre == null){
			result = null;
		}else{
			result = String.valueOf(genre.getGenre());
		}

		return result;
	}

}