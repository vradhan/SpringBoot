package com.primefaces.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.primefaces.utils.FacesUtils;

/**
 * Responsible for steering UI Look&Feel. By default there 'volvo' style is set. All other styles can be defined under
 * '/resources/&lt;style-name&gt;'
 * folder and switched on by passing JVM '-Dui-style=&lt;style-name&gt;' or URL/request parameter 'ui-style=&lt;style-name&gt;'.
 * 
 * @author bpld313
 * 
 */
@ManagedBean(name = "uiStyleBean")
@SessionScoped
public class UIStyleBean implements Serializable {

    private static final String UI_STYLE = "ui-style";
    private static final String UI_STYLE_VOLVO = "volvo";
    private static final String DEFAULT = UI_STYLE_VOLVO;

    private static final long serialVersionUID = -9151337974093637156L;

    private String currentStyle = System.getProperty(UI_STYLE, DEFAULT);

    public void modifyStyleIfRequested() {
        String uiStyle = FacesUtils.getRequestParameter(UI_STYLE);
        if (StringUtils.isNotEmpty(uiStyle)) {
            currentStyle = uiStyle;
        }
    }

    /**
     * Gets current style name. It also checks if there was no request to change style to another one by <code>ui-style</code> request parameter.
     * 
     * @return current style name
     */
    public String getCurrentStyle() {
        modifyStyleIfRequested();
        return currentStyle;
    }

    public void setCurrentStyle(String currentStyle) {
        this.currentStyle = currentStyle;
    }
}
