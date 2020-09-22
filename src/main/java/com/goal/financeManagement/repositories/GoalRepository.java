package com.goal.financeManagement.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goal.financeManagement.models.Goals;

@Repository
public interface GoalRepository extends JpaRepository<Goals,Long>{
	

}
