package com.umar.apps.spring.dependson.file.reader;

import com.umar.apps.spring.dependson.shared.File;

public class FileReader {

    public FileReader(File file) {
        file.setText("read");
    }

    public void readFile() {

    }
}
