package commons;

import java.io.File;

public class GlobalConstants {
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final long LONG_TIMEOUT = 50 ;
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator +  "uploadFiles" + File.separator;
    public static final String RESOURCE_PATH = RELATIVE_PROJECT_PATH + File.separator +  "resources" + File.separator;
    public static final long SHORT_TIMEOUT = 5;
}
