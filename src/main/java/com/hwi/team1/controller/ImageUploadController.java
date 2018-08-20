package com.hwi.team1.controller;

import com.hwi.team1.bean.Message;
import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.hwi.team1.service.*;
/**
 *
 * @author subha
 */
@RestController
public class ImageUploadController {
    
    @Autowired
    StorageService storageService;
    
    @Autowired
    BillboardService billboardService;
    
    
    @GetMapping("/ping")
    public @ResponseBody Message ping(){
        return new Message(storageService.getDefaultLocation());
    }

    @PostMapping("/upload")
    public @ResponseBody Message handleFileUpload(
            @RequestParam("file_name") String file_name, 
            @RequestParam("file") MultipartFile file,
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude,
            @RequestParam("direction") String direction) {
        
        if(storageService.store(file_name, file).equals("SUCCESS")){
            
            if(billboardService.validateBillboard(
                    file_name, latitude, longitude, direction
            )){
                
                return new Message("SUCCESS");
                
            }else{
                return new Message("FAIL_VLIDATE");
            }
            
            
        }else{
            return new Message("FAIL_IMAGE_STORE");
        }
        
    }
    /*
    @PostMapping("/upload_json")
    public @ResponseBody Message handleFileUploadJSON(
            @RequestParam("file")) {
        
        if(storageService.store(file).equals("SUCCESS")){
            
            if(billboardService.validateBillboard(
                    latitutde, longitude, direction
            )){
                
                // TODO: Add async response to user
                
                return new Message("SUCCESS");
                
            }else{
                return new Message("FAIL_GEN_LIST");
            }
            
            
        }else{
            return new Message("FAIL_IMAGE_STORE");
        }
        
    }
*/
    
    
}
