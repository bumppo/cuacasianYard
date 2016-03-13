package web;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import to.TOUser;

import java.util.List;

/**
 * Created by vmoskalik on 11.03.2016.
 */
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TOUser get(@PathVariable("id") int id){
        return service.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll(){
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user, @PathVariable("id") int id){
        service.update(user);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
    }
}
