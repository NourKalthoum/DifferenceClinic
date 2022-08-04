package com.example.difference_clinic;

import com.example.difference_clinic.entities.AboutCenterEntity;
import com.example.difference_clinic.entities.BodySectionsEntity;
import com.example.difference_clinic.entities.ERole;
import com.example.difference_clinic.entities.Role;
import com.example.difference_clinic.services.AboutCenterService;
import com.example.difference_clinic.services.AppointmentService;
import com.example.difference_clinic.services.ImageStorageService;
import com.example.difference_clinic.services.UserService;

import javax.annotation.Resource;

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

            appointmentService.addSection(new BodySectionsEntity(1l,"وجه"));
            appointmentService.addSection(new BodySectionsEntity(2l,"سوالف"));
            appointmentService.addSection(new BodySectionsEntity(3l,"ذقن"));
            appointmentService.addSection(new BodySectionsEntity(4l,"رقبة"));
            appointmentService.addSection(new BodySectionsEntity(5l,"بطن"));
            appointmentService.addSection(new BodySectionsEntity(6l,"الابطين"));
            appointmentService.addSection(new BodySectionsEntity(7l,"ظهر"));
            appointmentService.addSection(new BodySectionsEntity(8l,"اسفل الظهر"));
            appointmentService.addSection(new BodySectionsEntity(9l,"صدر"));
            appointmentService.addSection(new BodySectionsEntity(10l,"الزندين"));
            appointmentService.addSection(new BodySectionsEntity(11l,"الساعدين"));
            appointmentService.addSection(new BodySectionsEntity(12l,"بيكيني"));
            appointmentService.addSection(new BodySectionsEntity(13l,"الديريير"));
            appointmentService.addSection(new BodySectionsEntity(14l,"فخذين"));
            appointmentService.addSection(new BodySectionsEntity(15l,"ساقين"));
            appointmentService.addSection(new BodySectionsEntity(16l,"مشط القدم"));
            appointmentService.addSection(new BodySectionsEntity(17l,"الاصابع"));
            appointmentService.addSection(new BodySectionsEntity(18l,"شارب"));
            appointmentService.addSection(new BodySectionsEntity(19l,"جسم كامل"));
            
            
            aboutCenterService.addAboutCenter(new AboutCenterEntity(1l,"مركز دفرنس كلينك تم أنشاءه من سنتين جميع الاجهزة مستوردة من الخارج وباحدث التقنيات ","يقدم المركز العديد من الخدمات منها خدمات ازالة الشعر بالليزر بتقنيات متعددة ويقدم العديد من منتجات العناية بالبشرة وباجود الماركات العالمية والكثير من عمليات التجميل التي يقدمها اخصائيين جراحة "));

        };
    }

    // @Resource
    // ImageStorageService imageStorage;
//     @Override
//   public void run(String... arg) throws Exception {
// //		imageStorage.init();
//   }

}
