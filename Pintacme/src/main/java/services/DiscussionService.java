package services;

import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Administrator;
import domain.Budget;
import domain.Customer;
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
	
	@Autowired
	private CustomerService customerService;

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
		Assert.notNull(request);
		Discussion result;
		Collection<URL> pictures;
		Date moment;
		
		moment = new Date(System.currentTimeMillis());
		pictures = new HashSet<URL>();
		
		result = new Discussion();
		
		Budget budget = discussionRepository.budgetAcceptedByRequestId(request.getId());
		
		result.setMoment(moment);
		result.setPictures(pictures);
		result.setRequest(request);
		result.setPainter(budget.getPainter());		
		
		return result;
	}
	
	public Discussion save(Discussion discussion){
		Assert.notNull(discussion);
		Discussion result;		
		Date moment;

				
		moment = new Date(System.currentTimeMillis() - 1000);

		discussion.setMoment(moment);
		
		Budget budget = discussionRepository.budgetAcceptedByRequestId(discussion.getRequest().getId());
		
		
		Assert.isTrue(budget.getStatus().equals("ACCEPTED"));
		
		result = discussionRepository.saveAndFlush(discussion);
		
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
	
	public Collection<Discussion> findAllByCustomerId(int customerId){
		Collection<Discussion> result;
		Customer principal;
		
		principal = customerService.getLogged();
		
		result = discussionRepository.findAllByCustomerId(principal.getId());
		
		return result;
	}
}

