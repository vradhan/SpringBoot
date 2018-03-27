package com.primefaces.web.bean;


import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class UserWizard {
    private User user = new User();
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
     
    public void save() {        
        FacesContext fc = addMessage();
        fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "/showDetails.xhtml");
        fc.renderResponse();
    }

    private FacesContext addMessage() {
        FacesMessage facesMessage = new FacesMessage("Successful! "+ "Parma ID :" + user.getParmaID() + " and Trading partner : "+ user.getTradingPartner() 
        + " are registered successfully.");
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMessage);
        fc.getExternalContext().getFlash().setKeepMessages(true);
        return fc;
    }
}
