package com.samuelminana.tema4maven;

import com.github.lalyos.jfiglet.FigletFont;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List <String> guion = new ArrayList<>();

        String texto = "Samuel Minana";
        String banner = FigletFont.convertOneLine(texto);

        for (String linea : banner.split("\n")) {
            guion.add(linea);
        }

        guion.add("");

        guion.add("Nombre: Samuel Minana");
        guion.add("Perfil: Estudiante de DAM");
        guion.add("Lenguajes: HTML, Java, JS");
        guion.add("Herramientas: Git, GitHub, Maven");
        guion.add("Experiencias: Trabajos en equipo");
        guion.add("Intereses: Programación y sistemas");
        guion.add("Habilidades: Trabajo en equipo");
        guion.add("Contacto: samuelminana@gmail.com");
        guion.add("Idiomas: Castellano, Inglés, Valenciano");
        guion.add("Prácticas: Empresa online");

        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
        screen.setCursorPosition(null);

        screen.readInput();
        screen.stopScreen();
        }
    }
