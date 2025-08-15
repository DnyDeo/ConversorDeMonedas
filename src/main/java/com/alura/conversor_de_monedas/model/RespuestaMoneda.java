package com.alura.conversor_de_monedas.model;

public class RespuestaMoneda {

        private String result;
        private String base_code;
        private String target_code;
        private double conversion_rate;

    public double getConversion_rate() {
        return conversion_rate;
    }
}
