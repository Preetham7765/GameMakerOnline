package com.gamemaker.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gamemaker.service.ScoreBoardService;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private ScoreBoardService scoreBoardService_;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
    	if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String path = this.getClass().getResource("/static").getPath() + "/" +file.getOriginalFilename(); 

            Files.write(Paths.get(path), bytes);
            
            //save the game name in the DB
            scoreBoardService_.saveGame(file.getOriginalFilename());
            
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
    
    @GetMapping("/download")
    public void downloadFile(HttpServletRequest request,
    						 HttpServletResponse response) throws IOException {
    	String fileName = request.getParameter("fileName");
    	File file = new ClassPathResource("static/" + fileName + ".ser").getFile();
    	response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".ser\"");
    	InputStream in = new FileInputStream(file);
    	IOUtils.copy(in, response.getOutputStream());
    	response.flushBuffer();
    }
}
