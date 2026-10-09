package com.cate.ejercicios.basicos.funciones;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class AspectRatio {
    public static void main(String[] args) {

        int ancho = -1;
        int alto = -1;
        int numeroMayor;
        int numeroMenor;

        String urlString = "https://images.pexels.com/photos/12899189/pexels-photo-12899189.jpeg?cs=tinysrgb&dpr=1&w=500";

        try {
            URL url = new URL(urlString);

            // 1. Abrimos la conexión manualmente
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            // 2. Simulamos ser un navegador web (Esto evita el bloqueo del servidor)
            conexion.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

            // 3. Leemos la imagen pasando el InputStream de la conexión configurada
            BufferedImage imagen = ImageIO.read(conexion.getInputStream());

            if (imagen != null) {
                ancho = imagen.getWidth();
                alto = imagen.getHeight();

            } else {
                System.out.println("El formato de la imagen no es compatible o está corrupto.");
            }

        } catch (IOException e) {
            System.out.println("Error al abrir la imagen: " + e.getMessage());

        }

        if (ancho > alto) {
            numeroMayor = ancho;
            numeroMenor = alto;
        } else {
            numeroMayor = alto;
            numeroMenor = ancho;
        }

        int resultadoResiduo = calcularResiduo(numeroMayor, numeroMenor);
        System.out.println("Tamaño de la imagen en píxeles:\nAncho: " + ancho + " píxeles\nAlto: " + alto + " píxeles");

        System.out.println("Aspect ratio imagen: " + ancho / resultadoResiduo + ":" + alto / resultadoResiduo);

    }

    private static int calcularResiduo(int numeroMayor, int numeroMenor) {
        int residuo = numeroMayor % numeroMenor;
        if (residuo == 0) return numeroMenor;
        while (residuo != 0) {
            residuo = numeroMayor % numeroMenor;
            numeroMayor = numeroMenor;
            numeroMenor = residuo;
        }
        return numeroMayor;
    }
}
