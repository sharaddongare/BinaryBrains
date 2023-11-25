package com.gui.fileUtility;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.draw.geom.Path;
import org.zeroturnaround.zip.ZipUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class S3FileUpload {

     public static void main(String[] args) throws IOException, InterruptedException {


         System.out.println("Inside main");
         String AWS_ACCESS_KEY="AKIA3VRUSMVU5DE5JDN7";//System.getenv("AWS_ACCESS_KEY")
         String AWS_SECRET_KEY="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";//System.getenv("AWS_SECRET_KEY")
         String AWS_BUCKET="demo-automation-logs-reports";
         Regions AWS_REGIONS=Regions.AP_SOUTH_1;

         AWSCredentials credentials=new BasicAWSCredentials(AWS_ACCESS_KEY,AWS_SECRET_KEY);
         AmazonS3 s3client= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                 .withRegion(AWS_REGIONS).build();
         String curlTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy-HHmm"));
         System.out.println(curlTime);
         String bucketExist=String.valueOf(s3client.doesBucketExistV2(AWS_BUCKET));
         System.out.println(bucketExist);

         //String zipPath="target/ReportZip"+curlTime;
         String zipPath="target/ReportZip";
         File f1= new File(zipPath);
         if(!f1.exists()) {
             boolean bool = f1.mkdir();
             if (bool) {
                 System.out.println("Folder created");
             } else {
                 System.out.println("Error Occure");
             }
         }
         try {
             FileUtils.copyDirectory(new File("target/allure-results"), new File(zipPath));
         } catch (IOException e) {
             e.printStackTrace();
         }

/*         LocalDate date = LocalDate.now();
         String todayDate=date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
         String logFileName="target/application-123.log";*/
         try {
             FileUtils.copyDirectory(new File("target/logs"), new File(zipPath));
         } catch (IOException e) {
             e.printStackTrace();
         }

         File f2= new File("target/Report.zip");
         if(!(f2.exists())){
             ZipUtil.pack(new File("target/ReportZip"), new File("target/Report.zip"));
         }

         if(bucketExist.equals("true")){
            String fileName="execution-reports-"+curlTime;
             String filePath="target/Report.zip";
             s3client.putObject("demo-automation-logs-reports",fileName,new File(filePath));

         }


     }

    }

