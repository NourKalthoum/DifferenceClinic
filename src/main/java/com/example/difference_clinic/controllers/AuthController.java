package com.example.difference_clinic.controllers;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.difference_clinic.entities.ERole;
import com.example.difference_clinic.entities.Role;
import com.example.difference_clinic.entities.UserEntity;
import com.example.difference_clinic.payload.request.LoginRequest;
import com.example.difference_clinic.payload.request.SignupRequest;
import com.example.difference_clinic.payload.request.VerificationRequest;
import com.example.difference_clinic.payload.response.MessageResponse;
import com.example.difference_clinic.payload.response.UserInfoResponse;
import com.example.difference_clinic.repositories.RoleRepository;
import com.example.difference_clinic.repositories.UserRepository;
import com.example.difference_clinic.security.jwt.JwtUtils;
import com.example.difference_clinic.security.services.UserDetailsImpl;
import com.example.difference_clinic.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  UserService userService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    String userName = loginRequest.getUsername();
    Optional<UserEntity> user = userRepository.findByUsername(userName);
    user.get().setStatus(true);
    userRepository.save(user.get());

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
        .body(new UserInfoResponse(userDetails.getId(),
            userDetails.getUsername(),
            roles));

  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

// Create new user's account
    UserEntity user = new UserEntity(signUpRequest.getUsername(),
        encoder.encode(signUpRequest.getPassword()));
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setMobile(signUpRequest.getMobile());
        user.setSocialStatus(signUpRequest.getSocialStatus());
        user.setGender(signUpRequest.getGender());
        user.setJob(signUpRequest.getJob());
        user.setBirthday(signUpRequest.getBirthday());
        user.setScore(100l);
        user.setStatus(false);
        user.setIsActive(false);
        String zipCode = genint(user);
        user.setZipCode(zipCode);

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
          case "admin":
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);

            break;
          case "mod":
            Role modRole = roleRepository.findByName(ERole.ROLE_DOCTOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(modRole);

            break;
            
          default:
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);
    
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(signUpRequest.getUsername(), 
            signUpRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
    

    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
    .body(user);

  }

  @PostMapping(path ="/verification")
	public Object verification(@RequestBody VerificationRequest verificationRequest) { 
    Optional<UserEntity> user = userRepository.findByUsername(verificationRequest.getUsername());
          try {
            if(user != null){
              if(verificationRequest.getZipCode().equals(user.get().getZipCode())){
                user.get().setStatus(true);
                user.get().setIsActive(true);
                userRepository.save(user.get());
               
              }
            }
		return user;
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
	}

  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser(@Valid @RequestBody LoginRequest loginRequest) {
    String userName = loginRequest.getUsername();
    Optional<UserEntity> user = userRepository.findByUsername(userName);
    user.get().setStatus(false);
    userRepository.save(user.get());

    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }

  @RequestMapping("/testInteger")
  public String genint(UserEntity user) {

    int intRange;
    try {

      for (int i = 0; i < 10; i++) {
        intRange = generateRandomIntIntRange(1000, 10000);
        String num = Integer.toString(intRange);

        Random random = new Random();
        user.setZipCode(num);
        userRepository.save(user);
      }
    } catch (Exception e) {
    
      e.printStackTrace();
    }

    return user.getZipCode();

  }

  public static int generateRandomIntIntRange(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;

  }
}

