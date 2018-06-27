package com.example.redsys.web;

public class RedSysConstants {

    // Datos de la pasarela redsys
    public static final String REDSYS_SECRETKEY = "sq7HjrUOBfKmC576ILgskD5srU870gJ7";
    public static final String REDSYS_URL = "https://sis-t.redsys.es:25443/sis/realizarPago";
    public static final String REDSYS_SIGNATURE_VERSION = "HMAC_SHA256_V1";
    public static final String REDSYS_TRANSACTIONTYPE = "0";
    public static final String REDSYS_MERCHANTCODE = "999008881";
    public static final String REDSYS_TERMINAL = "001";
    public static final String REDSYS_CURRENCY = "978";
    public static final String REDSYS_DATABASE_PATH = "/opt/apps/data/";
    public static final String REDSYS_FILE_EXTENSION = ".ser";
    
    // Parametros de entrada
    public static final String DS_MERCHANT_AMOUNT = "DS_MERCHANT_AMOUNT";
    public static final String DS_MERCHANT_ORDER = "DS_MERCHANT_ORDER";
    public static final String DS_MERCHANT_MERCHANTCODE = "DS_MERCHANT_MERCHANTCODE";
    public static final String DS_MERCHANT_CURRENCY = "DS_MERCHANT_CURRENCY";
    public static final String DS_MERCHANT_TRANSACTIONTYPE = "DS_MERCHANT_TRANSACTIONTYPE";
    public static final String DS_MERCHANT_TERMINAL = "DS_MERCHANT_TERMINAL";
    public static final String DS_MERCHANT_MERCHANTURL = "DS_MERCHANT_MERCHANTURL";
    public static final String DS_MERCHANT_URLOK = "DS_MERCHANT_URLOK";
    public static final String DS_MERCHANT_URLKO = "DS_MERCHANT_URLKO";

    // Parametros del formulario
    public static final String DS_SIGNATUREVERSION = "Ds_SignatureVersion";
    public static final String DS_MERCHANTPARAMETERS = "Ds_MerchantParameters";
    public static final String DS_SIGNATURE = "Ds_Signature";

    // Parametros de la respuesta
    public static final String DS_DATE = "Ds_Date";
    public static final String DS_HOUR = "Ds_Hour";
    public static final String DS_SECUREPAYMENT = "Ds_SecurePayment"; 
    public static final String DS_AMOUNT = "Ds_Amount";
    public static final String DS_CURRENCY = "Ds_Currency";
    public static final String DS_ORDER = "Ds_Order";
    public static final String DS_MERCHANTCODE = "Ds_MerchantCode";
    public static final String DS_TERMINAL = "Ds_Terminal";
    public static final String DS_RESPONSE = "Ds_Response";
    public static final String DS_TRANSACTIONTYPE = "Ds_TransactionType";
    public static final String DS_MERCHANTDATA = "Ds_MerchantData";
    public static final String DS_AUTHORISATIONCODE = "Ds_AuthorisationCode";
    public static final String DS_CARD_NUMBER = "Ds_Card_Number";
    public static final String DS_CONSUMERLANGUAGE = "Ds_ConsumerLanguage";
    public static final String DS_CARD_COUNTRY = "Ds_Card_Country";
    public static final String DS_CARD_BRAND = "Ds_Card_Brand";

    public static final String OK = "OK";
    public static final String KO = "KO";
    public static final String VAR_RESULT = "result";
    public static final String VAR_ORDER_NUMBER = "order";
}
