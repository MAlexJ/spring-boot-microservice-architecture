package com.malex.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.malex.exceptions.GenerateQrCodeException;
import com.malex.model.QRCodeContext;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 */
@Service
public class QRCodeGeneratorImpl implements QRCodeGenerator {

    /**
     *
     */
    public byte[] generateQRCode(QRCodeContext context) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            BitMatrix bitMatrix = configBitMatrix(context);
            String format = context.format();
            MatrixToImageWriter.writeToStream(bitMatrix, format, out, configMatrixImage());
            return out.toByteArray();
        } catch (IOException | WriterException e) {
            throw new GenerateQrCodeException(e.getMessage(), e);
        }
    }

    /**
     *
     */
    private BitMatrix configBitMatrix(QRCodeContext context) throws WriterException {
        String content = context.content();
        int width = context.width();
        int height = context.height();
        return new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
    }

    /**
     *
     */
    private MatrixToImageConfig configMatrixImage() {
        return new MatrixToImageConfig();
    }
}

