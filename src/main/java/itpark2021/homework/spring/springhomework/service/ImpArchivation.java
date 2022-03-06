package itpark2021.homework.spring.springhomework.service;

import lombok.Data;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service("activation")
@Data
public class ImpArchivation implements Archivation{

   private MessageSource messageSource;
    private Locale locale;

    @Override
    public void zip(String source) throws IOException {
        String sourceFile = source + "/test.txt";
        FileOutputStream fos = new FileOutputStream(source +"/compressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();

        System.out.println(messageSource.getMessage("resultZip", null,this.locale));

    }

    @Override
    public void unzip(String source) {
    }


}
