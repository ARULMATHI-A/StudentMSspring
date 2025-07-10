package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.controller.StudentController;
import com.example.demo.model.Student;
import com.example.demo.repository.DetailRepository;
import com.example.demo.repository.StudentRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
	@MockBean
    private StudentRepository studentRepo;

    @SuppressWarnings("removal")
	@MockBean
    private DetailRepository repodetail;

    @Test
    public void testShowSignupPage() throws Exception {
        mockMvc.perform(get("/students/form"))
               .andExpect(status().isOk())
               .andExpect(view().name("signup"));
    }

    @Test
    public void testSignupNewUser() throws Exception {
        when(studentRepo.findByUsername("testuser")).thenReturn(null);

        mockMvc.perform(post("/students/signup")
                .param("username", "testuser")
                .param("passwd", "pass123"))
               .andExpect(status().isOk())
               .andExpect(view().name("login"));

        verify(studentRepo, times(1)).save(any(Student.class));
    }
}
