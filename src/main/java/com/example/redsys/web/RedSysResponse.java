package com.example.redsys.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sis.redsys.api.ApiMacSha256;

@WebServlet("/redsysResponse")
public class RedSysResponse extends HttpServlet {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

// http://localhost:8080/redsys-example/redsysResponse?result=KO&Ds_SignatureVersion=HMAC_SHA256_V1&Ds_MerchantParameters=eyJEc19EYXRlIjoiMjYlMkYwNiUyRjIwMTgiLCJEc19Ib3VyIjoiMTElM0EwNSIsIkRzX1NlY3VyZVBheW1lbnQiOiIwIiwiRHNfQW1vdW50IjoiMzAwMDAiLCJEc19DdXJyZW5jeSI6Ijk3OCIsIkRzX09yZGVyIjoiNTQ1ODA3LTg0MTEwIiwiRHNfTWVyY2hhbnRDb2RlIjoiOTk5MDA4ODgxIiwiRHNfVGVybWluYWwiOiIwMDEiLCJEc19SZXNwb25zZSI6IjAxODAiLCJEc19UcmFuc2FjdGlvblR5cGUiOiIwIiwiRHNfTWVyY2hhbnREYXRhIjoiIiwiRHNfQXV0aG9yaXNhdGlvbkNvZGUiOiIrKysrKysiLCJEc19DYXJkX051bWJlciI6IjQxMTExMSoqKioqKjExMTEiLCJEc19Db25zdW1lckxhbmd1YWdlIjoiMSIsIkRzX0NhcmRfQ291bnRyeSI6IjAifQ==&Ds_Signature=TjK73kWi1J9TGwa9_fhOB3br8h7fX9617hEGtjU4VDo=
// http://localhost:8080/redsys-example/redsysResponse?result=ok&Ds_SignatureVersion=HMAC_SHA256_V1&Ds_MerchantParameters=eyJEc19EYXRlIjoiMjUlMkYwNiUyRjIwMTgiLCJEc19Ib3VyIjoiMTYlM0E1MSIsIkRzX1NlY3VyZVBheW1lbnQiOiIxIiwiRHNfQW1vdW50IjoiMzAwMDAwMDAwMCIsIkRzX0N1cnJlbmN5IjoiOTc4IiwiRHNfT3JkZXIiOiIwMDAwMDAwMDAwMDAiLCJEc19NZXJjaGFudENvZGUiOiI5OTkwMDg4ODEiLCJEc19UZXJtaW5hbCI6IjAwMSIsIkRzX1Jlc3BvbnNlIjoiMDAwMCIsIkRzX1RyYW5zYWN0aW9uVHlwZSI6IjAiLCJEc19NZXJjaGFudERhdGEiOiIiLCJEc19BdXRob3Jpc2F0aW9uQ29kZSI6IjExOTE4NyIsIkRzX0NhcmRfTnVtYmVyIjoiNDU0ODgxKioqKioqMDAwNCIsIkRzX0NvbnN1bWVyTGFuZ3VhZ2UiOiIxIiwiRHNfQ2FyZF9Db3VudHJ5IjoiNzI0IiwiRHNfQ2FyZF9CcmFuZCI6IjEifQ==&Ds_Signature=OUnNC-3X0XJizYoMs0bjM_zgbPf72qXxmhMuyhM8ytM=
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            LOG.info("----- Entrando en RedSysResponse -----");
            Map params = request.getParameterMap();
            Iterator i = params.keySet().iterator();
            while (i.hasNext()) {
                String key = (String) i.next();
                String value = ((String[]) params.get(key))[0];
                LOG.info("key {} value {} ", key, value);
            }

            String result = request.getParameter(Constants.VAR_RESULT);
            LOG.info("result {}", result);

            ApiMacSha256 apiMacSha256 = new ApiMacSha256();

            // Buscar los parametros de la respuesta de redsys
            String version = request.getParameter(Constants.DS_SIGNATUREVERSION);
            String merchantParams = request.getParameter(Constants.DS_MERCHANTPARAMETERS);
            String signatureRecibida = request.getParameter(Constants.DS_SIGNATURE);

                        
            LOG.info("/redsysResponse?result="+result+"&Ds_SignatureVersion="+version+"&Ds_MerchantParameters="+merchantParams+"&Ds_Signature="+signatureRecibida);

            String decode = apiMacSha256.decodeMerchantParameters(merchantParams);
            LOG.info("decodeMerchantParameters {}", decode);

            String codigoRespuesta = apiMacSha256.getParameter(Constants.DS_RESPONSE);
            LOG.info("codigoRespuesta {}", codigoRespuesta);
            Integer resposeCode = null;
            try {
                resposeCode = Integer.parseInt(codigoRespuesta);
            } catch (NumberFormatException e) {
                LOG.error("NumberFormatException {}", e);
            }
            
