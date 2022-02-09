package io.vividcode.graalvm.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles {

    public static void main(String[] args) {
        Locale locale = args.length > 1 ? new Locale(args[0], args[1]) : Locale.getDefault();
        System.out.println(
                ResourceBundle.getBundle("AppResource", locale).getString("message"));
    }
}
