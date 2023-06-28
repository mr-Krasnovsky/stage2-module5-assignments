package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private int valueofCheap;
    Scanner informationScanner;
    static List<String> stringArrayList;

    public LocalProcessor(String processorName, Long period, String processorVersion, int valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueofCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String str: stringArrayList) {
            System.out.println(str.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder processorNameBuilder = new StringBuilder();
        for (String str: stringList) {
            processorNameBuilder.append(str + " ");
        }
        processorName = processorNameBuilder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
           try {
               informationScanner = new Scanner(file);
               StringBuilder versionBuilder = new StringBuilder();
               while (informationScanner.hasNext()) {
                   versionBuilder.append(informationScanner.nextLine());
            }
               processorVersion = versionBuilder.toString();
        } catch (FileNotFoundException e){
               e.printStackTrace();
        } finally {
               if (informationScanner != null){
                   informationScanner.close();
               }
           }
    }
}
