package uz.tuit.gayratjonakademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.tuit.gayratjonakademo.jwt.JwtProvider;
import uz.tuit.gayratjonakademo.entity.User;
import uz.tuit.gayratjonakademo.payload.ApiResponse;
import uz.tuit.gayratjonakademo.payload.LoginDto;
import uz.tuit.gayratjonakademo.payload.UserDto;
import uz.tuit.gayratjonakademo.repository.RoleRepository;
import uz.tuit.gayratjonakademo.repository.UserRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    JwtProvider jwtProvider;

    @Override
    public ApiResponse create(UserDto dto) {
        try {
            if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
                return new ApiResponse("This user already created", false);
            }
            User user = new User();
            user.setUsername(dto.getUsername());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setEmail(dto.getEmail());
            user.setRoles(Set.of(roleRepository.findByName("USER")));
            userRepository.save(user);
            return new ApiResponse("user successfully created", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public ApiResponse getAll() {
        try {
            return new ApiResponse("All users", true, userRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public ApiResponse getOneByUserName(String username) {
        try {
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isPresent()) {
                return new ApiResponse("user", true, user.get());
            }
            return new ApiResponse("User not found", false);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public ApiResponse login(LoginDto dto) {
        try {
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(new UsernamePasswordAuthenticationToken(
                    dto.getUsername(),
                    dto.getPassword()
            ));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtProvider.generateToken(authentication);
            return new ApiResponse("success yaxshi", true, token);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
