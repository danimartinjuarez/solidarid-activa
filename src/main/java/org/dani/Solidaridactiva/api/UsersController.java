package org.dani.Solidaridactiva.api;

import org.dani.Solidaridactiva.models.Users;
import org.dani.Solidaridactiva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UserService usersService;
    @Autowired
    public UsersController(UserService usersService) {

        this.usersService = usersService;
    }
    @GetMapping("")
        public List<Users> index() {

        return usersService.findAll();
        }
   @GetMapping("/{id}")
    public Users getById(@PathVariable Long id) {

        return usersService.findById(id);
    }
      @PostMapping("/createUser")
     public void createUser(@RequestBody Users user)
     {
         usersService.create(user);
     }
     @DeleteMapping("/delete/{id}")
     public void deleteUser(@PathVariable Long id)
     {
         usersService.delete(id);
     }
   @PutMapping("/update/{id}")
 public void updateUser(@RequestBody Users user, @PathVariable Long id)
    {
       usersService.exist(user, id);
    }
}
