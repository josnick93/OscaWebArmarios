package org.oscasistemas.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    public static boolean useSerWebNav=true;

    // Static Resource Config
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Css resource.
        registry.addResourceHandler("/css/**") //
                .addResourceLocations("/WEB-INF/css/").setCachePeriod(31556926);

        // jsp resource.
        registry.addResourceHandler("/js/**") //
                .addResourceLocations("/WEB-INF/js/").setCachePeriod(31556926);

        // bootstrap resource.
        registry.addResourceHandler("/bootstrap/**") //
                .addResourceLocations("/WEB-INF/bootstrap/").setCachePeriod(31556926);

        // bootstrap resource.
        registry.addResourceHandler("/jquery/**") //
                .addResourceLocations("/WEB-INF/jquery/").setCachePeriod(31556926);

        // bootstrap resource.
        registry.addResourceHandler("/fonts/**") //
                .addResourceLocations("/WEB-INF/fonts/").setCachePeriod(31556926);


        // bootstrap resource.
        registry.addResourceHandler("/pages/**") //
                .addResourceLocations("/WEB-INF/pages/").setCachePeriod(31556926);

        registry.addResourceHandler("/img/**") //
                .addResourceLocations("/WEB-INF/img/").setCachePeriod(31556926);

        registry.addResourceHandler("/cajas/**") //
                .addResourceLocations("/WEB-INF/cajas/").setCachePeriod(31556926);

        registry.addResourceHandler("/wsdl/**") //
                .addResourceLocations("com/dynamics/webServices/wsdl/").setCachePeriod(31556926);



    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
