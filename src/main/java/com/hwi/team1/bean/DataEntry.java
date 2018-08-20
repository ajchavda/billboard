package com.hwi.team1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author subha
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataEntry {

    private MultipartFile file;
    private String latitutde;
    private String longitude;
    private String direction;
}
