package business;

import dao.FileToStr;
import domaine.ParticipationRateComparator;
import domaine.Result;

import java.lang.reflect.Array;
import java.util.*;


public class Application {
    static ArrayList<Result> results = new ArrayList<>();

    public Application(){
        chargerResultats();
        afficherPlusGrandeCommune();
        System.out.println("=========================================================================================");
        afficherParOrdreAlphabetique();
        System.out.println("=========================================================================================");
        afficherParParticipation();
    }

    /** Lit le fichier results.csv et le conserve en mémoire dans une Collection */
    private static void chargerResultats() {

        String[][] rawData = FileToStr.lireCsv("results.csv");

        // Load collection
        for (String [] row : rawData) {

            try{
                // check for error AND add to collection
                results.add(deserializeResult(row));
            } catch(IllegalArgumentException IAE) {
                System.out.println("Erreur! ligne non traitée : " + String.join(";", row));
            }
        }

    }

    private static Result deserializeResult(String[] row) throws IllegalArgumentException {

        int[] figures = new int[4];

        // 5 columns
        if(row.length != 5){throw new IllegalArgumentException();};

        // numeric values except first column
        for (int i = 1; i < row.length; i++){
            figures[i-1] = Integer.parseInt(row[i]);
        }

        return new Result(row[0], figures[0], figures[1], figures[2], figures[3]);

    }

    /** Affiche le résultat de la plus grande commune (plus grand nombre d'électeurs) */
    private static void afficherPlusGrandeCommune() {

        // SRC : https://www.baeldung.com/java-collection-min-max

        Result largerMunicipality = results
                .stream()
                .max(Comparator.comparing(Result::getNbElecteurs))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Plus grande commune : " +largerMunicipality.toString());
    }

    /** Affiche tous les résultats, triés par nom de commune */
    private static void afficherParOrdreAlphabetique() {
        Collections.sort(results);
        displayRecords();
    }

    /** Affiche tous les résultats, triés du plus grand taux de participation au plus petit */
    private static void afficherParParticipation() {
        results.sort(new ParticipationRateComparator());
        displayRecords();
    }

    private static void displayRecords(){
        for (Result result : results) {
            System.out.println(result.toString());
        }
    }

}
