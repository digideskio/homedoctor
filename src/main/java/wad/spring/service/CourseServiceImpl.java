package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.spring.domain.Course;
import wad.spring.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> find(String coursename) {
        return courseRepository.findByCoursename(coursename);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course create(Course course) {
        if(find(course.getCoursename()).size()>0) return null;
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        if(find(course.getCoursename()).isEmpty()) return null;
        return courseRepository.save(course);
    }

    @Override
    public Course findById(long id) {
        return courseRepository.findOne(id);
    }

    
    
}
