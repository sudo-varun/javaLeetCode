import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        double[] probabilities = {1.0/2, 1.0/3, 1.0/12, 1.0/12};
        double[] prefixSums = new double[probabilities.length];

        prefixSums[0] = probabilities[0];
        for (int i = 1; i < probabilities.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + probabilities[i];
        }
        System.out.println(Arrays.toString(prefixSums));
    }
}