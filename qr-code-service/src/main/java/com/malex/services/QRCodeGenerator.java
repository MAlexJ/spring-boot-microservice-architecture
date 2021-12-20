package com.malex.services;

import com.malex.model.QRCodeContext;

public interface QRCodeGenerator {

    byte[] generateQRCode(QRCodeContext context);
}
