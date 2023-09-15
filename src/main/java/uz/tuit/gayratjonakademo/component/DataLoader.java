//package uz.tuit.gayratjonakademo.component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import uz.tuit.gayratjonakademo.entity.Role;
//import uz.tuit.gayratjonakademo.entity.User;
//import uz.tuit.gayratjonakademo.repository.RoleRepository;
//import uz.tuit.gayratjonakademo.repository.UserRepository;
//
//import java.util.Set;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Value("${spring.sql.init.mode}")
//    private String initMode;
//
//    @Override
//    public void run(String... args) {
//        if (initMode.equals("always")) {
//            Role user = new Role();
//            user.setName("USER");
//            Role admin = new Role();
//            admin.setName("ADMIN");
//
//            User user1 = new User();
//            user1.setUsername("user");
//            user1.setEmail("user@gmail.com");
//            user1.setPassword(passwordEncoder.encode("1234"));
//            user1.setRoles(Set.of(roleRepository.save(user)));
//
//            User user2 = new User();
//            user2.setUsername("admin");
//            user2.setEmail("admin@gmail.com");
//            user2.setPassword(passwordEncoder.encode("1234"));
//            user2.setRoles(Set.of(roleRepository.save(admin)));
//
//            userRepository.save(user1);
//            userRepository.save(user2);
//        }
//    }
//}
