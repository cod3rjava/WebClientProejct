package in.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
