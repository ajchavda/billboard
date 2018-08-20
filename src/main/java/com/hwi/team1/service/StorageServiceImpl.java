/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwi.team1.service;

import com.hwi.team1.bean.Message;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author subha
 */
@Service
public class StorageServiceImpl implements StorageService{

    @Override
    public String store(String file_name, MultipartFile file) {
        if(file == null) return "FAIL_NULL";
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream
                        = new BufferedOutputStream(new FileOutputStream(new File(file_name)));
                stream.write(bytes);
                stream.close();
                return "SUCCESS";
            } catch (Exception e) {
                return "FAIL_GENERIC";
            }
        } else {
            return "FAIL_EMPTY";
        }
    }
    
    @Override
    public String getDefaultLocation(){
        return System.getProperty("user.dir");
    }
    
}
