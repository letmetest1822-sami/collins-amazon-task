package com.collins.step_definitions;

import com.collins.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

//    @Before()
//    public void setUp(){
//    }

    @After()
    public void teardown(){
        Driver.closeDriver();
    }
}
