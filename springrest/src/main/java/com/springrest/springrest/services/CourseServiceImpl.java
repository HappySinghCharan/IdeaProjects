package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    List<Course> list;
    public CourseServiceImpl(){
        list=new ArrayList<>();
        list.add(new Course(145,"Java SE","This is JAVA Course"));
        list.add(new Course(500,"C++ Course","This is C++ Course"));
    }
    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c=null;
        for(Course course:list)
        {
            if(course.getId()==courseId)
            {
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(long courseId,String title,String description) {
        Course c=null;
        for(Course course:list)
        {
            if(course.getId()==courseId)
            {
                course.setTitle(title);
                course.setDescription(description);
                c=course;
            }
        }

        return c;
    }


}
