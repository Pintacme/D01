package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Discussion;
import repositories.DiscussionRepository;

@Component
@Transactional
public class StringToDiscussionConverter implements Converter<String, Discussion> {

	@Autowired
	private DiscussionRepository discussionRepository;
	
	@Override
	public Discussion convert(String arg0) {
		Discussion result;
		int id;
		try{
			if(StringUtils.isEmpty(arg0))
				result = null;
			else{
				id=Integer.valueOf(arg0);
				result = discussionRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
	}
	
}
