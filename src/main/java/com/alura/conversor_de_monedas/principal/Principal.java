package com.alura.conversor_de_monedas.principal;
import com.alura.conversor_de_monedas.model.RespuestaMoneda;
import com.alura.conversor_de_monedas.service.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Principal {

    private static final Logger log = LoggerFactory.getLogger(Principal.class);
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "ce4588c646c804f8463e966f";

    private Set<String> monedasDisponibles = new HashSet<>();

    private void cargarMonedasDesdeAPI() {
        String json = consumoApi.obtenerDatos(URL_BASE + API_KEY + "/codes");
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

        if (jsonObject.get("result").getAsString().equalsIgnoreCase("success")) {
            JsonArray codigos = jsonObject.getAsJsonArray("supported_codes");
            for (int i = 0; i < codigos.size(); i++) {
                monedasDisponibles.add(codigos.get(i).getAsJsonArray().get(0).getAsString());
            }
        } else {
            System.out.println("Error al cargar las monedas desde la API.");
        }
    }

    public void conversor() {

        cargarMonedasDesdeAPI();

        int continuar = 1;

        while (continuar != 0 ) {

            ListadoDeMonedas.mostrarMonedasMasUsadas();

            System.out.println("Escribe las iniciales de la moneda que deseas cambiar ");
            var monedaOrigen = teclado.nextLine().toUpperCase();
            if (!monedasDisponibles.contains(monedaOrigen)) {
                System.out.println("Moneda no válida. Intente de nuevo.");
                continue;
            }

            System.out.println("Escribe las iniciales de la moneda que desea obtener ");
            var monedaDestino = teclado.nextLine().toUpperCase();
            if (!monedasDisponibles.contains(monedaDestino)) {
                System.out.println("Moneda no válida. Intente de nuevo.");
                continue;
            }

            var json = consumoApi.obtenerDatos(URL_BASE + API_KEY +"/pair/" + monedaOrigen + "/" + monedaDestino);

            Gson gson = new Gson();
            RespuestaMoneda respuesta = gson.fromJson(json, RespuestaMoneda.class);

            double tasaConversion = respuesta.getConversion_rate();
            System.out.println("La tasa de conversión de " + monedaOrigen + " a " + monedaDestino + " es: "
                    + tasaConversion);

            // Pedir monto a convertir
            double monto;
            while (true) {
                System.out.println("Ingresa el monto que deseas convertir:");
                String entrada = teclado.nextLine();
                try {
                    monto = Double.parseDouble(entrada);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Valor no válido. Debe ser numérico.");
                }
            };

            // Calcular el valor final
            double valorFinal = monto * tasaConversion;
            System.out.println(monto + " " + monedaOrigen + " equivalen a " + valorFinal + " " + monedaDestino);
            System.out.println("---------------------------------------------");

            System.out.println("¿Desea hacer otra conversión? (1 = Sí, 0 = No):");
            try {
                continuar = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                continuar = 0;
            }
        }
    }
}
