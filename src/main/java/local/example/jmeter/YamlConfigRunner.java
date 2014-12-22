package local.example.jmeter;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.yaml.snakeyaml.Yaml;

public class YamlConfigRunner {
  
  public static Configuration load(String path) throws Exception {
    if (path == null) {
      throw new IllegalArgumentException("set path");
    }
    Yaml yaml = new Yaml();
    Configuration config = null;
    try (InputStream in =  YamlConfigRunner.class.getClassLoader().getResourceAsStream(path);
        
        //Files.newInputStream(Paths.get(path))
            ) {
      config = yaml.loadAs(in, Configuration.class);      
    } 
    return config;
    
  }
}
