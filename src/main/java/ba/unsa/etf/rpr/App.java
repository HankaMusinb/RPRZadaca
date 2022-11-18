package ba.unsa.etf.rpr;

import java.util.Arrays;

/**
 * Homework 1, RPR
 * @author Hanka Musinbegovic, 18821
 * main klasa koja parsira ulaz s konzole
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            System.out.println(Arrays.toString(args));
            for(String s : args){
                ExpressionEvaluator evaluator = new ExpressionEvaluator();
                Double rezultat = evaluator.evaluate(s);
                System.out.println(s + " = " + rezultat );
            }
        }catch (RuntimeException izuzetak){
            System.out.println(izuzetak.getMessage());
        }

    }
}
