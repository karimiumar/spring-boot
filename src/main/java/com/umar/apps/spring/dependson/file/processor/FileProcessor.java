package com.umar.apps.spring.dependson.file.processor;

import com.umar.apps.spring.dependson.shared.File;

public class FileProcessor {

    File file;

    public FileProcessor(File file) {
        this.file = file;

        if(this.file.getText().contains("write") || this.file.getText().contains("read")) {
            this.file.setText("processed");
        }
    }
}
