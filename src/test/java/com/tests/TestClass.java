package com.tests;

import com.base.BaseUtil;
import org.testng.annotations.Test;

public class TestClass extends BaseUtil {

    @Test
    public void justASmallTest() {
        driver.navigate().to("https://www.google.com");
    }

}
