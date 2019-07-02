package selenium.pokemon.quiz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(FileHandler.class);

    private static String mainResourcesPath;
    private static String testResourcesPath;

    public FileHandler() {
        String resourcesPath = System.getProperty("user.dir") + "/src/%s/resources/";
        mainResourcesPath = String.format(resourcesPath, "main");
        testResourcesPath = String.format(resourcesPath, "test");
    }

    private File getFileOf(String fileName, boolean testCase) {
        String resourcesPath = testCase ? testResourcesPath : mainResourcesPath;
        return new File(resourcesPath + fileName);
    }

    public String getContent(String fileName, boolean testEnvironment) {
        File file = getFileOf(fileName, testEnvironment);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            LOGGER.error("No se pudo leer el archivo " + fileName, e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                LOGGER.error("No se pudo cerrar el archivo " + fileName, e);
            }
        }
        return null;
    }


}
