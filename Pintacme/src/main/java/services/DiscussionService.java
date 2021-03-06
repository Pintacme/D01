package services;

import java.net.URL;
import java.util.ArrayList;
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
import domain.Painter;
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
	private RequestService requestService;
	
	@Autowired
	private BudgetService budgetService;
	
	@Autowired
	private CustomerService customerService;
	
	private PainterService painterService;

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

	public Discussion create(int id){
		Discussion result;
		Collection<String> pictures;
		Date moment;
		
		moment = new Date(System.currentTimeMillis());

		pictures= new ArrayList<String>();
		result = new Discussion();
		
		Request request = requestService.findOne(id);
		
		System.out.println(request);
		Budget budget = budgetService.BudgetAcceptedByRequestId(id);
		//Painter painter = painterService.painterBudgetAcceptedByRequestId(id);
		System.out.println(budget);
		
		result.setRequest(request);
		result.setPainter(budget.getPainter());		
		result.setMoment(moment);
		result.setPictures(pictures);
		result.setResolution("PENDING");
		
		
		return result;
	}
	
	public Discussion save(Discussion discussion){
		Assert.notNull(discussion);
		Discussion result;	
		
		Request request = discussion.getRequest();
	
		result = discussionRepository.save(discussion);
		
		request.setDiscussion(result);
		requestService.save(request);
		
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
	
	public Collection<Discussion> findAllByCustomerId(){
		Collection<Discussion> result;
		Customer principal;
		
		principal = customerService.getLogged();
		
		result = discussionRepository.findAllByCustomerId(principal.getId());
		
		return result;
	}

}

