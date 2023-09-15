package uz.tuit.gayratjonakademo.service;

import org.springframework.stereotype.Service;
import uz.tuit.gayratjonakademo.payload.ApiResponse;
import uz.tuit.gayratjonakademo.payload.LoginDto;
import uz.tuit.gayratjonakademo.payload.UserDto;

public interface UserService {
    ApiResponse create(UserDto dto);
    ApiResponse getAll();
    ApiResponse getOneByUserName(String username);

    ApiResponse login(LoginDto dto);
}
