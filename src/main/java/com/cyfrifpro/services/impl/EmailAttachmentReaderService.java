package com.cyfrifpro.services.impl;
import jakarta.mail.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cyfrifpro.util.CustomMultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Properties;

@Service

public class EmailAttachmentReaderService {

    public MultipartFile fetchLatestEmailAttachment() throws Exception {
        Properties properties = new Properties();
        properties.put("mail.imap.host", "imap.hostinger.com");
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.ssl.enable", "true");

        Session emailSession = Session.getInstance(properties);
        Store store = emailSession.getStore("imap");
        store.connect("imap.hostinger.com", "helpdesk@cyfrif.com", "Helpdesk@2025");

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        for (int i = messages.length - 1; i >= 0; i--) {
            Message message = messages[i];
            if (message.getSubject().contains("Account statement")) { // Optional: Filter based on subject
                Multipart multipart = (Multipart) message.getContent();
                for (int j = 0; j < multipart.getCount(); j++) {
                    BodyPart bodyPart = multipart.getBodyPart(j);
                    if (Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
                        // Read attachment and convert to MultipartFile
                        InputStream is = bodyPart.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = is.read(buffer)) != -1) {
                            baos.write(buffer, 0, bytesRead);
                        }
                        return new CustomMultipartFile(
                            bodyPart.getFileName(),
                            bodyPart.getFileName(),
                            bodyPart.getContentType(),
                            baos.toByteArray()
                        );
                    }
                }
            }
        }
        throw new Exception("No attachment found in the latest emails");
    }
}
