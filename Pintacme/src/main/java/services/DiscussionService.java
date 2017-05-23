package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Administrator;
import domain.Budget;
import domain.Discussion;
import domain.Request;
import repositories.DiscussionRepository;

@Service
@Transactional
public class DiscussionService {

	@Autowired
	private DiscussionRepository discussionRepository;
	
	@Autowired
	private AdminService adminService;

	public DiscussionService() {
		super();
	}
	
	public Discussion findOne(int discussionId){
		Discussion result;
		
		result = discussionRepository.findOne(discussionId);
		
		return result;
	}
	

	public Collection<Discussion> findAll(){
		Collection<Discussion> res;
		
		res = discussionRepository.findAll();
		
		return res;
	}

	public Discussion create(Request request){
		Discussion result;
		
		result = new Discussion();
		
		return result;
	}
	
	public Budget namePainter(int discussionId){
		Budget result;
		
		result = discussionRepository.namePainterByBudget(discussionId);
		
		return result;
	}
	
	public void  accept(Discussion discussion){
		Assert.notNull(discussion);
		Administrator principal;
		
		principal = adminService.getLogged();
		Assert.isInstanceOf(Administrator.class, principal);
		
		discussion.setResolution("ACCEPTED");
		
		discussionRepository.saveAndFlush(discussion);
	}
	
	public void  denied(Discussion discussion){
		Assert.notNull(discussion);
		Administrator principal;
		
		principal = adminService.getLogged();
		Assert.isInstanceOf(Administrator.class, principal);
		
		discussion.setResolution("REJECTED");
		
		discussionRepository.saveAndFlush(discussion);
	}
}

