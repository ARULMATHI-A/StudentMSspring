package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDetail;
import com.example.demo.repository.DetailRepository;
import com.example.demo.repository.StudentRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository repo;

    @Autowired
    DetailRepository repodetail;

    @GetMapping("/")
    public String home() {
        return "signup"; // assuming you have login.jsp
    }

    @GetMapping("/form")
    public String showForm() {
        return "signup";
    }

    @GetMapping("/loginform")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String passwd,
                        Model model,
                        HttpSession session) {

        Student user = repo.findByUsername(username);
        if (user == null) {
            model.addAttribute("error", "Username does not exist");
            return "login";
        }

        if (!user.getPasswd().equals(passwd)) {
            model.addAttribute("error", "Invalid password");
            return "login";
        }

        session.setAttribute("loggedInUser", user);
        return "redirect:students/dashboard";
    }

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        Student loggedInUser = (Student) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:students/loginform";
        }

        model.addAttribute("username", loggedInUser.getUsername());
        return "dashboard";
    }

    @PostMapping("/signup")
    public String addStudent(@ModelAttribute Student stud, Model model) {
        Student existingUser = repo.findByUsername(stud.getUsername());

        if (existingUser != null) {
            model.addAttribute("error", "Username already exists!");
            return "signup";
        }

        repo.save(stud);
        return "login";
    }

    @GetMapping("/studentForm")
    public String showStudentForm(HttpSession session, Model model) {
        Student loggedInUser = (Student) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:pages/students/loginform";
        }

        StudentDetail detail = repodetail.findByStudent(loggedInUser);
        if (detail == null) detail = new StudentDetail();

        model.addAttribute("studentDetail", detail);
        return "pages/studentForm";
    }

    @PostMapping("/studentform")
    public String addDetails(@ModelAttribute StudentDetail studetail, HttpSession session) {
        Student student = (Student) session.getAttribute("loggedInUser");
        if (student == null) return "redirect:pages/students/loginform";

        StudentDetail existing = repodetail.findByStudent(student);
        if (existing != null) {
            studetail.setId(existing.getId());
        }

        studetail.setStudent(student);
        repodetail.save(studetail);
        return "redirect:pages/students/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:pages/students/loginform";
    }

    @PostMapping("/delete")
    public String deleteAccount(HttpSession session) {
        Student student = (Student) session.getAttribute("loggedInUser");
        if (student != null) {
            StudentDetail detail = repodetail.findByStudent(student);
            if (detail != null) repodetail.delete(detail);
            repo.delete(student);
            session.invalidate();
        }
        return "redirect:pages/students/form";
    }
}
