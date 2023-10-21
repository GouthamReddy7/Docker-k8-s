package com.goutham.kaibur.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goutham.kaibur.model.Server;
import com.goutham.kaibur.service.ServerService;




@RestController
public class ServerController {
@Autowired
private ServerService serverService;
	
@CrossOrigin(origins = "*") 
@PostMapping
public ResponseEntity<Server>saveOrUpdate(@RequestBody Server obj){
	serverService.saveOrUpdate(obj);
	return new ResponseEntity<Server>(serverService.saveOrUpdate(obj),HttpStatus.ACCEPTED);
}

@CrossOrigin(origins = "*") 
@GetMapping
public ResponseEntity<List<Server>> findAll(){
	return new ResponseEntity<List<Server>>(serverService.findAll(),HttpStatus.ACCEPTED);
}

@CrossOrigin(origins = "*") 
@GetMapping("/{id}")
public ResponseEntity<Server> getServerById(@PathVariable String id) {
    Optional<Server> server = serverService.getServerById(id);
    
    if (server.isPresent()) {
        return new ResponseEntity<>(server.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@CrossOrigin(origins = "*") 
@GetMapping("/findByName")
public ResponseEntity<List<Server>> getServersByName(@RequestParam String name) {
    List<Server> servers = serverService.getServersByName(name);
    
    if (!servers.isEmpty()) {
        return new ResponseEntity<>(servers, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@CrossOrigin(origins = "*") 
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteServerById(@PathVariable String id) {
    boolean deleted = serverService.deleteServerById(id);
    
    if (deleted) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
}


}
