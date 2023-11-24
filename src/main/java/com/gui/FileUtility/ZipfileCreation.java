package com.gui.FileUtility;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ZipfileCreation {

     public static void main(String[] args) throws IOException {

         File srcDir = new File("/target/allure-result2");
         if (!srcDir.exists()){
             srcDir.mkdirs();
         }

         File trgDir = new File("/target/allure-result");
         //File srcDir = new File("/target/allure-result2");

         FileUtils.copyDirectory(srcDir, trgDir);

    }
}
