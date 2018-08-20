/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwi.team1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author subha
 */

public interface StorageService {
    public String getDefaultLocation();
    public String store(String file_name, MultipartFile file);
}
