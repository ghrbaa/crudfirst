package com.example.crudfirst.crudfirst.Service;

import com.example.crudfirst.crudfirst.Models.Profile;
import com.example.crudfirst.crudfirst.Repo.ProfileRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl {

    @Autowired
    ProfileRepoInterface profileRepoInterface;

    public Profile saveProfile(Profile profile) {

        return profileRepoInterface.save(profile);

    }

    public List<Profile> getProfile() {
        return (List<Profile>) profileRepoInterface.findAll();
    }

    public Profile updateProfile(Profile profile, Long customer_id) {

        Profile depDB = profileRepoInterface.findById(customer_id).get();

        depDB.setCustomer_id(customer_id);
        depDB.setMsisdn(profile.getMsisdn());
        depDB.setUpdated_at(profile.getUpdated_at());
        depDB.setExposure(profile.getExposure());

        return profileRepoInterface.save(depDB);
    }

    public void deleteProfileById(Long customer_id) {
        profileRepoInterface.deleteById(customer_id);

    }
}
