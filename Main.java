import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> adjListPlayers = new HashMap<>();

        //Creazione delle tuple della mappa
        adjListPlayers.put("Mada",1300);
        adjListPlayers.put("Eso",2100);
        adjListPlayers.put("Joe",800);
        adjListPlayers.put("Khaled",50);
        adjListPlayers.put("Salah",3500);
        adjListPlayers.put("Akram",3700);
        adjListPlayers.put("Karim",4000);

        //Stampare la length della mappa
        System.out.println("Ci sono " + adjListPlayers.size() + " Persone nella nostra mappa \n" );

        //Stampare la nostra mappa originale
        System.out.println("Unsorted hashmap :");
        printMap(adjListPlayers);

        System.out.println("________________________________________" + "\n");

        //Stampare la mappa sortata in ordine crescente rispetto il valore
        System.out.println("sorted hashmap :");
        List lista= sortMapIntoList(adjListPlayers);
        printSortedMap(adjListPlayers,lista);


    }

    public static List sortMapIntoList(HashMap<String,Integer>maping) {

        List<Map.Entry<String,Integer>> list = new ArrayList<>(maping.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //per l'ordine crescente,
                // invece per quello decrescente basta scambiare i variabili nella compareTo()
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return list;
    }

    public static void printMap(HashMap<String,Integer>maping) {
        for(String name: maping.keySet()){
            String key = name.toString();
            String value = maping.get(name).toString();
            System.out.println(key + " " + value);
        }
    }

    public static void printSortedMap(HashMap<String,Integer>maping,List<Map.Entry<String,Integer>> lista) {
        for(Map.Entry<String,Integer> e : lista){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}