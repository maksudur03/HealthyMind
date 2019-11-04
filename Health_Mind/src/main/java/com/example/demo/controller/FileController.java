package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.UploadFileResponse;
import com.example.demo.service.FileStorageService;

@RestController
public class FileController {
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@CrossOrigin
	@PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
	    
	
		
        String fileName = fileStorageService.storeFile(file); 
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
       
        
        return new UploadFileResponse(fileName, fileName,
                file.getContentType(), file.getSize());
    }
	
	@CrossOrigin
	@PostMapping("/uploadMultipleFile")
	public List<UploadFileResponse> uploadSlider(@RequestPart("files")MultipartFile[] files){
		
		List<UploadFileResponse> list = Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
		
		return list;
	}
}
