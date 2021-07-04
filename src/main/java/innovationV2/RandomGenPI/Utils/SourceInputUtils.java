package innovationV2.RandomGenPI.Utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SourceInputUtils {

    public String parseFileToString(String fileName) {
        InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        String resource = null;
        try {
            resource = IOUtils.toString(resourceStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resource;
    }
}
