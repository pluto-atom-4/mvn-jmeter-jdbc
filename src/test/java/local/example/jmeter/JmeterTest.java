package local.example.jmeter;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



/**
 * Unit test for simple App.
 */
public class JmeterTest {
  
  StandardJMeterEngine jmeter = new StandardJMeterEngine();

  @Test(priority = 10, enabled = false)
  public void verifyConfiguration() throws Exception {
    Configuration config = YamlConfigRunner.load("_temp_config.yaml");
    Assert.assertNotNull(config);
    Reporter.log(config.toString());
      }
  
  @Test(priority = 20)
  public void verifyTestPlan() throws Exception {
    Configuration config = YamlConfigRunner.load("_temp_config.yaml");

    // Initialize Properties, logging, locale, etc.
    JMeterUtils.loadJMeterProperties(config.getJmeterProperties());
    JMeterUtils.setJMeterHome(config.getJmeterHome());
    JMeterUtils.initLogging();
    JMeterUtils.initLocale();

    // Initialize JMeter SaveService
    SaveService.loadProperties();

//    HashTree testPlanTree = null;
//    // Load existing .jmx Test Plan
//    try (InputStream in =  new FileInputStream(config.getJmxFilePath())) {
//      testPlanTree = SaveService.loadTree(in);
//      in.close();
//    }     

    FileInputStream in = new FileInputStream(config.getJmxFilePath());
    HashTree testPlanTree = SaveService.loadTree(in);
    in.close();    
    // Run JMeter Test
    jmeter.configure(testPlanTree);
    jmeter.run();
  }
}
