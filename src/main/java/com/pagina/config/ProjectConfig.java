package com.pagina;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("registro/nuevo");
    }

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((requests) -> requests
            // Rutas accesibles por ADMINISTRADOR, PROFESOR, ESTUDIANTE
            .requestMatchers("/grupo/vergrupos", "/curso/vercursos").hasAnyRole("ADMINISTRADOR", "PROFESOR", "ESTUDIANTE")
            
            // Rutas accesibles solo por ADMINISTRADOR
            .requestMatchers("/profesor/verprofesores", "/profesor/postulaciones", "/usuario/listado").hasRole("ADMINISTRADOR")
            
            // Rutas accesibles por ADMINISTRADOR y PROFESOR
            .requestMatchers("/estudiante/verEstudiantes").hasAnyRole("ADMINISTRADOR", "ESTUDIANTE", "PROFESOR")
            .requestMatchers("/estudiante/modificar/**").hasAnyRole("ADMINISTRADOR", "PROFESOR")
            .requestMatchers("/profesor/modificar/**").hasAnyRole("ADMINISTRADOR")
            .requestMatchers("/profesor/aprobar/**", "/profesor/rechazar/**").hasRole("ADMINISTRADOR")
            
            // Rutas accesibles solo por PROFESOR
            .requestMatchers("/profesor/**").hasRole("PROFESOR")
            
            // Rutas accesibles solo por ESTUDIANTE, excepto rutas restringidas
            .requestMatchers("/estudiante/**").hasRole("ESTUDIANTE")
            
            // Rutas específicas accesibles solo por ADMINISTRADOR y PROFESOR, excluyendo ESTUDIANTE
            .requestMatchers("/grupo/eliminar/2", "/grupo/modificar/2", "/grupo/agregar").hasAnyRole("ADMINISTRADOR", "PROFESOR")
            
            // Rutas accesibles por ADMINISTRADOR y PROFESOR, excluyendo a ESTUDIANTE
            .requestMatchers("/calificacion/modificar/**").hasAnyRole("ADMINISTRADOR", "PROFESOR")
            
            // Permitir acceso a cualquier otra ruta sin autenticación
            .anyRequest().permitAll()
        )
        .formLogin((form) -> form
            .loginPage("/login").permitAll()
        )
        .logout((logout) -> logout.permitAll());

    return http.build();
}







    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("juan")
                .password(passwordEncoder().encode("123"))
                .roles("ADMINISTRADOR")
                .build();
        UserDetails profesor = User.builder()
                .username("rebeca")
                .password(passwordEncoder().encode("456"))
                .roles("PROFESOR")
                .build();
        UserDetails estudiante = User.builder()
                .username("pedro")
                .password(passwordEncoder().encode("789"))
                .roles("ESTUDIANTE")
                .build();
        return new InMemoryUserDetailsManager(admin, profesor, estudiante);
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
