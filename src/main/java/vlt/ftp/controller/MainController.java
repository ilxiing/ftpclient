package vlt.ftp.controller;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vlt.ftp.exceptions.FTPErrors;
import vlt.ftp.service.FTPService;
@Controller
public class MainController {
	@Autowired
    private FTPService ftpService;

    @RequestMapping( value = "/upload", method = RequestMethod.GET)
    public void uploadExample(){
        try {

              ftpService.connectToFTP("192.168.1.102","a","a");
              ftpService.uploadFileToFTP(new File("/home/yoandypv/img.png"),"uploads/","foto.png");

        } catch (FTPErrors ftpErrors) {
            System.out.println(ftpErrors.getMessage());
        }
    }
    
    @RequestMapping( value = "/download", method = RequestMethod.GET)
    public void downloadFile(){
        try {

              ftpService.connectToFTP("192.168.1.102","a","a");
              ftpService.downloadFileFromFTP("uploads/foto.png","/home/kaka.png");

        } catch (FTPErrors ftpErrors) {
            System.out.println(ftpErrors.getMessage());
        }
    }
}
