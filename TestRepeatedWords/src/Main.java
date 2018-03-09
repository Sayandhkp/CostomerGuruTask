import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        String[] wordList = {"AAA", "AAA", "BBB", "BBB", "BBB", "CC", "CC", "XXX", "XXX", "PP", "QQ", "XXX", "XXX"};
        ArrayList<Modell> arrayList=findRepeated(wordList);


        for (Modell modell:arrayList){
            System.out.println("Word = "+modell.getWord()+"  Count = "+modell.getCount());
        }

    }

    private static ArrayList<Modell> findRepeated(String[] list) {
        ArrayList<Modell> arrayListModels = new ArrayList<>();
        for (int n = 0; n < list.length; n++) {

            int count = 1;
            for (int m = n + 1; m < list.length; m++) {

                if (list[n].equals(list[m])) {
                    count = count + 1;
                    list[m] = "null";
                }
            }
            if (!list[n].equalsIgnoreCase("null")){
                Modell modell = new Modell();
                modell.setCount(count);
                modell.setWord(list[n]);
                arrayListModels.add(modell);
                if (arrayListModels.size()==5){
                    Collections.sort(arrayListModels,new Comparator<Modell>(){
                        public int compare(Modell s1,Modell s2){
                            return Integer.compare(s2.getCount(), s1.getCount());

                        }});
                    return arrayListModels;
                }
            }
        }
        return arrayListModels;
    }
}
