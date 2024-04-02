package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class MyController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
   public String home()
   {
       return "this is home";
   }

   //get the courses
    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return this.courseService.getCourses();
    }

    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseService.addCourse(course);
    }
    @PutMapping("/course/{courseId}")
    public Course updateCourse(@RequestBody String string,@PathVariable String courseId)
    {
        String[] splits = string.split(":");
        String newTitle=splits[0];
        String newDesc=splits[1];

        return this.courseService.updateCourse(Long.parseLong(courseId),newTitle,newDesc);
    }

}
