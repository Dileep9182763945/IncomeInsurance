package com.advintek.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advintek.Entity.Plan;
import com.advintek.Service.PlanService;

@RestController
public class PlanController {
	@Autowired
	private PlanService service;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>>  getCategories(){
		Map<Integer,String> map	=service.getCategories();
		
		return new ResponseEntity<>(map,HttpStatus.OK);
		
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getAllPlans(){
		List<Plan> plan=service.getAllPlans();
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> insertNewPlan(@RequestBody Plan p){
		
		String msg=service.newPlan(p);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("/plan/{id}")
	public ResponseEntity<Plan> getPlanById(@PathVariable Integer id){
		Plan p=service.getPlanById(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> UpdatePlan(@RequestBody Plan p){
		String msg="";
		boolean b=service.updateplan(p);
		if(b)
			msg= "Updated plan";
		msg="plan updation fialed";
		return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/Delete/{Id}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer Id){
		Boolean result=service.deleteById(Id);
		String msg="";
		if(result)
		msg= "delete plan";
		msg="plan deletion fialed";	
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("Change-status/{id}/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer id,@PathVariable String status ){
		Boolean result=service.activesw(id, status);
		String msg="";
		msg= "plan status canged";
		msg="plan status changed process fialed";	
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
