package com.example.difference_clinic;

import com.example.difference_clinic.entities.AboutCenterEntity;
import com.example.difference_clinic.entities.BodySectionsEntity;
import com.example.difference_clinic.entities.ERole;
import com.example.difference_clinic.entities.Role;
import com.example.difference_clinic.entities.UserEntity;
import com.example.difference_clinic.services.AboutCenterService;
import com.example.difference_clinic.services.AppointmentService;
import com.example.difference_clinic.services.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DifferenceClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DifferenceClinicApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService,AboutCenterService aboutCenterService,AppointmentService appointmentService) {

        return args -> {

            userService.saveRole(new Role(1, ERole.ROLE_USER));
            userService.saveRole(new Role(2, ERole.ROLE_DOCTOR));
            userService.saveRole(new Role(3, ERole.ROLE_SECRTERA));
            userService.saveRole(new Role(4, ERole.ROLE_ADMIN));

            // userService.saveUser(new UserEntity(1l,"هبة", "123456789", "هبة", "الحمصي"));

            // userService.addRoleToUser("هبة", "ROLE_ADMIN");

            // appointmentService.addSection(new BodySectionsEntity(1l,"يد"));


            // aboutCenterService.addAboutCenter(new AboutCenterEntity(1l,"مركز دفرنس كلينك تم أنشاءه من 5سنوات جميع الاجهزة مستوردة من الخارج وباحدث التقنيات ","يقدم المركز العديد من الخدمات منها خدمات ازالة الشعر بالليزر بتقنيات متعددة ويقدم العديد من منتجات العناية بالبشرة وباجود الماركات العالمية والكثير من عمليات التجميل التي يقدمها اخصائيين جراحة "));

        };
    }

}
