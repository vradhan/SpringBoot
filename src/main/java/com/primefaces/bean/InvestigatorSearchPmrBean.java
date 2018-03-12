package com.primefaces.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.column.Column;
import org.primefaces.component.datatable.DataTable;
import org.springframework.stereotype.Component;
import com.primefaces.bean.DetailsBean;

@ManagedBean
@Component
public class InvestigatorSearchPmrBean {
    
    
    DetailsBean detailsBean;
    
    public List<DetailsBean> lista;
    
    public List<DetailsBean> getLista() {
        return lista;
    }

    public void setLista(List<DetailsBean> lista) {
        this.lista = lista;
    }

    public DataTable tablea;
    
    public DataTable getTablea() {
        return tablea;
    }

    public void setTablea(DataTable tablea) {
        this.tablea = tablea;
    }

    @PostConstruct
    public void init() {
    int year= 2011;
    this.lista = new ArrayList<DetailsBean>();
    this.lista.add(new DetailsBean("name1", "email1", year));
    this.lista.add(new DetailsBean("name2", "email2", year++));
    this.lista.add(new DetailsBean("name3", "email3", year++));

    this.tablea = new DataTable();
    Column column1 = new Column();
    column1.setHeaderText("Nome");

    Column column2 = new Column();
    column2.setHeaderText("Email");

    Column column3 = new Column();
    column3.setHeaderText("Idade");

    this.getTablea().getChildren().add(column1);
    this.getTablea().getChildren().add(column2);
    this.getTablea().getChildren().add(column3);

    this.getTablea().setValue(this.lista);
    }

  }
