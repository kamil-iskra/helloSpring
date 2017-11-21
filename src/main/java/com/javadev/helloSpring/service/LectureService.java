package com.javadev.helloSpring.service;

import com.javadev.helloSpring.model.Lecture;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class LectureService {
    static HashMap<Integer, Lecture> lectureIdMap = getLectureIdMap();

    public LectureService() {
        super();

        if (lectureIdMap == null) {
            lectureIdMap = new HashMap<Integer, Lecture>();
            Lecture programowanie = new Lecture("Programowanie Obiektowe", "2017-11-29");
            Lecture sieci = new Lecture("Sieci komputerowe", "2017-11-30");
            Lecture wzorce_proj = new Lecture("Wzorce Projektowe", "2017-12-05");
            Lecture grafika = new Lecture("Grafika komputerowa", "2017-12-17");

            lectureIdMap.put(programowanie.getId(), programowanie);
            lectureIdMap.put(sieci.getId(), sieci);
            lectureIdMap.put(wzorce_proj.getId(), wzorce_proj);
            lectureIdMap.put(grafika.getId(), grafika);
        }
    }

    public List getAllLectures() {
        List lectures = new ArrayList(lectureIdMap.values());
        return lectures;
    }

    public Lecture getLecture(int id) {
        Lecture lecture = lectureIdMap.get(id);
        return lecture;
    }

    public Lecture addLecture(Lecture lecture) {
        lecture.setId();
        lectureIdMap.put(lecture.getId(), lecture);
        return lecture;
    }

    public Lecture updateLecture(Lecture lecture) {
        if(!lectureIdMap.containsKey(lecture.getId()))
            return null;

        lectureIdMap.put(lecture.getId(), lecture);
        return lecture;

    }

    public void deleteLecture(int id) {
        if(lectureIdMap.containsKey(id)){
        lectureIdMap.remove(id);}
    }

    public static HashMap<Integer, Lecture> getLectureIdMap() {
        return lectureIdMap;
    }
}
