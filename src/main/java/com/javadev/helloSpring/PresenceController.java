package com.javadev.helloSpring;

import com.javadev.helloSpring.model.Presence;
import com.javadev.helloSpring.service.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PresenceController {

    @Autowired
    PresenceService presenceService;

    @RequestMapping(value = "/presences", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getPresences() {
        List listOfPresences = presenceService.getAllPresences();
        return listOfPresences;
    }

    @RequestMapping(value = "/presences/student/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getAllStudentPresences(@PathVariable int id) {
        return presenceService.getAllPersonPresences(id);
    }

    @RequestMapping(value = "/presence/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Presence getPresenceById(@PathVariable int id) {
        return presenceService.getPresence(id);
    }

    @RequestMapping(value = "/presences", method = RequestMethod.POST, headers = "Accept=application/json")
    public Presence addPresence(@RequestBody Presence presence) {
        return presenceService.addPresence(presence);
    }

    @RequestMapping(value = "/presences", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Presence updatePresence(@RequestBody Presence presence) {
        return presenceService.updatePresence(presence);
    }

    @RequestMapping(value = "/presence/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deletePresence(@PathVariable("id") int id) {
        presenceService.deletePresence(id);
    }
}
