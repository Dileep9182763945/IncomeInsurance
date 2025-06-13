package com.advintek.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advintek.Entity.Plan;
import com.advintek.Entity.PlanCategory;
import com.advintek.Repository.PlanCategoryRepository;
import com.advintek.Repository.PlanRepository;

@Service
public class PlanService implements IPlanService {
	
	@Autowired
	private PlanRepository planrepo;
	@Autowired
	private PlanCategoryRepository categoryrepo;

	@Override
	public Map<Integer, String> getCategories() {
		List<PlanCategory> categories=categoryrepo.findAll();//got all categories objects
		Map<Integer,String> categorymap=new HashMap<>();
		categories.forEach(category->categorymap.put(category.getCategoryId(), category.getCategoryType()));// to get categoryid and categorytype from category object 
		// need to process category object through for each method and put those two property in the above map object
		        return categorymap;
	}

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> plans=planrepo.findAll();
		return plans;
	}

	@Override
	public String newPlan(Plan plan) {
		
		Integer planid=planrepo.save(plan).getPlanId();
		return "Plan register with "+ planid;
	}

	@Override
	public Plan getPlanById(Integer id) {
	
		Optional<Plan>  plan=planrepo.findById(id);
		if(plan!=null) {
		return plan.get();
		}
		return null;
		
		//plan!=null ? plan.get(): null;
	}

	@Override
	public Boolean updateplan(Plan plan) {
		
		Integer planid=planrepo.save(plan).getPlanId();
		return planid!=null;
	}

	@Override
	public Boolean deleteById(Integer Id) {
		planrepo.deleteById(Id);
		return true;
	}

	@Override
	public Boolean activesw(Integer id, String status) {
		Optional<Plan>  plan=planrepo.findById(id);
		if(plan!=null) {
		plan.get().setActviesw(status);
			return true;
		}
		return false;
	}

}
