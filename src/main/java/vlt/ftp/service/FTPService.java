package vlt.ftp.service;

import java.io.File;

import vlt.ftp.exceptions.FTPErrors;

public interface FTPService {
    void connectToFTP(String host, String user, String pass) throws FTPErrors;
    void uploadFileToFTP(File file, String ftpHostDir , String serverFilename) throws FTPErrors;
    void downloadFileFromFTP(String ftpRelativePath, String copytoPath) throws FTPErrors;
    void disconnectFTP() throws FTPErrors;

}
