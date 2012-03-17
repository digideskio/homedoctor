package wad.spring.domain;

import java.util.List;
import javax.persistence.*;


@Entity
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String coursename;
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private User lecturer;
    @ManyToMany
    private List<User> students;

    public int getSize(){
        return students.size();
    }
    
    public User getLecturer() {
        return lecturer;
    }

    public void setLecturer(User lecturer) {
        this.lecturer = lecturer;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }
    
    
}
