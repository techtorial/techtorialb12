package TESTNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("FirstName")
    @Test
    public void test(String name){
        System.out.println(name);
    }
    @Parameters({"countryName","stateName","zipCode"})
    @Test
    public void test2(String country,String state,String zipCode){
        System.out.println(country);
        System.out.println(state);
        System.out.println(zipCode);

    }
    @Parameters({"countryName","stateName","zipCode"})
    @Test
    public void test3(String state,String country,String zipCode){
        System.out.println(country);//Turkey -->ANKARA
        System.out.println(state);
        System.out.println(zipCode);

    }
}
