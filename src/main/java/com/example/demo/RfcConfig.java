package com.example.demo;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/2/18 17:41.
 *
 * @author Ethan
 * <p>
 * java.lang.IllegalArgumentException:
 *  Invalid character found in the request target. The valid characters are defined in RFC 7230 and RFC 3986.
 * </p>
 */
@Component
public class RfcConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addConnectorCustomizers(connector -> connector.setAttribute("relaxedQueryChars", "{}[]|"));
    }
}