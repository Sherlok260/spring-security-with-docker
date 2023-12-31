package uz.tuit.gayratjonakademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.tuit.gayratjonakademo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByName(String name);
}
