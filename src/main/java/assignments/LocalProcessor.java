package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private static final Logger logger = LoggerFactory.getLogger(LocalProcessor.class);

    private String processorName;
    private long period = 10_000_000_000_000L;
    protected String processorVersion;
    private int valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;
    private StringBuilder stringBuilder;

    public LocalProcessor(String processorName, long period, String processorVersion, int valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        stringBuilder = new StringBuilder();
        for (String str: stringArrayList) {
            if (str != null) {
                stringBuilder.append(str.hashCode());
                String logMessage = stringBuilder.toString();
                logger.info(logMessage);
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        stringBuilder = new StringBuilder();
        for (String str: stringList) {
                stringBuilder.append(str + " ");
        }
        processorName = stringBuilder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
           try {
               informationScanner = new Scanner(file);
               stringBuilder = new StringBuilder();
               while (informationScanner.hasNext()) {
                   stringBuilder.append(informationScanner.nextLine());
            }
               processorVersion = stringBuilder.toString();
        } catch (FileNotFoundException e){
               e.printStackTrace();
        } finally {
               if (informationScanner != null){
                   informationScanner.close();
               }
           }
    }
}

