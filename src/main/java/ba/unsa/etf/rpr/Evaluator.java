package ba.unsa.etf.rpr;

/**
 * Klasa koja sluzi za sve provjere ispravnosti ulaza te rasterecuje citljivost klase ExpressionEvaluator
 */
public class Evaluator {
    private String ulaz;

    public Evaluator(String ulaz) {
        this.ulaz = ulaz;
    }
    public void ispravnostUlaza(String ulaz){
        if(!provjeriRedoslijed(ulaz)){
            //throw RuntimeException;
        }else if(!provjeriBrojZagrada(ulaz)){
            // throw RuntimeException;
        }else if(!provjeriIspravnostKaraktera(ulaz)){
            // throw RuntimeException;
        }else if(!provjeri(ulaz)){
            //  throw RuntimeException;
        }
    }
    private String[] konvertuj(String ulaz){
        return ulaz.split(" ");
    }
    private boolean provjeriIspravnostKaraktera(String ulaz) {
        for(String karakter : konvertuj(ulaz)){
            if(dozvoljeniKarakteri(karakter) == false){
                return false;
            }
        }
        return true;
    }
    private boolean dozvoljeniKarakteri(String s){
        if( s.equals("(") || s.equals(")") || provjeriJeLiOperacija(s) || provjeriJeLiBroj(s)){
            return true;
        }
        return false;
    }
    private boolean provjeriJeLiOperacija(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }
        return false;
    }
    private boolean provjeriJeLiBroj(String s) {
        try {
            Double.parseDouble(s);
        }catch (Exception izuzetak ){
            return false;
        }
        return true;
    }
    private boolean provjeriBrojZagrada(String ulaz) {
        //String[] lista = ulaz.split(" ");
        return provjeriParnostZagrada(konvertuj(ulaz));
    }
    private boolean provjeriParnostZagrada(String[] lista){
        Integer br1 = 0, br2 = 0;
        for(String s : lista){
            if (s == "(") br1 = br1 + 1;
            if (s == ")") br2 = br2 + 1;
        }
        if (!br1.equals(br2)) return false;
        return true;
    }
    private boolean provjeriRedoslijed(String ulaz) {
        return true;
    }
    private boolean provjeri(String ulaz) {
        return false;
    }

}
