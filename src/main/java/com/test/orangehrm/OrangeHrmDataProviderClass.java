package com.test.orangehrm;

import org.testng.annotations.DataProvider;

public class OrangeHrmDataProviderClass {

    @DataProvider(name = "EmployeeCreation")
    public Object[][] getEmployeeData(){
        return new Object[][]{
                {"ESS","Anthony Nolan","ahmet156","Disabled","12345678","12345678"},
                {"Admin","Ananya Dash","ahmet152","Enabled","98765432","98765432"},
                {"ESS","Fiona Grace","ahmet151","Disabled","12325678","12325678"}
        };
    }
}
