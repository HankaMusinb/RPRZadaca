package ba.unsa.etf.rpr;

/**
 * Klasa koja sluzi za sve provjere ispravnosti ulaza te rasterecuje citljivost klase ExpressionEvaluator
 */
public class Evaluator {
    private String ulaz;

    public Evaluator(String ulaz) {
        this.ulaz = ulaz;
    }
    public void ispravnostUlaza(String ulaz) throws RuntimeException{
        if(!provjeriRedoslijed(ulaz)){
            throw new RuntimeException("Pogresan unos.");
        }else if(!provjeriBrojZagrada(ulaz)){
             throw new RuntimeException("Pogresan unos.");
        }else if(!provjeriIspravnostKaraktera(ulaz)){
            throw new RuntimeException("Pogresan unos.");
        }
    }

    /**
     * Konvertiranje ulaza u listu stringova razdvojenih razmacima
     */
    private String[] konvertuj(String ulaz){

        return ulaz.split(" ");
    }
    private boolean provjeriIspravnostKaraktera(String ulaz) {
        for(String karakter : konvertuj(ulaz)){
            if(!dozvoljeniKarakteri(karakter)){
                return false;
            }
        }
        return true;
    }

    /**
     * provjera da li se u unesenom stringu nalaze zagrade, brojevi i operandi
     * @param s
     * @return
     */
    private boolean dozvoljeniKarakteri(String s){
        if( s.equals("(") || s.equals(")") || provjeriJeLiOperacija(s) || provjeriJeLiBroj(s)){
            return true;
        }
        return false;
    }

    private boolean provjeriJeLiOperacija(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")){
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
            if (s.equals("(")) br1 = br1 + 1;
            if (s.equals( ")")) br2 = br2 + 1;
        }
        if (!br1.equals(br2)) return false;
        return true;
    }
    private boolean provjeriRedoslijed(String ulaz) throws RuntimeException {
        String[] lista = konvertuj(ulaz);
        int i, brOtvorenihZagrada = 0;
        for(i = 0; i < lista.length; i++){
            if(lista[i].equals("(")){
                brOtvorenihZagrada = brOtvorenihZagrada + 1;
                int j = i;
                while(j < lista.length){
                    if ( lista[j].equals(")")){
                        brOtvorenihZagrada = brOtvorenihZagrada - 1;
                        break;
                    }
                    if( lista[j].equals("(")){
                        brOtvorenihZagrada = brOtvorenihZagrada + 1;
                    }
                    j++;
                }
            }

        }
        if(brOtvorenihZagrada == 0) return true;
        return false;
    }

}