            LOG.info("resposeCode {}", resposeCode);

            /* Ejemplo de una respuesta OK
            {
                "Ds_Date": "25%2F06%2F2018",
                "Ds_Hour": "16%3A51",
                "Ds_SecurePayment": "1",
                "Ds_Amount": "3000000000",
                "Ds_Currency": "978",
                "Ds_Order": "000000000000",
                "Ds_MerchantCode": "999008881",
                "Ds_Terminal": "001",
                "Ds_Response": "0000",
                "Ds_TransactionType": "0",
                "Ds_MerchantData": "",
                "Ds_AuthorisationCode": "119187",
                "Ds_Card_Number": "454881******0004",
                "Ds_ConsumerLanguage": "1",
                "Ds_Card_Country": "724",
                "Ds_Card_Brand": "1"
            }
             */
            // Usamos JSONObject
            JSONObject object = new JSONObject(decode);

            String Ds_Date = object.getString(Constants.DS_DATE);
            String Ds_Hour = object.getString(Constants.DS_HOUR);
            String Ds_Amount = object.getString(Constants.DS_AMOUNT);
            String Ds_Order = object.getString(Constants.DS_ORDER);
            String Ds_AuthorisationCode = object.getString(Constants.DS_AUTHORISATIONCODE);
            
//            String Ds_Currency = object.getString(Constants.DS_CURRENCY);
//            String Ds_SecurePayment = object.getString(Constants.DS_SECUREPAYMENT);
//            String Ds_MerchantCode = object.getString(Constants.DS_MERCHANTCODE);
//            String Ds_Terminal = object.getString(Constants.DS_TERMINAL);
//            String Ds_Response = object.getString(Constants.DS_RESPONSE);
//            String Ds_TransactionType = object.getString(Constants.DS_TRANSACTIONTYPE);
//            String Ds_MerchantData = object.getString(Constants.DS_MERCHANTDATA);
//            String Ds_Card_Number = object.getString(Constants.DS_CARD_NUMBER);
//            String Ds_ConsumerLanguage = object.getString(Constants.DS_CONSUMERLANGUAGE);
//            String Ds_Card_Country = object.getString(Constants.DS_CARD_COUNTRY);
//            String Ds_Card_Brand = object.getString(Constants.DS_CARD_BRAND);

            // ----------------------- Serializar la respuesta en db local
            String responsename = "RECEIVE_ORDER_" + Ds_Order;
            Order receiveOrder = new Order();
            receiveOrder.setSignature(signatureRecibida);
            receiveOrder.setMerchantParamenters(merchantParams);
            receiveOrder.setSignatureVersion(version);
            RedSysDB.guardarPedido(receiveOrder, responsename);
            
            

            if (!Constants.OK.equalsIgnoreCase(result)) {
                LOG.info("Es una respuesta de error KO {}", result);
                String messge = RedSysResponseCodes.getMessageByResponseCode(resposeCode);
                LOG.info("messge {}", messge);
                throw new TransactionDeclinedException(resposeCode, messge);
            }

            LOG.info("Es una transaccion OK");

            // Order order = (Order) request.getSession().getAttribute(ordername);
            String ordername = "SEND_ORDER_" + Ds_Order;

            // ----------------------- Buscar pedido desde el sistema de archivos
            Order order = RedSysDB.obtenerPedido(ordername);
            if (order == null) {
                LOG.error("Pedido no encontrado {} ", ordername);
            }

            if (!RedSysResponseCodes.isApprovedResponseCode(resposeCode)) {
                LOG.info("codigo de respuesta de error");
                String messge = RedSysResponseCodes.getMessageByResponseCode(resposeCode);
                LOG.info("messge {}", messge);
                throw new TransactionDeclinedException(resposeCode, messge);
            }

            LOG.info("codigo de respuesta ok");
            String signatureCalculada = apiMacSha256.createMerchantSignatureNotif(Constants.REDSYS_SECRETKEY, merchantParams);

            if (signatureCalculada.equals(signatureRecibida)) {
                LOG.info("Firma OK. Realizar tareas en el servidor");

                LOG.info("Ds_AuthorisationCode {}", Ds_AuthorisationCode);
                LOG.info("Ds_Order {}", Ds_Order);
                LOG.info("Ds_Amount {}", Ds_Amount);
                LOG.info("Ds_Date {}", Ds_Date);
                LOG.info("Ds_Hour {}", Ds_Hour);

            } else {
                LOG.info("Firmar KO. Error firma invalida");
            }
        } catch (TransactionDeclinedException e) {
            // Error al realizar el pago
            LOG.error("TransactionDeclinedException {} - {}",  e.getResponseCode(), e.getResponseMessage());
        } catch (Exception e) {
            LOG.error("Error {}", e);
        } finally {
            LOG.info("----- Finalizando RedSysResponse -----");
        }

    }

}
