package in.nit.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.model.Student;
import in.nit.repo.StudentRepo;
import in.nit.serivce.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo repo;

	@Override
	public Integer saveStudent(Student s) {
		
		return repo.save(s).getStsId();
	}

	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}

	@Override
	public Optional<Student> getOneStudent(Integer id) {
		return repo.findById(id);
	}

	@Override
	public boolean isExist(Integer id) {
		return repo.existsById(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

}
