package com.project.hooks;

import java.io.IOException;

import com.project.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {



    @Before
    public void setup() throws IOException{
        DriverManager.initiateBrowser();
    }

    @After
    public void teardown(){
        DriverManager.quitDriver();
    }
    
}
