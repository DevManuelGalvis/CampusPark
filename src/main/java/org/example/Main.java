package org.example;

import modelos.atracciones.*;
import modelos.enums.*;
import modelos.parque.Parque;
import modelos.personas.Visitante;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Parque parque = new Parque("CampusPark");

        // Atracción de ejemplo
        Atraccion mecanica = new AtraccionMecanica(
                1,
                "Montaña Rusa",
                2,
                15000,
                EstadoAtraccion.OPERATIVA,
                NivelRiesgo.ALTO,
                new ArrayList<>(),
                new ArrayList<>(),
                140
        );

        parque.agregarAtraccion(mecanica);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== CAMPUSPARK ===");
            System.out.println("1. Encolar visitante");
            System.out.println("2. Operar atracción");
            System.out.println("3. Ver recaudo total");
            System.out.println("4. Ver colas");
            System.out.println("0. Salir");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    Visitante v = new Visitante(1, "Juan", 20, 170, false);
                    mecanica.encolarVisitante(v);
                    System.out.println("Visitante encolado.");
                }
                case 2 -> {
                    parque.operarAtraccion(mecanica);
                    System.out.println("Atracción operada.");
                }
                case 3 -> {
                    System.out.println("Recaudo total: $" + parque.getRecaudoTotal());
                }
                case 4 -> {
                    parque.mostrarColas();
                }
                case 0 -> salir = true;
            }
        }
    }
}
