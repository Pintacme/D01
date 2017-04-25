package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import domain.Genre;

@Component
@Transactional
public class StringToGenreConverter implements Converter<String, Genre> {

	@Override
	public Genre convert(String text) {
		Genre result;

		try {
			if (StringUtils.isEmpty(text)) {
				result = null;
			} else {
				result = new Genre();
				result.setGenre(text);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}
}
