
package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Request;
import repositories.RequestRepository;

@Service
@Transactional
public class RequestService {

	@Autowired
	private RequestRepository	RequestRepository;



	public RequestService() {
		super();
	}

	public Request create(final int budgetId) {
		Request Request;

		Request = new Request();


		return Request;
	}

	public Request save(final Request Request) {
		Assert.notNull(Request);

		return this.RequestRepository.saveAndFlush(Request);

	}

	public Request findOne(final int RequestId) {
		Assert.isNull(RequestId);

		return this.RequestRepository.findOne(RequestId);
	}
}
