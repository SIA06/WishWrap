package com.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.RoleEntity;
import com.entity.UserEntity;
import com.repository.RoleRepo;
import com.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    public String register(UserEntity user) {

        // check duplicate email
        if (userRepo.existsByEmail(user.getEmail())) {
            return "Email already exists!";
        }

        String username = user.getName();
        String password = user.getPassword();

        if ("admin@123".equals(username) && "admin@123".equals(password)) {
            Optional<RoleEntity> adminRole = roleRepo.findByRoleName("ADMIN");
            if (adminRole.isEmpty()) {
                return "Admin role not found!";
            }
            user.setRole(adminRole.get());

        } 
        /*else if ("cust@123".equals(username) && "cust@123".equals(password)) {
            Optional<RoleEntity> customerRole = roleRepo.findByRoleName("CUSTOMER");
            if (customerRole.isEmpty()) {
                return "Customer role not found!";
            }
            user.setRole(customerRole.get());
            }*/

        else if ("delivery@123".equals(username) && "delivery@123".equals(password)) {
            Optional<RoleEntity> deliveryRole = roleRepo.findByRoleName("DELIVERY");
            if (deliveryRole.isEmpty()) {
                return "Delivery role not found!";
            }
            user.setRole(deliveryRole.get());

        } else {
            Optional<RoleEntity> customerRole = roleRepo.findByRoleName("CUSTOMER");
            if (customerRole.isEmpty()) {
                return "Customer role not found!";
            }
            user.setRole(customerRole.get());
        }

        userRepo.save(user);
        return "Signup successful! Role: " + user.getRole().getRoleName();
    }
}
