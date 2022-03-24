import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Log4j2
public class SortingTest {

    long start;
    long end;

    List<Integer> sampleList;
    List<Integer> copyList;


    @BeforeClass
    void setup() {
        var min = 0;
        var max = 100;
        sampleList = new ArrayList<>();
        copyList = new ArrayList<>();
        for (var i = 0; i < 11111; i++) {
            sampleList.add(getRandom(min, max));
        }
        copyList.addAll(sampleList);
    }


    @BeforeMethod
    public void startTimer() {
        start = new Date().getTime();
    }

    @AfterMethod
    public void showExecutionTime() {
        end = new Date().getTime();
        log.info("Execution time: {} ms", end - start);
    }

    @Test
    public void bubble() {
        boolean isSorted;
        do {
            isSorted = true;
            for (var i = 0; i < sampleList.size(); i++) {
                if (i + 1 < sampleList.size()) {
                    if (sampleList.get(i) > sampleList.get(i + 1)) {
                        var small = sampleList.get(i + 1);
                        var big = sampleList.get(i);
                        sampleList.set(i, small);
                        sampleList.set(i + 1, big);
                        isSorted = false;
                    }
                }
            }
        } while (!isSorted);
        log.info("Bubble sort done.");
        log.info("List size: {}, list: {}", sampleList.size(), printList(sampleList));
    }

    private int getRandom(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    private String printList(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        numbers.forEach(number -> {
            stringBuilder.append(number).append(";");
        });
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
