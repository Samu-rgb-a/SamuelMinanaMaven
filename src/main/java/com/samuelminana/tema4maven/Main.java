package com.samuelminana.tema4maven;

import com.github.lalyos.jfiglet.FigletFont;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<String> guion = new ArrayList<>();

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

        int height = screen.getTerminalSize().getRows();
        int yOffset = height;

        while (yOffset + guion.size() > 0) {
            drawFrame(screen, guion, yOffset);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored){}

            yOffset--;
        }

        screen.readInput();
        screen.stopScreen();
    }

    private static void drawFrame(Screen screen, List<String> lines, int yOffset)
        throws IOException {
            TerminalSize size = screen.getTerminalSize();
            int width = size.getColumns();
            int height = size.getRows();
            screen.clear();
            TextGraphics tg = screen.newTextGraphics();
            for (int i = 0; i < lines.size(); i++) {
                int y = yOffset + i;
                if (y < 0 || y >= height) continue;
                String line = lines.get(i);

                int x = Math.max(0, (width - line.length()) / 2);
                if (x >= width) continue;

                String visible = (line.length() > width) ? line.substring(0, width) :
                        line;
                tg.putString(x, y, visible);
            }
            screen.refresh();
    }
}

