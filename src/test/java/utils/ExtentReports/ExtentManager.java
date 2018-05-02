package utils.ExtentReports;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            
            String userHome = System.getProperty("user.home");
    		String outputFolder = userHome + File.separator + "test-output";
    		File folder = new File(outputFolder);
    		
    		if (!folder.exists()) {
    			folder.mkdir();
    		}
    		extent = new ExtentReports(outputFolder + "/LuaReports.html", true);
        }
        return extent;
    }
}
