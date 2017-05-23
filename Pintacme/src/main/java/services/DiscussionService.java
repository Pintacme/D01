package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Budget;
import domain.Discussion;
import repositories.DiscussionRepository;

@Service
@Transactional
public class DiscussionService {

	@Autowired
	private DiscussionRepository discussionRepository;
	

	public DiscussionService() {
		super();
	}
	

	public Collection<Discussion> findAll(){
		Collection<Discussion> res;
		
		res = discussionRepository.findAll();
		
		return res;
	}

	public Budget namePainter(int discussionId){
		Budget result;
		
		result = discussionRepository.namePainterByBudget(discussionId);
		
		return result;
	}
}

