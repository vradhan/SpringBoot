package com.primefaces.example;

import java.util.ArrayList;

import javax.faces.webapp.FacesServlet;

import org.primefaces.component.column.Column;
import org.primefaces.component.datatable.DataTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.primefaces.bean.DetailsBean;
import com.primefaces.bean.HelloWorld;
import com.primefaces.bean.InvestigatorSearchPmrBean;

@SpringBootApplication
@ComponentScan("com.primefaces.bean")
public class DemoApplication extends SpringBootServletInitializer{


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet facesServlet = new FacesServlet();
        return new ServletRegistrationBean(facesServlet, "*.xhtml");
    }
    
    public static void main(String args[]){
        
        ConfigurableApplicationContext cac = SpringApplication.run(DemoApplication.class, args);
        
        HelloWorld lb = cac.getBean(HelloWorld.class);
        lb.setFirstName("Vishnuradhan");
        lb.setLastName("Ravi");
        
      /*  InvestigatorSearchPmrBean investigate = cac.getBean(InvestigatorSearchPmrBean.class);
        
        createDataTable(investigate);*/
        
    }

    /*private static void createDataTable(InvestigatorSearchPmrBean investigate) {
        int year = 2011;
       investigate.lista = new ArrayList<DetailsBean>();
       investigate.lista.add(new DetailsBean("name1", "email1", year));
       investigate.lista.add(new DetailsBean("name2", "email2", year++));
       investigate.lista.add(new DetailsBean("name3", "email3", year++));

       investigate.dataTable = new DataTable();
       Column column1 = new Column();
       column1.setHeaderText("Nome");

       Column column2 = new Column();
       column2.setHeaderText("Email");

       Column column3 = new Column();
       column3.setHeaderText("Idade");

       investigate.dataTable.getChildren().add(column1);
       investigate.dataTable.getChildren().add(column2);
       investigate.dataTable.getChildren().add(column3);

       investigate.getTabela().setValue(this.lista);
       }
        */
    }

