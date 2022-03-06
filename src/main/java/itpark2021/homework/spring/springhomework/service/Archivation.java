package itpark2021.homework.spring.springhomework.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Archivation {

    void zip(String source) throws IOException;
    void unzip(String source);
}