package in.nit.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Student;
import in.nit.serivce.StudentService;


@RestController
@RequestMapping("/rest")
public class StudentRestController {
	@Autowired
	private StudentService service;
 
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		try {
			Integer id = service.saveStudent(student);
			return new ResponseEntity<String>(id + "saved", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Unable to Save", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllStudents() {
		ResponseEntity<?> resp = null;
		try {
			List<Student> list = service.getAllStudent();
			if (list != null && !list.isEmpty())
				resp = new ResponseEntity<List<Student>>(list, HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneStudent(@PathVariable Integer id) {
		try {
			TimeUnit.SECONDS.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResponseEntity<?> resp = null;
		try {
			Optional<Student> opt = service.getOneStudent(id);
			if (opt.isPresent())
				resp = new ResponseEntity<Student>(opt.get(), HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("No Data Found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to Fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		ResponseEntity<String> resp = null;
		try {
			boolean exist = service.isExist(id);
			if (exist) {
				service.deleteStudent(id);
				resp = new ResponseEntity<String>(id + "removed", HttpStatus.OK);
			} else {
				resp = new ResponseEntity<String>(id + "-Not Exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to Delete", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		ResponseEntity<String> resp = null;
		try {
			boolean exist = service.isExist(student.getStsId());
			if (exist) {
				service.saveStudent(student);
				resp = new ResponseEntity<String>(student.getStsId() + "-Updated", HttpStatus.OK);
			} else {
				resp = new ResponseEntity<String>(student.getStsId() + "-Not Exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to Update", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
}