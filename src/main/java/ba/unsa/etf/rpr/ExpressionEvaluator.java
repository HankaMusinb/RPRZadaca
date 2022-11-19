package ba.unsa.etf.rpr;
import java.util.Stack;

/**
 * Klasa ExpressionEvaluator sa dva stacka kao atributa te dvije metode
 */

public class ExpressionEvaluator {
    private Stack<String> operatori  = new Stack<String>();
    private Stack<Double> brojevi = new Stack<Double>();
    private Evaluator provjera;

    /**
     *
     * @param ulaz
     * @return vrijednost dijkstrinog algoritma za unesenu vrijednost
     * Sastoji se od pozivanje odgovarajuce klase za ispravnost iz klase Evaluator u kojoj se vrsi sva detaljna provjera
     * @throws RuntimeException
     */
    public Double evaluate (String ulaz) throws RuntimeException{
        try {
            provjera.ispravnostUlaza(ulaz);
        }catch (RuntimeException izuzetak){
            System.out.println("Neispravan unos za proracun.");
        }
        return dijkstrasAlgorithm(ulaz.split(" "));
    }


    public Double dijkstrasAlgorithm(String[] lista){
        for(String s : lista){
            if (s.equals("("));
            else if (s.equals("+")) { operatori.push(s);}
            else if (s.equals("-")) { operatori.push(s);}
            else if (s.equals("*")) { operatori.push(s);}
            else if (s.equals("/")) { operatori.push(s);}
            else if (s.equals("sqrt")) { operatori.push(s);}
            else if (s.equals(")")){
                String operator = operatori.pop();
                Double vrijednost = brojevi.pop();
                if (operator.equals("+")) vrijednost=brojevi.pop() + vrijednost;
                else if (operator.equals("-")) vrijednost=brojevi.pop() - vrijednost;
                else if (operator.equals("*")) vrijednost=brojevi.pop() * vrijednost;
                else if (operator.equals("/")) vrijednost=brojevi.pop() / vrijednost;
                else if (operator.equals("sqrt")) vrijednost = Math.sqrt(vrijednost);
                brojevi.push(vrijednost);

            }else brojevi.push(Double.parseDouble(s));

            }
            return brojevi.pop();
        }

    }


