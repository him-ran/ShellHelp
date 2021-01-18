/*
 This groovy scripts is to read the content of a file on a Linux System, from a Windows Environment.
 Dependencies: jsch-0.1.55.jar (available in the dependencies folder.)
*/

import com.jcraft.jsch.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;


        String user = "ubuntu";      //pass the Linux machine's Username
        String password = "12345";   //pass the Linux machine's Password
        String host = "10.127.117.235";  //Pass the Linux machine's IP
        int port = 22;
        String remoteFile = "/home/ubuntu/responsePod.txt";  //Path of the file on the Linux machine whose content you want to read

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
		  log.info session
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            log.info("Establishing Connection...");
            session.connect()
            log.info("Connection established.");            
            log.info("Crating SFTP Channel.");
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            log.info("SFTP Channel created.");

            InputStream inputStream = sftpChannel.get(remoteFile);

            try
            {
            	Scanner scanner = new Scanner(new InputStreamReader(inputStream))
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    log.info (line);
                }
            }
            catch(Exception ex)
            {
            	log.info "Exception occured:  "+ex
            }
        } catch (Exception e) {
            log.info "Exception occured "+e
        }

