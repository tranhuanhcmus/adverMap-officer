package com.adsmanagement.users;


import com.adsmanagement.common.Response;
import com.adsmanagement.users.dto.CreateUserDTO;
import com.adsmanagement.users.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "")
    public ResponseEntity<Response<Iterable<User>>> list() {
        var data = this.userService.findAll();
        var res = new Response<>("",data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity<Response<UserDTO>> create(@RequestBody() CreateUserDTO createUserDTO) {
        var data = this.userService.save(createUserDTO);
        var res = new Response<>("",data.toDTO());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
