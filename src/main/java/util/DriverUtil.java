package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class DriverUtil {


    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) {

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        try {
            FileUtils.copyFile(SrcFile, DestFile);
            System.out.println("Screenshot File Path: " + DestFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
