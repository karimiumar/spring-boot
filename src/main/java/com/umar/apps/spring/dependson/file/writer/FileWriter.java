package com.umar.apps.spring.dependson.file.writer;

import com.umar.apps.spring.dependson.shared.File;

public class FileWriter {

    public FileWriter(File file) {
        file.setText("write");
    }

    public void writeFile() {}
}
