package TESTNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int getMulti(int number1,int number2){
        return number1*number2;
    }

    @Test
    public void validateMultiplication(){
        int actualResult=getMulti(-2,4);
        int expectedResult=-6;
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void validateZero(){
        int actualResult=getMulti(0,3);
        int expectedResult=5;
        Assert.assertEquals(actualResult,expectedResult,"it is testing for validateZero");
    }
}
