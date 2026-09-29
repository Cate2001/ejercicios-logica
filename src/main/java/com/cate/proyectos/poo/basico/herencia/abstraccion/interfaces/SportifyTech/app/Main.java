package com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.app;

import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.enums.Nivel;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.model.Competidor;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.model.Entrenador;
import com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.services.ServicioCompetidor;

/**
 * Clase principal de demostración del sistema deportivo SportifyTech.
 * <p>
 * Esta clase contiene pruebas exhaustivas que demuestran el funcionamiento del sistema
 * de asignación de entrenadores a competidores basándose en criterios de aptitud física,
 * especialidad deportiva, credibilidad y experiencia.
 * </p>
 * <p>
 * Las pruebas validan:
 * </p>
 * <ul>
 * <li>Asignación correcta de entrenador por especialidad deportiva</li>
 * <li>Selección por mayor credibilidad física</li>
 * <li>Desempate por años de experiencia</li>
 * <li>Validación de aptitud para competir (IMC y consumo de agua)</li>
 * <li>Prevención de asignación duplicada de entrenador</li>
 * <li>Manejo de deportes sin entrenadores disponibles</li>
 * <li>Validación de parámetros nulos y arreglos vacíos</li>
 * </ul>
 *
 * @author Caterine Salinas Bolaños
 * @version 1.0
 */
