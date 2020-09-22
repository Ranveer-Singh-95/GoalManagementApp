package com.goal.financeManagement.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.goal.financeManagement.models.Goals;
import com.goal.financeManagement.services.GoalServices;


@Controller
public class GoalController {
	
	private static final Logger LOG=LoggerFactory.getLogger(GoalController.class);
	@Autowired
	private GoalServices goalServices;

	@RequestMapping("/")
	public String home() {
          LOG.error("Error getting Home Page");
		return "home";
	}
	
	@RequestMapping("/goals")
	public String viewGoals(Model model) {
		LOG.error("Error getting View Goals Page");
		model.addAttribute("listGoals",goalServices.listAll());
		return "goals";
	}
	
	@RequestMapping("/new")
	public String showNewGoal(Model model) {
		LOG.error("Error getting Set New Goal Page");
		Goals goals=new Goals();
	 model.addAttribute("goals",goals);
		return "new_goal";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveGoal(@ModelAttribute("goals") Goals goals) {
		LOG.error("Error getting Save Goal Page");
		Long remainAmount=goals.getAmount() - goals.getMicroSave();
		goals.setRemainAmount(remainAmount);
		goalServices.save(goals);
	    return "redirect:/goals";
	}

	@RequestMapping("/delete/{id}")
	public String deleteGoal(@PathVariable(name="id") Long id) {
		LOG.error("Error Deleting Page");
		this.goalServices.delete(id);
		return "redirect:/goals";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditGoal(@PathVariable(name="id") Long id) {
		LOG.error("Error getting Edit Page");
		ModelAndView mav=new ModelAndView("edit_goal");
		Goals goals=goalServices.get(id);
	    mav.addObject("goals",goals);
		return mav;
	}
	
	@RequestMapping("/micro/{id}")
	public ModelAndView microGoalAdd(@PathVariable(name="id") Long id) {
		LOG.error("Error getting Micro Edit Page");
		ModelAndView mav=new ModelAndView("add_microSave");
		Goals goals=goalServices.get(id);
	    mav.addObject("goals",goals);
		return mav;
	}
	
	@RequestMapping(value="/microsave", method=RequestMethod.POST)
	public String microSave(@ModelAttribute("goals") Goals goals) {
		
		LOG.error("Error MicroSaving Page");
		Long newMicroSave=goals.getMicroSave()+goals.getmoreMicroSave();
		goals.setMicroSave(newMicroSave);
		Long remainAmount=goals.getAmount() - goals.getMicroSave();
		goals.setRemainAmount(remainAmount);
		goalServices.save(goals);
	    return "redirect:/goals";
	}


}
