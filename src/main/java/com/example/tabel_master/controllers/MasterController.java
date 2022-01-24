package com.example.tabel_master.controllers;

import com.example.tabel_master.models.Master;
import com.example.tabel_master.models.User;
import com.example.tabel_master.services.MasterService;
import com.example.tabel_master.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MasterController {
    @Autowired
    private UserService userService;
    @Autowired
    private MasterService masterService;

    @GetMapping("/home")
    public String dashboard(@ModelAttribute("master") Master master, Model model, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        User u = userService.findUserById(userId);
        model.addAttribute("users", u);

        return "/table/home";
    }
    @GetMapping("/tables/new")
    public String newTable(@ModelAttribute("master") Master master,HttpSession session, Model model){
        model.addAttribute("userID", (Long)session.getAttribute("userId"));
        return "/table/new";
    }
    @PostMapping("/tables/new")
    public String newTable(@Valid @ModelAttribute("master") Master master, BindingResult result, HttpSession session){
        if (result.hasErrors()){
            return "/table/new";
        }
        User user = this.userService.findUserById((Long)session.getAttribute("userId"));
        master.setWaiter(user);
        this.masterService.createAnEditTable(master);
        return "redirect:/home";
    }
    @GetMapping("/tables/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model,HttpSession session){
        model.addAttribute("master", this.masterService.findTableById(id));
        model.addAttribute("userID", (Long)session.getAttribute("userId"));
        return "/table/edit";
    }
    @PutMapping("/tables/{id}/edit")
    public String updateTable(@Valid @ModelAttribute("master") Master master, BindingResult result, HttpSession session){
        if (result.hasErrors()){
            return "/table/edit";
        }else {
            User user = this.userService.findUserById((Long)session.getAttribute("userId"));
            master.setWaiter(user);
            this.masterService.createAnEditTable(master);
            return "redirect:/home";
        }
    }

    @DeleteMapping("/tables/{id}/delete")
    public String deleteTable(@PathVariable("id") Long id, HttpSession session){
        this.masterService.deleteTable(id);
        return "redirect:/home";
    }
    @GetMapping("/tables")
    public String allTables(Model model){
        model.addAttribute("table", this.masterService.findAllTable());
        return "/table/allTable";
    }
}
