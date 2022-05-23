package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtils {
    //Browser utils is a location for the reusable methods.
    //Advantage:1-You do not need to repeat yourself.
        //      2-Less amount of code
      //        3-Less amount of time(*)
    public static void selectBy(WebElement element,String value,String methodName){
        Select select =new Select(element);

        switch (methodName){

            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available,Use text,value,or index for method name");
        }
    }

    public static String getText(WebElement element){
        return element.getText().trim();
    }


}
