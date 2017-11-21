package com.javadev.helloSpring.service;

import com.javadev.helloSpring.model.Lecture;
import com.javadev.helloSpring.model.Presence;
import com.javadev.helloSpring.model.Person;
import com.javadev.helloSpring.model.Presence;

import com.javadev.helloSpring.service.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PresenceService {
    static HashMap<Integer, Person> listAllPersons = PersonService.getPersonIdMap();
    static HashMap<Integer, Lecture> listAllLectures = LectureService.getLectureIdMap();

    static HashMap<Integer, Presence> presenceIdMap = getPresenceIdMap();

    public PresenceService() {
        super();

        if (presenceIdMap == null) {
            presenceIdMap = new HashMap<Integer, Presence>();
            Presence mon = new Presence(1,1, Presence.StudentPresent.NOT_SET);
            Presence thu = new Presence(2,1, Presence.StudentPresent.PRESENT);
            Presence the = new Presence(2,0, Presence.StudentPresent.ABSENT);

            presenceIdMap.put(mon.getId(), mon);
            presenceIdMap.put(thu.getId(), thu);
            presenceIdMap.put(the.getId(), the);
        }
    }

    public List getAllPresences() {
        List presences = new ArrayList(presenceIdMap.values());
        return presences;
    }

    public List getAllPersonPresences(int personId) {
        List<Presence> presences = new ArrayList(presenceIdMap.values());
        
        List<Presence> personPresences = new ArrayList();

        for (Presence p : presences) {

            if(personId == p.getPerson_id())
                personPresences.add(p);
        }

        return personPresences;
    }

    public Presence getPresence(int id) {
        Presence presence = presenceIdMap.get(id);
        return presence;
    }

    public Presence addPresence(Presence presence) {
        if(!listAllPersons.containsKey(presence.getPerson_id()) ||
                !listAllLectures.containsKey(presence.getLecture_id())) {
            return null;
        }
        presence.setId();
        presenceIdMap.put(presence.getId(), presence);
        return presence;
    }

    public Presence updatePresence(Presence presence) {
        if(!presenceIdMap.containsKey(presence.getId()))
            return null;

        presenceIdMap.put(presence.getId(), presence);
        return presence;

    }

    public void deletePresence(int id) {
        if(presenceIdMap.containsKey(id)){
            presenceIdMap.remove(id);}
    }

    public static HashMap<Integer, Presence> getPresenceIdMap() {
        return presenceIdMap;
    }
}
