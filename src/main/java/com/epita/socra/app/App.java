package com.epita.socra.app;

import com.epita.socra.app.tools.*;

import java.security.InvalidParameterException;

/**
 * Hello world!
 */
public final class App {
    private IOAdapter adapter;
    private MorseDecoder decoder;

    private App() { this(new ConsoleAdapter(), new MorseDecoder()); }

    public App(IOAdapter adapter, MorseDecoder decoder) {
        this.adapter = adapter;
        this.decoder = decoder;
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    public void run(){
        adapter.write("Enters input: ");
        String input = adapter.read();
        try {
            String res = decoder.MorseToInt(input);
            adapter.write(res);
        } catch (InvalidParameterException e) {
            adapter.write("Invalid input !");
        }
    }
}
