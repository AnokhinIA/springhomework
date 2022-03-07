package lesson29.SpringShell.service;

import lombok.Data;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


import java.io.*;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@ShellComponent
@Data
public class ImpArchivation implements Archivation {

    @Autowired
    private MessageSource messageSource;
    private Locale locale;
    final private String zipFilePath = "src/main/resources/archives";
    final private String pathForUnzipFile = "src/main/resources/archives";

    @ShellMethod("Zip file")
    @Override
    public void zip(String fileName) {

        File fileToZip = new File(this.zipFilePath + "/" + fileName);
        if (!fileToZip.exists()) throw new IllegalArgumentException("Файл не найден: " + fileToZip);
        try {
            FileOutputStream fos = new FileOutputStream(this.zipFilePath + "/compressed.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();
            fos.close();
            System.out.println(this.messageSource.getMessage("resultZip", null, this.locale) + this.zipFilePath + "/compressed.zip");
        } catch (IOException e) {
            System.out.println(this.messageSource.getMessage("failResultZip", null, this.locale));
        }

    }

    @ShellMethod("Unzip file")
    @Override
    public void unzip(@ShellOption(defaultValue = "compressed.zip") String source) {

        File fileForUnzip = new File(this.zipFilePath + "/" + source);
        File pathForUnzipFile = new File(this.pathForUnzipFile);
        if (!fileForUnzip.exists()) throw new IllegalArgumentException("Файл не найден: " + fileForUnzip);
        ZipFile zipFile = new ZipFile(fileForUnzip);
        try {
            zipFile.extractAll(String.valueOf(pathForUnzipFile));
            System.out.println(this.messageSource.getMessage("resultUnzip", null, this.locale));
        } catch (ZipException e) {
            System.out.println(this.messageSource.getMessage("failResultUmZip", null, this.locale));
        }
    }

    @ShellMethod("List files")
    public void list() {
        File listFiles = new File(this.pathForUnzipFile);
        File[] files = listFiles.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    @ShellMethod(value = "Change language", key = "lang")
    public void changeLanguage(String language) {
        switch (language) {
            case "ru":
                this.locale = Locale.forLanguageTag(language);
                break;
            case "en":
                this.locale = Locale.forLanguageTag(language);
                break;
            default:
        }


    }

}
