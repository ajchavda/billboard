package com.hwi.team1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author subha
 */

public interface BillboardService {
    public boolean validateBillboard(
            String file_name,
            String latitutde,
            String longitude,
            String direction);
}
