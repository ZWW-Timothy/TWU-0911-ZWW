import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";
        Scanner wl = new Scanner(System.in);
        firstWordList = wl.next();
        secondWordList = wl.next();
        wl.close();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        System.out.print(result);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> fwl = Arrays.asList(firstWordList.toUpperCase().split(","));
        List<String> swl = Arrays.asList(secondWordList.toUpperCase().split(","));

        if(!(fwl.stream().allMatch(w -> w.matches("^[a-zA-Z]+$"))) || !(swl.stream().allMatch(w -> w.matches("^[a-zA-Z]+$")))) {
            throw new RuntimeException("input not valid");
        }

        List<String> same = fwl;
        return same.stream()
                .distinct()
                .filter(w -> swl.contains(w))
                .sorted()
                .map(w -> w.replace("", " ").trim())
                .collect(Collectors.toList());
    }
}
