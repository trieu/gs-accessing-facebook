package vidzeo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@ComponentScan
@Import({
    DispatcherServletAutoConfiguration.class,
    EmbeddedServletContainerAutoConfiguration.class,
    ErrorMvcAutoConfiguration.class,
    HttpEncodingAutoConfiguration.class,
    HttpMessageConvertersAutoConfiguration.class,
    JacksonAutoConfiguration.class,
    JmxAutoConfiguration.class,
    MultipartAutoConfiguration.class,
    ServerPropertiesAutoConfiguration.class,
    PropertyPlaceholderAutoConfiguration.class,    
    WebMvcAutoConfiguration.class,
    WebSocketAutoConfiguration.class,
    FreeMarkerAutoConfiguration.class
})
public class VidzeoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {    	
        SpringApplication.run(VidzeoApplication.class, args);
    }
    
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        // This can be done here or as the last step in the method
//        // Doing it in this order will initialize the Spring
//        // Framework first, doing it as last step will initialize
//        // the Spring Framework after the Servlet configuration is 
//        // established
//        super.onStartup(servletContext);
//
//        // This will set to use COOKIE only
//        servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
//        // This will prevent any JS on the page from accessing the
//        // cookie - it will only be used/accessed by the HTTP transport
//        // mechanism in use
//        SessionCookieConfig sessionCookieConfig= servletContext.getSessionCookieConfig();
//        sessionCookieConfig.setHttpOnly(true);
//        servletContext.getSessionCookieConfig().setName("vzsession");
//    }
    

} 