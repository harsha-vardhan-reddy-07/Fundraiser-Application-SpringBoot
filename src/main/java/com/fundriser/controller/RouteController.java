package com.fundriser.controller;

import com.fundriser.models.DonationsModel;
import com.fundriser.models.FundriserModel;
import com.fundriser.models.UserModel;
import com.fundriser.repos.DonationsRepo;
import com.fundriser.repos.FundriserRepo;
import com.fundriser.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Controller
public class RouteController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    FundriserRepo fundriserRepo;

    @Autowired
    DonationsRepo donationsRepo;


    @RequestMapping("/landing")
    public ModelAndView landingPage(){
        return new ModelAndView("landing");
    }

    @RequestMapping("/login")
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @PostMapping("/login-user")
    public UserModel loginUser(@ModelAttribute UserModel userData, Model model) {
        try {
            UserModel user = userRepo.findByEmail(userData.getEmail());

            if (user.getPassword().equals(userData.getPassword())) {
                // Return userData as JSON response
                return user;
            }
            return null;
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return null;
        }
    }

    @RequestMapping("/register")
    public ModelAndView registerPage(){
        return new ModelAndView("register");
    }

    @RequestMapping("/register-user")
    public UserModel registerUser(@ModelAttribute UserModel userData, Model model) {
        try {

            UserModel user = userRepo.save(userData);
            return user;

        } catch (Exception e) {

            return null;
        }
    }

    @RequestMapping("/")
    public ModelAndView userHomePage(){

        List<FundriserModel> fundrisers = fundriserRepo.findAll();

        return new ModelAndView("user/user-home", "fundrisers", fundrisers);
    }
    @RequestMapping("/new-fundriser")
    public ModelAndView newFundPage(){
        return new ModelAndView("user/new-fundriser");
    }

    @RequestMapping("/add-fundraiser")
    public FundriserModel addNewFundraiser(@ModelAttribute FundriserModel fundraiserData, Model model){

        fundraiserData.setCollectedAmount(0);


        System.out.println(fundraiserData);

        FundriserModel fundraiser = fundriserRepo.save(fundraiserData);

        return fundraiser;
    }


    @RequestMapping("/my-fundrisers/{id}")
    public ModelAndView myFundPage(@PathVariable("id") String id){

        List<FundriserModel> fundrisers = fundriserRepo.findAll();

        List<FundriserModel> filteredfundrisersList = fundrisers.stream()
                .filter(fundriser -> id.equals(fundriser.getApplicantId()))
                .collect(Collectors.toList());



        return new ModelAndView("user/my-fundrisers", "fundrisers", filteredfundrisersList);
    }

    @RequestMapping("/fundriser/{id}")
    public ModelAndView fundPage(@PathVariable("id") String id){

        Optional<FundriserModel> fundriserData = fundriserRepo.findById(id);
        FundriserModel fundriser = fundriserData.get();

        List<DonationsModel> donations = donationsRepo.findAll();

        List<DonationsModel> filteredDonations = donations.stream()
                .filter(donation -> id.equals(donation.getFundriserId()))
                .collect(Collectors.toList());


        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("fundriser", fundriser);

        modelMap.addAttribute("donations", filteredDonations);

        return new ModelAndView("user/user-fundriser", modelMap);
    }

    @RequestMapping("/admin-fundriser/{id}")
    public ModelAndView adminFundPage(@PathVariable("id") String id){

        Optional<FundriserModel> fundriserData = fundriserRepo.findById(id);
        FundriserModel fundriser = fundriserData.get();

        List<DonationsModel> donations = donationsRepo.findAll();

        List<DonationsModel> filteredDonations = donations.stream()
                .filter(donation -> id.equals(donation.getFundriserId()))
                .collect(Collectors.toList());


        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("fundriser", fundriser);

        modelMap.addAttribute("donations", filteredDonations);

        return new ModelAndView("admin/admin-fundriser", modelMap);
    }



    @RequestMapping("/update-fundriser/{id}")
    public ModelAndView updateFundPage(@PathVariable("id") String id){

        Optional<FundriserModel> fundriserInfo = fundriserRepo.findById(id);

        FundriserModel fundriser = fundriserInfo.get();

        System.out.println(fundriser);

        return new ModelAndView("user/update-fundriser", "fundriser", fundriser);
    }

    @RequestMapping("/update-fund")
    public FundriserModel updateFundraiser(@ModelAttribute FundriserModel fundraiserData, Model model){

        Optional<FundriserModel> fundriserInfo = fundriserRepo.findById(fundraiserData.applicantId);

        FundriserModel fundriser = fundriserInfo.get();

        fundriser.setApplicantName(fundraiserData.getApplicantName());
        fundriser.setApplicantEmail(fundraiserData.getApplicantEmail());
        fundriser.setApplicantMobile(fundraiserData.getApplicantMobile());
        fundriser.setFundriserPurpose(fundraiserData.getFundriserPurpose());

        fundriser.setTitle(fundraiserData.getTitle());
        fundriser.setDescription(fundraiserData.getDescription());
        fundriser.setDeadline(fundraiserData.getDeadline());
        fundriser.setTargetAmount(fundraiserData.getTargetAmount());
        fundriser.setBannerImage(fundraiserData.getBannerImage());
        fundriser.setExtraImg1(fundraiserData.getExtraImg1());
        fundriser.setExtraImg2(fundraiserData.getExtraImg2());
        fundriser.setExtraImg3(fundraiserData.getExtraImg3());

        System.out.println(fundraiserData);

        FundriserModel fund = fundriserRepo.save(fundriser);

        return fund;
    }


    @RequestMapping("/make-donation")
    public DonationsModel makeDonation(@ModelAttribute DonationsModel donationData, Model model){


        System.out.println(donationData);

        Optional<FundriserModel> fundriser = fundriserRepo.findById(donationData.getFundriserId());

        FundriserModel fundriserData = fundriser.get();

        fundriserData.setCollectedAmount(fundriserData.getCollectedAmount() + donationData.getDonationAmount());

        fundriserRepo.save(fundriserData);

        DonationsModel donation = donationsRepo.save(donationData);

        return donation;
    }


    @RequestMapping("/admin")
    public ModelAndView adminPage(){

        List<UserModel> users = userRepo.findAll();

        List<FundriserModel> fundrisers = fundriserRepo.findAll();

        List<DonationsModel> donations = donationsRepo.findAll();

        int usersCount = users.size();
        int fundrisersCount = fundrisers.size();
        int donationCount = donations.size();

        int donationsSum = 0;

        for (DonationsModel donation : donations) {
            donationsSum += donation.getDonationAmount();
        }

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute("usersCount", usersCount);
        modelMap.addAttribute("fundrisersCount", fundrisersCount);
        modelMap.addAttribute("donationsCount", donationCount);
        modelMap.addAttribute("donationsSum", donationsSum);


        return new ModelAndView("admin/admin", modelMap);
    }

    @RequestMapping("/all-users")
    public ModelAndView allUsersPage(){

        List<UserModel> users = userRepo.findAll();

        return new ModelAndView("admin/all-users", "users", users);
    }

    @RequestMapping("/all-fundrisers")
    public ModelAndView allFundrisersPage(){

        List<FundriserModel> fundrisers = fundriserRepo.findAll();

        return new ModelAndView("admin/all-fundrisers", "fundrisers", fundrisers);
    }

    @RequestMapping("/all-donations")
    public ModelAndView allDonationsPage(){

        List<DonationsModel> donations = donationsRepo.findAll();

        return new ModelAndView("admin/all-donations", "donations", donations);
    }





}
