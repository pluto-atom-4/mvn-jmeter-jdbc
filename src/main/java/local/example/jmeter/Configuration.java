package local.example.jmeter;

/**
 * Hello world!
 *
 */
public class Configuration 
{
  String basePath;
  String jmeterProperties;
  String jmeterHome;
  String jmxFilePath;

  public String getBasePath() {
    return basePath;
  }
  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }
  public String getJmeterProperties() {
    return jmeterProperties;
  }
  public void setJmeterProperties(String jmeterProperties) {
    this.jmeterProperties = jmeterProperties;
  }
  public String getJmeterHome() {
    return jmeterHome;
  }
  public void setJmeterHome(String jmeterHome) {
    this.jmeterHome = jmeterHome;
  }
  public String getJmxFilePath() {
    return jmxFilePath;
  }
  public void setJmxFilePath(String jmxFilePath) {
    this.jmxFilePath = jmxFilePath;
  }
  
  @Override
  public String toString() {
    return "Configuration [basePath=" + basePath + ", jmeterProperties=" + jmeterProperties
        + ", jmeterHome=" + jmeterHome + ", jmxFilePath=" + jmxFilePath + "]";
  }


}
