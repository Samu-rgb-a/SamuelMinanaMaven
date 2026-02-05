package com.samuelminana.tema4maven;

import com.github.lalyos.jfiglet.FigletFont;

public class Main {
    public static void main(String[] args) throws Exception {
        String texto = "Samuel Minana";
        String banner = FigletFont.convertOneLine(texto);
        System.out.println(banner);
    }
}