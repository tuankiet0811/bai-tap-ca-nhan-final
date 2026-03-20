package com.example.TranTuanKiet.controller;

import com.example.TranTuanKiet.model.Profile;
import com.example.TranTuanKiet.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Profile> profiles = profileRepository.findAll();
        if (!profiles.isEmpty()) {
            model.addAttribute("profile", profiles.get(0));
        } else {
            Profile emptyProfile = new Profile();
            emptyProfile.setFullName("Chưa có dữ liệu");
            emptyProfile.setSchool("Chưa có dữ liệu");
            model.addAttribute("profile", emptyProfile);
        }
        return "index";
    }

    @GetMapping("/edit")
    public String editProfileForm(Model model) {
        List<Profile> profiles = profileRepository.findAll();
        if (!profiles.isEmpty()) {
            model.addAttribute("profile", profiles.get(0));
        } else {
            model.addAttribute("profile", new Profile());
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String updateProfile(@ModelAttribute Profile profile) {
        List<Profile> profiles = profileRepository.findAll();
        if (!profiles.isEmpty()) {
            profile.setId(profiles.get(0).getId());
        }
        profileRepository.save(profile);
        return "redirect:/";
    }
}
