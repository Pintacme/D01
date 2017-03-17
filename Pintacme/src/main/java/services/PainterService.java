package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.PainterRepository;

@Service
@Transactional
public class PainterService {

	@Autowired
	private PainterRepository painterRepository;

	public PainterService() {
		super();
	}
}
