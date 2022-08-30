package com.malex.controllers;

import com.malex.model.QRCodeContext;
import com.malex.services.impl.QRCodeGeneratorImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Base64;

/**
 *
 */
@Controller
@RequiredArgsConstructor
public class QRCodeController {

    /**
     * Template for html page located in static resources
     */
    private static final String HTML_PAGE = "qrcode_page";

    /**
     * Template attributes on HTML page
     */
    private static final String CONTENTS_ATTRIBUTE_NAME = "contents";
    private static final String QRCODE_ATTRIBUTE_NAME = "qrcode";

    /**
     * Service for generate new QR code
     */
    private final QRCodeGeneratorImpl service;


    /**
     * @param content
     * @param format
     * @param width
     * @param height
     * @return test html page
     */
    @GetMapping("/test")
    public String generateQRCode(Model model, //
                                 @PathVariable(required = false) String content, //
                                 @PathVariable(required = false) String format, //
                                 @PathVariable(required = false) Integer width, //
                                 @PathVariable(required = false) Integer height) {
        QRCodeContext ctx = initContext(content, format, width, height);
        String qrcode = getImageInBase64Format(ctx);
        model.addAttribute(CONTENTS_ATTRIBUTE_NAME, ctx.content());
        model.addAttribute(QRCODE_ATTRIBUTE_NAME, qrcode);
        return HTML_PAGE;
    }

    private String getImageInBase64Format(QRCodeContext context) {
        byte[] image = service.generateQRCode(context);
        // Convert Byte Array into Base64 Encode String
        return Base64.getEncoder().encodeToString(image);
    }

    private QRCodeContext initContext(String content, String format, Integer width, Integer height) {
        return new QRCodeContext(content, format, width, height);
    }
}