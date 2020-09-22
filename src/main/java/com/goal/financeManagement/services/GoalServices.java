package com.goal.financeManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goal.financeManagement.models.Goals;
import com.goal.financeManagement.repositories.GoalRepository;

@Service
public class GoalServices {

	@Autowired
	private GoalRepository goalRepo;

	// fetch All goals
	public List<Goals> listAll() {

		return goalRepo.findAll();
	}

	// fetch goal by Id
	public Goals get(Long id) {

		return goalRepo.findById(id).get();
		}

	// add goal
	public void save(Goals goals) {
		goalRepo.save(goals);

	}

	// delete goal
	public void delete(Long id) {
		goalRepo.deleteById(id);

	}
	

}
