package com.buscaminas.buscaminas.util;

public final class CosmeticoConstants {

    public static final String ESTILO_CLASSIC = "theme-classic.css";

    private CosmeticoConstants() {}

    public static boolean esClassic(String estilo) {
        return ESTILO_CLASSIC.equals(estilo);
    }
}