public class Main {
    /**
     * Método principal que ejecuta las pruebas del sistema SportifyTech.
     * <p>
     * Realiza 9 pruebas que cubren:
     * </p>
     * <ol>
     * <li>ASIGNACIÓN CORRECTA: Competidor apto con deporte coincidente (Gimnasio)</li>
     * <li>SELECCIÓN POR MAYOR CREDIBILIDAD: Entre entrenadores del mismo deporte</li>
     * <li>DESEMPATE POR EXPERIENCIA: Cuando la credibilidad es igual</li>
     * <li>COMPETIDOR NO APTO: IMC fuera de rango (error esperado)</li>
     * <li>COMPETIDOR YA TIENE ENTRENADOR: Prevención de reasignación (error esperado)</li>
     * <li>DEPORTE DIFERENTE: Boxeo sin entrenadores disponibles (error esperado)</li>
     * <li>COMPETIDOR NULL: Validación de parámetro nulo (error esperado)</li>
     * <li>ENTRENADORES NULL: Validación de parámetro nulo (error esperado)</li>
     * <li>ARREGLO VACÍO: Validación de arreglo vacío (error esperado)</li>
     * </ol>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

                ServicioCompetidor servicio = new ServicioCompetidor();

                // ===============================
                // CREACIÓN DE ENTRENADORES BASE prueba
                // ===============================

                Entrenador entrenador1 = new Entrenador(
                        "Carlos",
                        "Ramirez",
                        40,
                        8,
                        80,
                        1.75,
                        "Gimnasio",
                        5
                );

                Entrenador entrenador2 = new Entrenador(
                        "Laura",
                        "Mendoza",
                        38,
                        9,
                        65,
                        1.65,
                        "Gimnasio",
                        10
                );

                Entrenador entrenador3 = new Entrenador(
                        "Pedro",
                        "Sanchez",
                        35,
                        8,
                        75,
                        1.70,
                        "Natacion",
                        7
                );

                Entrenador[] entrenadores = {entrenador1, entrenador2, entrenador3};

                // ======================================================
                // CASO 1 — ASIGNACIÓN CORRECTA
                // Competidor apto y deporte coincide
                // ======================================================

                try {

                    Competidor competidor1 = new Competidor(
                            "Luis",
                            "Martinez",
                            22,
                            8,
                            70,
                            1.75,
                            "Gimnasio",
                            Nivel.PRINCIPIANTE
                    );

                    servicio.seleccionarEntrenador(competidor1, entrenadores);

                    System.out.println("CASO 1 OK → Entrenador asignado: "
                            + competidor1.getEntrenador().getNombre());

                } catch (Exception e) {

                    System.out.println("CASO 1 ERROR → " + e.getMessage());

                }

                // ======================================================
                // CASO 2 — SELECCIÓN POR MAYOR CREDIBILIDAD
                // ======================================================

                try {

                    Competidor competidor2 = new Competidor(
                            "Ana",
                            "Gomez",
                            21,
                            9,
                            60,
                            1.65,
                            "Gimnasio",
                            Nivel.INTERMEDIO
                    );

                    servicio.seleccionarEntrenador(competidor2, entrenadores);

                    System.out.println("CASO 2 OK → Entrenador asignado: "
                            + competidor2.getEntrenador().getNombre());

                } catch (Exception e) {

                    System.out.println("CASO 2 ERROR → " + e.getMessage());

                }

                // ======================================================
                // CASO 3 — DESEMPATE POR EXPERIENCIA
                // (cuando la credibilidad sea igual)
                // ======================================================

                try {

                    Competidor competidor3 = new Competidor(
                            "Mario",
                            "Lopez",
                            23,
                            8,
                            72,
                            1.78,
                            "Gimnasio",
                            Nivel.AVANZADO
                    );

                    servicio.seleccionarEntrenador(competidor3, entrenadores);

                    System.out.println("CASO 3 OK → Entrenador asignado: "
                            + competidor3.getEntrenador().getNombre());

                } catch (Exception e) {

                    System.out.println("CASO 3 ERROR → " + e.getMessage());

                }

                // ======================================================
                // CASO 4 — COMPETIDOR NO APTO
                // ======================================================

                try {

                    Competidor competidorNoApto = new Competidor(
                            "Juan",
                            "Torres",
                            24,
                            1,
                            120,
                            1.60,
                            "Gimnasio",
                            Nivel.PRINCIPIANTE
                    );

                    servicio.seleccionarEntrenador(competidorNoApto, entrenadores);

                    System.out.println("CASO 4 OK");

                } catch (Exception e) {

                    System.out.println("CASO 4 ERROR ESPERADO → " + e.getMessage());

                }

                // ======================================================
                // CASO 5 — COMPETIDOR YA TIENE ENTRENADOR
                // ======================================================

                try {

                    Competidor competidorRepetido = new Competidor(
                            "Sofia",
                            "Diaz",
                            22,
                            8,
                            65,
                            1.68,
                            "Gimnasio",
                            Nivel.INTERMEDIO
                    );

                    servicio.seleccionarEntrenador(competidorRepetido, entrenadores);
                    servicio.seleccionarEntrenador(competidorRepetido, entrenadores);

                } catch (Exception e) {

                    System.out.println("CASO 5 ERROR ESPERADO → " + e.getMessage());

                }

                // ======================================================
                // CASO 6 — DEPORTE DIFERENTE
                // ======================================================

                try {

                    Competidor competidorSinEntrenador = new Competidor(
                            "Valeria",
                            "Castro",
                            25,
                            8,
                            63,
                            1.70,
                            "Boxeo",
                            Nivel.AVANZADO
                    );

                    servicio.seleccionarEntrenador(competidorSinEntrenador, entrenadores);

                } catch (Exception e) {

                    System.out.println("CASO 6 ERROR ESPERADO → " + e.getMessage());

                }

                // ======================================================
                // CASO 7 — COMPETIDOR NULL
                // ======================================================

                try {

                    servicio.seleccionarEntrenador(null, entrenadores);

                } catch (Exception e) {

                    System.out.println("CASO 7 ERROR ESPERADO → " + e.getMessage());

                }

                // ======================================================
                // CASO 8 — ENTRENADORES NULL
                // ======================================================

                try {

                    Competidor competidor = new Competidor(
                            "Daniel",
                            "Rios",
                            21,
                            8,
                            70,
                            1.72,
                            "Gimnasio",
                            Nivel.PRINCIPIANTE
                    );

                    servicio.seleccionarEntrenador(competidor, null);

                } catch (Exception e) {

                    System.out.println("CASO 8 ERROR ESPERADO → " + e.getMessage());

                }

                // ======================================================
                // CASO 9 — ARREGLO DE ENTRENADORES VACÍO
                // ======================================================

                try {

                    Competidor competidor = new Competidor(
                            "Andres",
                            "Mora",
                            22,
                            8,
                            68,
                            1.74,
                            "Gimnasio",
                            Nivel.INTERMEDIO
                    );

                    Entrenador[] entrenadoresVacios = {};

                    servicio.seleccionarEntrenador(competidor, entrenadoresVacios);

                } catch (Exception e) {

                    System.out.println("CASO 9 ERROR ESPERADO → " + e.getMessage());

                }

                // ======================================================
                // ESTADO FINAL DEL SISTEMA
                // ======================================================

                System.out.println("\n===== ENTRENADORES =====");
                System.out.println(entrenador1);
                System.out.println(entrenador2);
                System.out.println(entrenador3);

            }
        }