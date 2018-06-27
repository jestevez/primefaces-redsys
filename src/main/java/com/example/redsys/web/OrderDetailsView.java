package com.example.redsys.web;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@ViewScoped
public class OrderDetailsView {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private Order order;

    private String orderNumber;

    private String result;

    @PostConstruct
    public void init() {
        try {
            LOG.info("{}.init", this.getClass().getSimpleName());
            obtenerPedido();
        } catch (Exception e) {
            LOG.error("Clase {} Exception {} ", this.getClass().getSimpleName(), e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "ERROR"));
        }
    }

    public void obtenerPedido() {
        if (orderNumber != null) {
            String ordername = "ORDER_" + orderNumber;
            order = RedSysLocalDataBase.obtenerPedido(ordername);
            LOG.info("order", order);
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
