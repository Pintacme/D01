
package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Budget;
import repositories.BudgetRepository;

@Service
@Transactional
public class BudgetService {

	@Autowired
	private BudgetRepository budgetRepository;


	public BudgetService() {
		super();
	}

	public Budget findOne(final int budgetId) {
		Assert.notNull(budgetId);

		return this.budgetRepository.findOne(budgetId);

	}
}
