
package services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Budget;
import domain.Customer;
import domain.Material;
import domain.Painter;
import domain.Request;
import repositories.BudgetRepository;

@Service
@Transactional
public class BudgetService {

	@Autowired
	private BudgetRepository budgetRepository;
	
	@Autowired
	private PainterService painterService;


	public BudgetService() {
		super();
	}

	public Budget findOne(final int budgetId) {
		Assert.notNull(budgetId);

		return this.budgetRepository.findOne(budgetId);

	}
	
	public Budget create() {
		Budget budget = new Budget();
		Collection <Material> materials = new ArrayList<Material>();
		
		Painter painter = painterService.getLogged();
		
		budget.setPainter(painter);
		budget.setMaterials(materials);
		
		return budget;
	}
	
	public Budget save(final Budget budget) {
		Assert.notNull(budget);

		return this.budgetRepository.saveAndFlush(budget);
	}
	
	public void delete(Budget budget){
		Assert.notNull(budget);
		budgetRepository.delete(budget);
	}

	public Collection<Budget> findLoggedBudget() {
		Collection<Budget> result = new ArrayList<Budget>();
		Painter painter= painterService.getLogged();
		result = budgetRepository.findLoggedBudget(painter.getId());
		return result;
	}
	
}
