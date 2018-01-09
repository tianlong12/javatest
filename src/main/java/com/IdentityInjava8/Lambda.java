package com.IdentityInjava8;


import java.util.Arrays;

public class Lambda {
    public static void main(String[] args) {
        Arrays.asList( "a", "b", "d" ).forEach(e -> {
            System.out.print( e );
            System.out.print( e );
        } );
    }
}
