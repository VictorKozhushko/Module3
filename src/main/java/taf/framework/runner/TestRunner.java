package taf.framework.runner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.testng.TestNG;
import taf.framework.loger.Log;

import java.util.Collections;

import java.util.Collections.*;

public class TestRunner {

    public static TestNG createTestNG(){
        TestNG testNG = new TestNG();
        testNG.setTestSuites(Collections.singletonList("./src/main/resources/testng.xml"));
        return testNG;
    }

    public static void main(String[] args) {
        Log.info("Parse cli");
        parseCli(args);
        Log.info("Start app");
        createTestNG().run();
        Log.info("Finish app");
    }

    private static void parseCli(String[] args) {
        Log.info("Pasre clis using JCommander");
        JCommander jCommander = new JCommander(Parameters.instance());
        try {
            jCommander.parse(args);
        } catch(ParameterException e) {
            Log.error(e.getMessage());
            System.exit(1);
        }
        if (Parameters.instance().isHelp()){
            jCommander.usage();
            System.exit(0);
        }
    }
}
