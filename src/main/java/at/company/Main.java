package at.company;

import at.company.config.FrameworkConfig;
import at.company.config.ConfigFactory;

public class Main {

    public static void main(String[] args) {

        FrameworkConfig config1 = ConfigFactory.getConfig();

        System.out.println(config1.loginUrl());

        FrameworkConfig config2 = ConfigFactory.getConfig();

        System.out.println(config2.loginUrl());

        System.out.println("Is it the same object? " + (config1 == config2));
    }
}
