package tomasz.kosacki.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tomasz.kosacki.dto.UserDto;
import tomasz.kosacki.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users", produces = "application/json")
public class AppController {

    @Autowired
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping
    public List<UserDto> getAllUsers(@RequestParam("language") String language) {

        log.info("Get all users: {}", language);
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public UserDto getUserById(@PathVariable("id") String userId) {

        log.info("Get user by id: {}", userId);
        return userService.getUserById(userId);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public void addUser(@RequestBody @Valid UserDto userDto) {

        log.info("Add user");
        userService.addUser(userDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable("id") String userId) {

        log.info("Delete user: {}", userId);
        userService.deleteUser(userId);
    }
}
