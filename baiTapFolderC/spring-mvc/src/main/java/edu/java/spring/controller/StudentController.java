package edu.java.spring.controller;

import edu.java.spring.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;

@Controller
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping(value = "student/add", method = RequestMethod.GET)
    public ModelAndView add() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("student.form");
        return new ModelAndView("student.form", "command", new Student());
    }

    @RequestMapping(value = "student/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("command") Student student, BindingResult result) throws SQLException {
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("student.form", "command", student);
            model.setViewName("student.form");
            model.addObject("errors", result);
            return model;
        }

        if (student.getId() > 0) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("student.list");
            studentDAO.update(student);
            return new ModelAndView("redirect:/student/list");
        } else {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("view-student.view");
            mv.addObject("stu", student);
            studentDAO.insert(student);
            return new ModelAndView("redirect:/student/list");
        }
    }

    @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id) {
        studentDAO.delete(Integer.parseInt(id));
        return "redirect:/student/list";
    }

    @RequestMapping(value = "/student/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id) {
        Student student = studentDAO.get(id);
        return new ModelAndView("student.form", "command", student);
    }

    @RequestMapping(value = "student/edit/save", method = RequestMethod.POST)
    public String saveEdit() {
        return "forward:/student/save";
    }

    @RequestMapping(value = "student/json/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody Student viewJson(@PathVariable int id) {
        return studentDAO.get(id);
    }

    @RequestMapping(value = "student/list", method = RequestMethod.GET)
    public ModelAndView listStudents(@RequestParam(value = "q", required = false) String query) {
        ModelAndView model = new ModelAndView();
        if (query == null) {
            model.setViewName("student.list");
            model.addObject("students", studentDAO.list());
            return model;
        } else {
            model.setViewName("student.list");
            model.addObject("students", studentDAO.listStudent(query));
            return model;
        }
    }

    @RequestMapping(value = "student/list1", method = RequestMethod.GET)
    public ModelAndView listNew(@RequestParam(value = "q", required = false) String query) {
        ModelAndView model = new ModelAndView();
        if (query == null) {
            model.setViewName("StudentList");
            model.addObject("students", studentDAO.list());
            return model;
        } else {
            model.setViewName("StudentList");
            model.addObject("students", studentDAO.listStudent(query));
            return model;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/student/list1";
    }

    private Path getImageFile(HttpServletRequest request, int id){
        ServletContext servletContext=request.getSession().getServletContext();
        String diskPath=servletContext.getRealPath("/");
        File folder=new File(diskPath+ File.separator+"avatar"+File.separator);
        folder.mkdirs();
        return new File(folder,String.valueOf(id)+".jpg").toPath();
    }
    @RequestMapping(value = "/student/avatar/save",method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("file")MultipartFile file,int  id,HttpServletRequest request){
        if (file.isEmpty()) return "student.error";
        Path avatarFile = getImageFile(request,id);
        try {
            Files.write(avatarFile,file.getBytes(), StandardOpenOption.CREATE);
            byte[] bytes = file.getBytes();
            System.out.println("found ---->"+bytes.length);
            return "redirect:/student/list";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping(value = "/student/avatar/{id}",method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable(value = "id")  Integer id,HttpServletRequest request) throws IOException {
        ByteArrayOutputStream byteOutput=new ByteArrayOutputStream();
        if(id!=null){
            Path avatarPath=getImageFile(request,id);
            if(Files.exists(avatarPath)){
                byteOutput.write(Files.readAllBytes(avatarPath));
            }
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(byteOutput.toByteArray(), headers, HttpStatus.CREATED);
    }

}
