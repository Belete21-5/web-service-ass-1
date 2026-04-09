package com.ShapeTool.shape.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurer;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

@EnableWs
@Configuration
public class WebServiceConfig implements WsConfigurer {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "shapetool")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema shapesSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("ShapeToolPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://woldia.edu/shapetool");
        wsdl.setSchema(shapesSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema shapesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/shapes.xsd"));
    }

    @Bean
    public PayloadValidatingInterceptor validatingInterceptor() {
        PayloadValidatingInterceptor interceptor = new PayloadValidatingInterceptor();
        interceptor.setValidateRequest(true);
        interceptor.setValidateResponse(true);
        interceptor.setXsdSchema(shapesSchema());
        return interceptor;
    }

    // ✅ Correct interceptor registration
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(validatingInterceptor());
    }
}