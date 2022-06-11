package TESTNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
    //I am going to use DataProvider for this scenario because they have same implementation but different data

//    @DataProvider(name = "NameInformation")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"ahmet","baldir","ahmet baldir"},
//                {"ahmad","mansur","ahmad mansur"},
//                {"brulai","darm","brulai darm"},
//                {"berkay","polat","berkay polat"},
//                {"Elena","Furtuna","Elena Furtuna"}
//        };
//    }
    @Test(dataProvider="NameInformation",dataProviderClass = DataProviderClass.class)
    public void dataProviderTest(String firstName,String lastName,String expectedFullName){
        String fullName= firstName+" "+lastName;
        Assert.assertEquals(fullName,expectedFullName);
    }

//    @Test
//    public void dataProviderTest1(){
//        String firstName="ahmad";
//        String lastName="mansur";
//        String fullName= firstName+" "+lastName;
//        Assert.assertEquals(fullName,"ahmad mansur");
//    }
//    @Test
//    public void dataProviderTest2(){
//        String firstName="berkai";
//        String lastName="polat";
//        String fullName= firstName+" "+lastName;
//        Assert.assertEquals(fullName,"berkai polat");
//    }
//    @Test
//    public void dataProviderTest3(){
//        String firstName="Burulai";
//        String lastName="darm";
//        String fullName= firstName+" "+lastName;
//        Assert.assertEquals(fullName,"Burulai darm");
//    }
//    @Test
//    public void dataProviderTest4(){
//        String firstName="Elena";
//        String lastName="Furtuna Pinar";
//        String fullName= firstName+" "+lastName;
//        Assert.assertEquals(fullName,"Elena Furtuna Pinar");
//    }
}
