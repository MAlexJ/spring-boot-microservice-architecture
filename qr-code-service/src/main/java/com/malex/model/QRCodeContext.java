package com.malex.model;

import java.util.Optional;

public record QRCodeContext(String content, String format, Integer width, Integer height) {

    private static final String QRCODE_FORMAT = "PNG";
    private static final String CONTENT_DEFAULT = "https://github.com/MAlexJ";
    private static final int WIDTH_DEFAULT = 250;
    private static final int HEIGHT_DEFAULT = 250;

    @Override
    public String format() {
        return Optional.ofNullable(format).orElse(QRCODE_FORMAT);
    }

    @Override
    public String content() {
        return Optional.ofNullable(content).orElse(CONTENT_DEFAULT);
    }

    @Override
    public Integer width() {
        return Optional.ofNullable(width).orElse(WIDTH_DEFAULT);
    }

    @Override
    public Integer height() {
        return Optional.ofNullable(height).orElse(HEIGHT_DEFAULT);
    }
}
