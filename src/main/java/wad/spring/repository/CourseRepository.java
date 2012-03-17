package wad.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.spring.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findByCoursename(String coursename);
}
