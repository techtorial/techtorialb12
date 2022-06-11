package TESTNG;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "NameInformation")
    public Object[][] getData() {
        return new Object[][]{
                {"ahmet", "baldir", "ahmet baldir"},
                {"ahmad", "mansur", "ahmad mansur"},
                {"brulai", "darm", "brulai darm"},
                {"berkay", "polat", "berkay polat"},
                {"Elena", "Furtuna", "Elena Furtuna"}
        };
    }

    @DataProvider(name = "SentrifugoLogin")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"EM01", "sentrifugo"},
                {"EM02", "sentrifugo"},
                {"EM03", "sentrifugo"},
                {"EM04", "sentrifugo"},
                {"EM05", "sentrifugo"},
                {"EM06", "sentrifugo"},
                {"EM07", "sentrifugo"},
                {"AGCY8", "sentrifugo"},
                {"US09", "sentrifugo"},
        };
    }
}
