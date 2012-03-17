package wad.spring.service;


import java.util.List;
import wad.spring.domain.Course;

public interface CourseService {
    public Course create(Course course);
    public Course update(Course course);
    public List<Course> findAll();
    public List<Course> find(String coursename);
    public Course findById(long id);
}
