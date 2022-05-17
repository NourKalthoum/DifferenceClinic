package com.example.difference_clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import java.util.ArrayList;

// import com.example.difference_clinic.entities.Role;
// import com.example.difference_clinic.entities.UserEntity;
// import com.example.difference_clinic.services.UserService;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication

public class DifferenceClinicApplication {

  public static void main(String[] args) {
    SpringApplication.run(DifferenceClinicApplication.class, args);
  }
  
  //   @Bean
  // CommandLineRunner run (UserService  userService)
  // {

  //   return args -> {
    
  //     userService.saveRole(new Role(null,"ROLE_USER"));
  //     userService.saveRole(new Role(null,"ROLE_MANAGER"));
  //     userService.saveRole(new Role(null,"ROLE_ADMIN"));
  //           userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));


  //   userService.saveUser(new UserEntity (null,"John Travolta","john","1234",new ArrayList<>()));
  //   userService.saveUser(new UserEntity (null,"Will Smith ","will","1234",new ArrayList<>()));
  //   userService.saveUser(new UserEntity (null,"Jim Carry","jim","1234",new ArrayList<>()));
  //   userService.saveUser(new UserEntity (null,"Arnold Schwarzenegger","arnold","1234",new ArrayList<>()));


  //   userService.addRoleToUser("john","ROLE_USER");
  //   userService.addRoleToUser("john","ROLE_MANAGER");
  //   userService.addRoleToUser("will","ROLE_MANAGER");
  //   userService.addRoleToUser("jim","ROLE_ADMIN");
  //   userService.addRoleToUser("arnold","ROLE_SUPER_ADMIN");
  //   userService.addRoleToUser("arnold","ROLE_ADMIN");
  //   userService.addRoleToUser("arnold","ROLE_USER");

  // };
  // }

  @Bean
  PasswordEncoder passwordEncoder()
  {
    return new BCryptPasswordEncoder();
  
  }
  

}
