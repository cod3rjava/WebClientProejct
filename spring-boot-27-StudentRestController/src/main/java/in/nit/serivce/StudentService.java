package in.nit.serivce;

import java.util.List;
import java.util.Optional;

import in.nit.model.Student;

public interface StudentService {
	public Integer saveStudent(Student s);
	public List<Student> getAllStudent();
	public Optional<Student> getOneStudent(Integer id);
	public boolean isExist(Integer id);
	public void deleteStudent(Integer id);

}
