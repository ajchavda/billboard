/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwi.team1.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author subha
 */
@Service
public class BillboardServiceImpl implements BillboardService {

    @Autowired
    ProcessRunnerService processRunnerService;

    @Autowired
    StorageService storageService;

    @Override
    public boolean validateBillboard(
            String file_name,
            String latitude,
            String longitude,
            String direction) {

        // TODO: Direction processing
        /*
        try {
            FileWriter fw = new FileWriter(storageService.getDefaultLocation() + "\\gps.txt");
            fw.write(latitutde + '\n'
                    + longitude + '\n'
                    + direction);
            fw.close();
        } catch (IOException ex) {
            return false;
        }
         */
        String inp = latitude + '\n'
                + longitude + '\n'
                + direction + '\n'
                + file_name + '\n';
        System.out.println(inp);
        String status = processRunnerService.run("C:\\ProgramData\\Anaconda3\\python temp2.py", inp);
        
        if(status.equals("ERR") || status.equals("None")) return false;
        else return true;
    }

}
