package com.eaiesb.training.employee;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.eaiesb.training.employee.employee;
//import com.eaiesb.training.employee.employeeRepository;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class employeeController {
	
	
	@Autowired
	private employeeRepository empRepo;

	@GetMapping("/employee")
	public List<employee> getAllemployee() {
		return empRepo.findAll();

	}

	@PostMapping("/employee")
	public employee saveEmployo(@Validated @RequestBody employee employee)

	{
		return empRepo.save(employee);

	}

	@PutMapping("/employee/{id}")
	public employee update(@PathVariable String id, @Validated @RequestBody employee emp) {
		emp.setId(id);
		return empRepo.save(emp);
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		empRepo.deleteById(id);
	}

}
