package uz.tuit.gayratjonakademo.payload;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
}
