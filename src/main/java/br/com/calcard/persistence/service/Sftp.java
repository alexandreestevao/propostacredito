package br.com.calcard.persistence.service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileInputStream;

public class Sftp {

    public void Upload(String localfile) {
        String SFTPHOST = "example.com";
        int SFTPPORT = 22;
        String SFTPUSER = "user";
        String SFTPPASS = "pass";
        String SFTPWORKINGDIR = "/var/";

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            File f = new File(localfile);
            channelSftp.put(new FileInputStream(f), f.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(channelSftp != null) {
                channelSftp.disconnect();
            }
            if(session != null) {
                session.disconnect();
            }
        }

    }

}
