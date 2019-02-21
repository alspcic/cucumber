package util;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

    public static int fileNo=1;

    public static File saveScreenshot(WebDriver driver, String scenario) {

        File scrFile = null;
        Date date=new Date();

        String dirPath="screenShot/"+(new SimpleDateFormat("dd.MM.yy")).format(date).toString();
        String time=(new SimpleDateFormat("HH:mm")).format(date).replace(":", "_").replace(" ", "_").toString();

        new File(dirPath).mkdirs();


        try {
            scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.moveFile(scrFile, new File(dirPath+"/"+time+"_"+ scenario +"_" + fileNo + ".png"));
            fileNo=fileNo+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scrFile;
    }
}
