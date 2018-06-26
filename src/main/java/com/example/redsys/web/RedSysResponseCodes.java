package com.example.redsys.web;

import java.util.HashMap;

public class RedSysResponseCodes {

    public static final HashMap<Integer, String> RESONSE_CODES = new HashMap<>();

    static {

        RESONSE_CODES.put(101, "La tarjeta utilizada ya ha pasado su fecha de caducidad y no puede realizar pagos."); // CARD EXPIRED
        RESONSE_CODES.put(102, "La tarjeta está bloqueada por su propietario o por sospechas de uso inadecuado."); // CARD BLOCKED TEMPORARILY OR UNDER SUSPICION OF FRAUD
        RESONSE_CODES.put(104, "La tarjeta no permite este tipo de pagos."); //TRANSACTION NOT PERMITTED
        RESONSE_CODES.put(106, "Demasiados intentos de código PIN incorrecto."); //NUMBER OF ATTEMPTS EXCEEDED
        RESONSE_CODES.put(107, "La tarjeta no permite autorizar pagos online."); //CONTACT THE CARD ISSUER
        RESONSE_CODES.put(109, "Refused because the merchant is not properly registered with international card systems."); //INVALID IDENTIFICATION BY MERCHANT OR POS TERMINAL
        RESONSE_CODES.put(110, "El importe no está dentro del rango autorizado"); //INVALID AMOUNT
        RESONSE_CODES.put(114, "La tarjeta no permite este tipo de pagos."); //CARD CANNOT BE USED FOR THE REQUESTED TRANSACTION
        RESONSE_CODES.put(116, "No hay suficiente crédito en la tarjeta para realizar el pago."); //INSUFFICIENT CREDIT
        RESONSE_CODES.put(118, "El número de tarjeta no exists."); //NON-REGISTERED CARD
        RESONSE_CODES.put(119, "La transacción ha sido rechazada por el TPV sin indicar motivo. Normalmente debido a algún control de seguridad que detecta que la operación es sospechosa."); //REFUSAL WITH NO SPECIFIC REASON
        RESONSE_CODES.put(125, "Tarjeta no efectiva"); //NON-OPERATIONAL CARD
        RESONSE_CODES.put(129, "El código de validación (CVV2 / CVC2) introducido por el cliente en el TPV de la entidad bancaria es incorrecto."); //CVV2/CVC2 ERROR
        RESONSE_CODES.put(167, "Sospecha de fraude."); //CONTACT THE CARD ISSUER – SUSPECTED FRAUD
        RESONSE_CODES.put(180, "Tarjeta ajena al servicio"); //CARD OUT OF SERVICE
        RESONSE_CODES.put(181, "La tarjeta tiene restricciones de crédito o débito que impiden el pago"); //CARD WITH CREDIT OR DEBIT RESTRICTIONS
        RESONSE_CODES.put(182, "La tarjeta tiene restricciones de crédito o débito que impiden el pago");
        RESONSE_CODES.put(184, "Indica que el usuario no ha podido validar correctamente la identidad del propietario de la tarjeta."); //AUTHENTICATION ERROR
        RESONSE_CODES.put(190, "La transacción ha sido rechazada por el TPV sin indicar motivo."); //REFUSAL WITH NO SPECIFIC REASON
        RESONSE_CODES.put(191, "La fecha de caducidad de la tarjeta introducida por el cliente no es válida"); //EXPIRY DATE INCORRECT

        RESONSE_CODES.put(201, "Tarjeta cadudada"); // CARD EXPIRED
        RESONSE_CODES.put(202, "Tarjeta bloqueada temporalmente"); // CARD BLOCKED TEMPORARILY OR UNDER SUSPICION OF FRAUD
        RESONSE_CODES.put(204, "Transacción no permitida para esta tarjeta"); // TRANSACTION NOT PERMITTED
        RESONSE_CODES.put(207, "No se ha podido autorizar la operación de manera automática"); // CONTACT THE CARD ISSUER
        RESONSE_CODES.put(208, "La tarjeta ha sido denunciada como perdida o robada"); // LOST OR STOLEN CARD
        RESONSE_CODES.put(209, "La tarjeta ha sido denunciada como perdida o robada"); // 
        RESONSE_CODES.put(280, "El código de validación introducido por el cliente en el TPV de la entidad bancaria es incorrecto."); // CVV2/CVC2 ERROR
        RESONSE_CODES.put(290, "Operación rechazada por el TPV sin especificar motivo"); // REFUSAL WITH NO SPECIFIC REASON

        RESONSE_CODES.put(904, "Comercio no registrado en FUC"); // 
        RESONSE_CODES.put(909, "Error de sistema"); // 
        RESONSE_CODES.put(913, "Pedido repetido"); // 
        RESONSE_CODES.put(944, "Sesión Incorrecta"); // 
        RESONSE_CODES.put(950, "Operación de devolución no permitida"); // 

        RESONSE_CODES.put(912, "Emisor no disponible"); // 
        RESONSE_CODES.put(9912, "Emisor no disponible"); // 
        RESONSE_CODES.put(9064, "Número de posiciones de la tarjeta incorrecta"); // 
        RESONSE_CODES.put(9078, "Tipo de operación no permitida para esa tarjeta"); // 
        RESONSE_CODES.put(9093, "Tarjeta no existente"); // 
        RESONSE_CODES.put(9094, "Rechazo servidores internacionales"); // 
        RESONSE_CODES.put(9104, "Comercio con \"titular seguro\" y titular sin clave de compra segura"); // 
        RESONSE_CODES.put(9218, "El comercio no permite op. seguras por entrada / operaciones"); // 
        RESONSE_CODES.put(9253, "Tarjeta no cumple con el cheque-dígito"); // 
        RESONSE_CODES.put(9256, "El comercio no puede realizar preautorizaciones"); // 
        RESONSE_CODES.put(9257, "Esta tarjeta no permite operativa de preautorizaciones"); // 
        RESONSE_CODES.put(9661, "Operación detenida por superar el control de restricciones en la entrada al SIS"); // 
        RESONSE_CODES.put(9913, "Error en la confirmación que el comercio envía al TPV Virtual (solo aplicable en la opción de sincronización SOAP)"); // 
        RESONSE_CODES.put(9914, "Confirmación \"KO\" del comercio (solo aplicable en la opción de sincronización SOAP)"); // 
        RESONSE_CODES.put(9915, "Una petición del usuario se ha cancelado el pago"); // 
        RESONSE_CODES.put(9928, "Anulación de autorización en diferido realizada por el SIS (proceso por lotes)"); // 
        RESONSE_CODES.put(9929, "Anulación de autorización en diferido realizada por el comercio"); // 
        RESONSE_CODES.put(9997, "Se está procesando otra transacción en SIS con la misma tarjeta"); // 
        RESONSE_CODES.put(9998, "Operación en proceso de solicitud de datos de tarjeta"); // 
        RESONSE_CODES.put(9999, "Operación que ha sido redirigida al emisor a autenticar"); // 
        RESONSE_CODES.put(0, ""); // 
        RESONSE_CODES.put(0, ""); // 

    }

    public static boolean isApprovedResponseCode(Integer resposeCode) {
        // Codigo de respuesta de transacciones aprobadas
        // 0000 a 0099 Transacción autorizada para pagos y preautorizaciones 
        // 900 Transacción autorizada para devoluciones y confirmaciones 
        // 400 Transacción autorizada para anulaciones                
        return resposeCode != null && ((resposeCode >= 0 && resposeCode < 100) || resposeCode == 900 || resposeCode == 400);
    }

    public static String getMessageByResponseCode(Integer resposeCode) {
        String msg = RESONSE_CODES.get(resposeCode);
        if (msg == null) {
            msg = "No se ha podido realizar la operación (" + (resposeCode != null ? resposeCode : "0") + ")";
        }
        return msg;
    }

}
