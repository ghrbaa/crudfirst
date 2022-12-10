package com.example.crudfirst.crudfirst.Controller;

import com.example.crudfirst.crudfirst.Models.Profile;
import com.example.crudfirst.crudfirst.Service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileServiceImpl profileService;

    @PostMapping("/save")
    public Long saveProfile(@RequestBody Profile profile){
        profileService.saveProfile(profile);

        return profile.getCustomer_id();
    }

    @GetMapping("/profile")
    public List<Profile> getProfile(){
        return profileService.getProfile();
    }

    @PutMapping("/update/{id}")
    public Profile updateProfile(@RequestBody Profile profile, @PathVariable("id") Long customer_id ){

        return profileService.updateProfile(profile, customer_id);
    }

    // Delete operation
    @DeleteMapping("/delete/{id}")
    public String deleteProfile(@PathVariable("id") Long customer_id) {
        profileService.deleteProfileById(customer_id);
        return "Deleted Successfully";
    }


}
