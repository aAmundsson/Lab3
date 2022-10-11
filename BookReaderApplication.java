package L3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {

    public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
            "halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
            "södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
            "öland", "östergötland" };

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<TextProcessor> processorList = new ArrayList<>();
        // processorList.add(new SingleWordCounter("nils"));
        // processorList.add(new SingleWordCounter("norge"));
        processorList.add(new MultiWordCounter(REGIONS));
        Scanner scan = new Scanner(new File("labb3undantagsord.txt"));
        Set<String> stopwords = new HashSet<String>();
        while(scan.hasNext()) {
            stopwords.add(scan.next());
        }
        GeneralWordCounter GWC = new GeneralWordCounter(stopwords);
        long t0 = System.nanoTime();
        processorList.add(GWC);
        // TextProcessor p = new SingleWordCounter("nils");

        Scanner s = new Scanner(new File("nilsholg.txt"));
        s.findWithinHorizon("\uFEFF", 1);
        s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

        while (s.hasNext()) {
            String word = s.next().toLowerCase();
            for(TextProcessor p : processorList){
                p.process(word);
            }
        }

        s.close();
        long t1 = System.nanoTime();

        /*for(TextProcessor p : processorList){

            p.report();
        }*/

        System.out.println("tid: " + (t1-t0)/1000000 + " ms.");

        BookReaderController controller = new BookReaderController(GWC);


    }
}
