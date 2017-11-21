package com.javadev.helloSpring;

import com.javadev.helloSpring.model.Lecture;
import com.javadev.helloSpring.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LectureController {

    @Autowired
    LectureService lectureService;

    @RequestMapping(value = "/lectures", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getLectures() {
        List listOfLectures = lectureService.getAllLectures();
        return listOfLectures;
    }

    @RequestMapping(value = "/lecture/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Lecture getLectureById(@PathVariable int id) {
        return lectureService.getLecture(id);
    }

    @RequestMapping(value = "/lectures", method = RequestMethod.POST, headers = "Accept=application/json")
    public Lecture addLecture(@RequestBody Lecture lecture) {
        return lectureService.addLecture(lecture);
    }

    @RequestMapping(value = "/lectures", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Lecture updateLecture(@RequestBody Lecture lecture) {
        return lectureService.updateLecture(lecture);
    }

    @RequestMapping(value = "/lecture/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteLecture(@PathVariable("id") int id) {

        lectureService.deleteLecture(id);
    }
}
