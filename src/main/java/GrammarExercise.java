import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        Scanner myIn = new Scanner(System.in);
        System.out.print("firstWordList:");
        String firstWordList = myIn.nextLine();
        System.out.print("secondWordList:");
        String secondWordList = myIn.nextLine();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        System.out.println(Arrays.toString(result.toArray()));

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        String regex = "^[A-Za-z]*([A-Za-z]+[,])*([A-Za-z]+)$";
        if (firstWordList.matches(regex) && secondWordList.matches(regex)){
            List<String> strs1 = Arrays.asList(firstWordList.toLowerCase().split(","));
            List<String> strs2 = Arrays.asList(secondWordList.toLowerCase().split(","));
            List<String> strs3 = strs1.stream().filter(it->strs2.contains(it)).distinct().collect(Collectors.toList());
            return strs3;
        } else {
            throw new RuntimeException("input not valid");
        }
    }
}
