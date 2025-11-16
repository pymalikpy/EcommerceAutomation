package org.nopcommerce.com.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    private static WebDriver driver;

    public ScreenshotUtility(WebDriver driver){
        this.driver=driver;
    }

    public static String takeScreenshot(WebDriver driver, String screenshotName){
        String timestamp = new SimpleDateFormat("yyyyMMDD_HHmmss").format(new Date());
        String destDir = System.getProperty("user.dir")+"/screenshots/";
        String fileName = screenshotName + "_" + timestamp+".png";
        String destPath = destDir + fileName;
        try{
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(destPath);
            FileUtils.copyFile(src,destFile);
            System.out.println("Screenshot saved at: " + destPath);
            return destPath;
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
            return null;
        }

    }
}
