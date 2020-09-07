import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner myIn = new Scanner(System.in);
        String firstWordList = myIn.nextLine();
        String secondWordList = myIn.nextLine();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        System.out.println(Arrays.toString(result.toArray()));

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
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
