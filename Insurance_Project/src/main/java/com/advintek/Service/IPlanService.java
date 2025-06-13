package com.advintek.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.advintek.Entity.Plan;

public interface IPlanService {

	public Map<Integer,String> getCategories();
	
	public List<Plan> getAllPlans();
	
	public String newPlan(Plan plan);
	
	public Plan getPlanById(Integer id);
	
	public Boolean updateplan(Plan plan);
	
	public Boolean deleteById(Integer Id);
	
	public  Boolean activesw(Integer id ,String status);
}
