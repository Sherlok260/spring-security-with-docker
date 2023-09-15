package uz.tuit.gayratjonakademo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.tuit.gayratjonakademo.payload.LoginDto;
import uz.tuit.gayratjonakademo.payload.UserDto;
import uz.tuit.gayratjonakademo.service.UserService;
import uz.tuit.gayratjonakademo.service.UserServiceImp;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getUsers")
    public HttpEntity<?> getUsers() {
        return ResponseEntity.ok(userServiceImp.getAll());
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/test")
    public HttpEntity<?> helo() {
        return ResponseEntity.ok("nima gape");
    }

    @GetMapping("/hello")
    public HttpEntity<?> hello() {
        return ResponseEntity.ok("hello");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user")
    public HttpEntity<?> create(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userServiceImp.create(dto));
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto dto) {
        return ResponseEntity.ok(userServiceImp.login(dto));
    }

}
