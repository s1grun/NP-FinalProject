//package com.example.demo.config;
//
//import nz.net.ultraq.thymeleaf.LayoutDialect;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.resource.PathResourceResolver;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//
//@EnableTransactionManagement // Needed for @Transactional attribute outside
//// repositories.
//@EnableWebMvc
//@Configuration
//public class Config implements WebMvcConfigurer, ApplicationContextAware {
//    private ApplicationContext applicationContext;
//
//    /**
//     * @param applicationContext The application context used by the running
//     *                           application.
//     */
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    @Bean(name = "ListTemplateEngine")
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        templateEngine.addDialect(new LayoutDialect());
//        return templateEngine;
//    }
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver =
//                new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(this.applicationContext);
//        templateResolver.setPrefix("classpath:/web-root/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        templateResolver.setCacheable(true);
//        return templateResolver;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        int cachePeriodForStaticFilesInSecs = 1;
//        String rootDirForStaticFiles = "classpath:/web-root/resources/";
//
//        registry.addResourceHandler("/**")
//                .addResourceLocations(rootDirForStaticFiles)
//                .setCachePeriod(cachePeriodForStaticFilesInSecs)
//                .resourceChain(true).addResolver(new PathResourceResolver());
//    }
//}
//
