/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwi.team1.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author subha
 */
public interface ProcessRunnerService {
    public String run(String processName, String input);
}
