/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwi.team1.service;

import java.io.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author subha
 */
@Service
public class ProcessRunnerServiceImpl implements ProcessRunnerService {

    @Override
    public String run(String processName, String input) {
        try {
            //System.out.println(processName);
            Runtime run = Runtime.getRuntime();
            Process proc = run.exec(processName);

            //System.out.println(proc);
            //proc.getOutputStream().write(input.toCharArray());
            String op = "";

            String line;
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));

            writer.write(input);
            writer.flush();
            writer.close();

            proc.waitFor();
            
            while ((line = in.readLine()) != null) {
                if(line.length() > op.length())
                    op = line;
            }

            System.out.println("Company : " + op);
            in.close();

            if (op != null) {
                return op;
            } else {
                return "ERR";
            }
        } catch (Exception e) {

        }
        return "ERR";
    }
}
