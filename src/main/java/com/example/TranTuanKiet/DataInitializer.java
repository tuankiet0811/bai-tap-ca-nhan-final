package com.example.TranTuanKiet;

import com.example.TranTuanKiet.model.Profile;
import com.example.TranTuanKiet.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(ProfileRepository profileRepository) {
        return args -> {
            if (profileRepository.count() == 0) {
                Profile myProfile = new Profile();
                myProfile.setFullName("Trần Tuấn Kiệt");
                myProfile.setAge(22);
                myProfile.setSchool("Đại học Công nghệ TP.HCM (HUTECH)");
                myProfile.setStudentId("22110123"); // Ví dụ MSSV
                myProfile.setMajor("Công nghệ thông tin");
                myProfile.setSpecialization("Kỹ thuật phần mềm");
                myProfile.setHobbies("Lập trình, Đọc sách, Nghe nhạc");
                profileRepository.save(myProfile);
                System.out.println("Đã khởi tạo dữ liệu mẫu cho Profile.");
            }
        };
    }
}
