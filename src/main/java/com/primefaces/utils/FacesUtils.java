package com.primefaces.utils;

import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.el.ELException;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.validator.BeanValidator;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public final class FacesUtils {

    private static final String MISSING_PERMISSION_TO_PERFORM_OPERATION = "You do not have permission to perform operation.";

    private static final String NUMBER_PATTERN = "#,##0";
    private static final String CURRENCY_PATTERN = "#,##0.00";
    private static final String DECIMAL_PATTERN = "#,##0.00";

    private FacesUtils() {
    }

    public static String getDefaultIntegerFormat() {
        return NUMBER_PATTERN;
    }

    public static String getDefaultCurrencyFormat() {
        return CURRENCY_PATTERN;
    }

    public static String getDefaultDecimalFormat() {
        return DECIMAL_PATTERN;
    }

    /**
     * Registers BeanValidator in Faces context if missing.
     */
    public static void registerBeanValidatorIfMissing() {
        if (validatorIsMissing()) {
            FacesContext.getCurrentInstance().getApplication().addValidator(BeanValidator.VALIDATOR_ID, BeanValidator.class.getName());
        }
    }

    private static boolean validatorIsMissing() {
        boolean validatorIsMissing = true;
        for (Iterator<String> it = FacesContext.getCurrentInstance().getApplication().getValidatorIds(); it.hasNext();) {
            String validatorId = it.next();
            if (validatorId.equals(BeanValidator.VALIDATOR_ID)) {
                validatorIsMissing = false;
                break;
            }
        }
        return validatorIsMissing;
    }

    /**
     * Adds message to Javax Faces context.
     *
     * @param severity
     * @param summary
     *            message summary
     * @param details
     *            message details
     */
    public static void addMessage(String clientId, Severity severity, String summary, String details) {
        FacesMessage message = new FacesMessage(severity, summary, details);
        FacesContext.getCurrentInstance().addMessage(clientId, message);
    }

    /**
     * Adds message to Javax Faces context.
     *
     * @param severity
     * @param summary
     *            message summary
     */
    public static void addMessage(Severity severity, String summary) {
        addMessage(null, severity, summary, summary);
    }

    /**
     * Adds message to Javax Faces context. Message will be formated with args taken from last method param.
     *
     * @param severity
     * @param summary
     *            message summary
     * @param args
     *            arguments to be substituted in passed message
     */
    public static void addMessage(Severity severity, String summary, Object... args) {
        String msg = String.format(summary, args);
        addMessage(null, severity, msg, msg);
    }

    /**
     * Returns the request parameter value or null if no value for paramName.
     *
     * @param paramName
     * @return request parameter value or null if no value for paramName
     */
    public static String getRequestParameter(String paramName) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(paramName);
    }

    public static void addMessageAndKeepAfterRedirect(String clientId, FacesMessage facesMessage) {
        addMessage(clientId, facesMessage);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public static void addMessage(String clientId, FacesMessage facesMessage) {
        FacesContext.getCurrentInstance().addMessage(clientId, facesMessage);
    }

  /*  public static void executeAndHandleSecurityAccessException(Runnable runnable) {
        try {
            runnable.run();
        } catch (AccessDeniedException e) {
            FacesUtils.addMessage(FacesMessage.SEVERITY_ERROR, MISSING_PERMISSION_TO_PERFORM_OPERATION);
        }
    }*/

    public static void addSecurityAccessDeniedMessage() {
        FacesUtils.addMessage(FacesMessage.SEVERITY_ERROR, MISSING_PERMISSION_TO_PERFORM_OPERATION);
    }

    /**
     * Finds JSF managed bean by name.
     *
     * @param beanName
     * @return found bean or null if not found.
     */
    @SuppressWarnings("unchecked")
    public static <T> T findBean(String beanName) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
        } catch (ELException e) {
            return null;
        }

    }

    /**
     * Retrieves parameter from request and try to convert it to Long.
     *
     * @param paramName
     * @return retrieved Long parameter or null if could not retrieve
     */
    public static Long getLongRequestParameter(String paramName) {
        String param = getRequestParameter(paramName);
        if (StringUtils.isNumeric(param)) {
            return Long.parseLong(param);
        }
        return null;
    }

    /**
     * Retrieves base url of web application.
     *
     * @return
     */
    public static String getAppWebUrlBase() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    public static String getMessage(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }

    public static Locale getRequestLocale() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public static FacesMessage createMessage(Severity severity, String summary) {
        return new FacesMessage(severity, summary, summary);
    }

    public static void addMessageAndMarkAsInvalid(Severity severity, String summary) {
        addMessage(severity, summary);
        FacesContext.getCurrentInstance().validationFailed();
    }

    public static boolean isValidationFailed() {
        return FacesContext.getCurrentInstance().isValidationFailed();
    }

}
