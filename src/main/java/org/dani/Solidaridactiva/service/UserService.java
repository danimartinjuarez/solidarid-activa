package org.dani.Solidaridactiva.service;

import org.dani.Solidaridactiva.models.Users;
import org.dani.Solidaridactiva.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
        private final UsersRepository usersRepository;
    @Autowired
    public UserService(UsersRepository usersRepository) {

            this.usersRepository = usersRepository;
        }
    public Users exist(Users user, Long id) {
        Optional<Users> userUpdate= usersRepository.findById(id);
        if (userUpdate.isPresent()){
            Users _user= userUpdate.get();
            _user.setName(user.getName());
            return usersRepository.save(_user);
        }
        throw new RuntimeException("Could not find");
    }
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users findById(Long id) {
        if (usersRepository.findById(id).isPresent()) {
            return usersRepository.findById(id).get();
        }
        throw new RuntimeException("Could not find");
    }
    public void delete(Long id){
        if (usersRepository.findById(id).isPresent()) usersRepository.deleteById(id);
        throw new RuntimeException("Could not find");
    }
    public Users create(Users user) {
         return usersRepository.save(user);
    }
}
