package com.example.redsys.web;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.FlowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sis.redsys.api.ApiMacSha256;

@ManagedBean
@ViewScoped
public class InicioView implements Serializable {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private String signatureVersion;
    private String merchantParamenters;
    private String signature;

    private Order order;
    private String currentStep;

    @PostConstruct
    public void init() {
        try {
            LOG.info("{}.init", this.getClass().getSimpleName());
            currentStep = "order";
            order = new Order();
            order.setAmount(300);
            order.setDescription("Poliza de Seguro");
            order.setId("1");

        } catch (Exception e) {
            LOG.error("Clase {} Exception {} ", this.getClass().getSimpleName(), e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "ERROR"));
        }
    }

    //--------------- Flujo del wizard
    public String onFlowProcess(FlowEvent event) {
        currentStep = event.getNewStep();
        return currentStep;
    }

    public void confirm() {
        try {
            LOG.info("{}.init", this.getClass().getSimpleName());

            order.setNumber(Order.getRandomOrderNumber());

            ApiMacSha256 apiMacSha256 = new ApiMacSha256();

            // FIXME monto sin puntos, usando los dos ultimos digitos para los decimales
            BigDecimal amount = new BigDecimal(order.getAmount()); /// 300 ---> 30000
            String amountStr = amount.movePointRight(2).toString();
            LOG.info("amountStr  {} ", amountStr);

            String compraEncriptada = order.getNumber();
            String urlConfirmacion = "/";

            // Usamos el mismo endpont solo cambiando el parametro result = OK|KO
            // FIXME Cambioar el URL
            /*
            // Example: http://myhost:8080/people?lastname=Fox&age=30

             String uri = request.getScheme() + "://" +   // "http" + "://
             request.getServerName() +       // "myhost"
             ":" +                           // ":"
             request.getServerPort() +       // "8080"
             request.getRequestURI() +       // "/people"
             "?" +                           // "?"
             request.getQueryString();       // "lastname=Fox&age=30"
            
             */
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            // String uri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            // uri = uri + "/redsysResponse";
            String uri = "http://www.joseluisestevez.com/redsys.php";
            String urlPagoOk = uri + "?" + Constants.VAR_RESULT + "=" + Constants.OK;
            String urlPagoKo = uri + "?" + Constants.VAR_RESULT + "=" + Constants.KO;

            apiMacSha256.setParameter(Constants.DS_MERCHANT_AMOUNT, amountStr);
            apiMacSha256.setParameter(Constants.DS_MERCHANT_ORDER, order.getNumber());
            apiMacSha256.setParameter(Constants.DS_MERCHANT_MERCHANTCODE, Constants.REDSYS_MERCHANTCODE);
            apiMacSha256.setParameter(Constants.DS_MERCHANT_CURRENCY, Constants.REDSYS_CURRENCY);
            apiMacSha256.setParameter(Constants.DS_MERCHANT_TRANSACTIONTYPE, Constants.REDSYS_TRANSACTIONTYPE);
            apiMacSha256.setParameter(Constants.DS_MERCHANT_TERMINAL, Constants.REDSYS_TERMINAL);
            apiMacSha256.setParameter(Constants.DS_MERCHANT_MERCHANTURL, urlConfirmacion);
            apiMacSha256.setParameter(Constants.DS_MERCHANT_URLOK, urlPagoOk);
            apiMacSha256.setParameter(Constants.DS_MERCHANT_URLKO, urlPagoKo);

            signatureVersion = Constants.REDSYS_SIGNATURE_VERSION;
            merchantParamenters = apiMacSha256.createMerchantParameters();
            signature = apiMacSha256.createMerchantSignature(Constants.REDSYS_SECRETKEY);

            order.setSignature(signature);
            order.setMerchantParamenters(merchantParamenters);
            order.setSignatureVersion(signatureVersion);

            String ordername = "SEND_ORDER_" + order.getNumber();

//            FacesContext facesContext = FacesContext.getCurrentInstance();
//            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
//            request.getSession().setAttribute(ordername, order);
            boolean ok = RedSysDB.guardarPedido(order, ordername);
            LOG.info("Se guardo en la BD local {}", ok);
        } catch (Exception e) {
            LOG.error("Clase {} Exception {} ", this.getClass().getSimpleName(), e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "ERROR"));
        }
    }

    public String getSignatureVersion() {
        return signatureVersion;
    }

    public void setSignatureVersion(String signatureVersion) {
        this.signatureVersion = signatureVersion;
    }

    public String getMerchantParamenters() {
        return merchantParamenters;
    }

    public void setMerchantParamenters(String merchantParamenters) {
        this.merchantParamenters = merchantParamenters;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

}
