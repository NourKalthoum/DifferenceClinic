package com.example.difference_clinic.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.example.difference_clinic.entities.AppointmentEntity;
import com.example.difference_clinic.entities.UserEntity;
import com.example.difference_clinic.repositories.AppointmentRepo;
import com.example.difference_clinic.repositories.BodySectionsRepo;
import com.example.difference_clinic.repositories.UserRepo;
import com.example.difference_clinic.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private BodySectionsRepo bodySectionsRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepo userRepo;

    public AppointmentEntity createAppointment(AppointmentEntity appointment) throws Exception {
        UserEntity user = userRepo.findByUsername(appointment.getUser().getUsername());
        if (user.getScore() > 0) {
            user.setScore(user.getScore() + 10);
            userRepository.save(user);
            appointment.setUser(user);
            return appointmentRepo.save(appointment);
        } else {
            throw new Exception("you are punished , you can not book an appointmant");
        }
    }

    public Optional<AppointmentEntity> getAppointment(Long id) {
        return appointmentRepo.findById(id);
    }

    public List<Time> AvailableTimes(LocalDate appointmentDate) {

        List<Time> intervals = new ArrayList<>(25);
        Time startTime = Time.valueOf("08:00:00");
        Time endTime = Time.valueOf("19:30:00");
        intervals.add(startTime);

        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        while (cal.getTime().before(endTime)) {
            cal.add(Calendar.MINUTE, 30);
            intervals.add(new Time(cal.getTimeInMillis()));
        }
        // for (Time time : intervals) {
        //     System.out.println(time);
        // }
        List<AppointmentEntity> appointmentinDay = appointmentRepo
                .getAppointmentEntityByAppointmentDateOrderByAppointmentTime(appointmentDate);

        List<Time> booked = new ArrayList<>(25);
        for (int i = 0; i < appointmentinDay.size(); i++) {
            booked.add(appointmentinDay.get(i).getAppointmentTime());
        }

        List<Time> avaliables = new ArrayList<>(25);

        for(int j=0; j<intervals.size(); j++){
          if(booked.contains(intervals.get(j)) != true)
          avaliables.add(intervals.get(j));
        }

        return avaliables;
    }

    public List<AppointmentEntity> ShowAppointmentOfNowDay() {

        LocalDate appointmentDate = LocalDate.now();
        List<AppointmentEntity> appointmentinDay = appointmentRepo
                .getAppointmentEntityByAppointmentDateOrderByAppointmentTime(appointmentDate);

      return appointmentinDay;
    }

    public List<AppointmentEntity> ShowAppointmentOfDay(LocalDate appointmentDate) {

        List<AppointmentEntity> appointmentinDay = appointmentRepo
        .getAppointmentEntityByAppointmentDateOrderByAppointmentTime(appointmentDate);

      return appointmentinDay;
    }

    public boolean missed(Long id){

        Optional<AppointmentEntity> appointment = appointmentRepo.findById(id);
        appointment.get().getUser().setScore(appointment.get().getUser().getScore() - 20);
         appointmentRepo.save(appointment.get());
        return true;
    }
 
    public List<AppointmentEntity> ShowAppointmentofUser(Long id){

       Optional<UserEntity> user = userRepo.findById(id);
       List<AppointmentEntity> appointments = user.get().getAppointmens();
       return appointments;

    }

    public boolean deleteAppointment(Long id)
    {   Optional<AppointmentEntity> appointment = appointmentRepo.findById(id);
        appointment.get().getUser().setScore(appointment.get().getUser().getScore() + 5);
        appointmentRepo.save(appointment.get());
        appointmentRepo.delete(appointmentRepo.findById(id).orElseThrow());
        return appointmentRepo.findById(id).isEmpty();
    }

}
