import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Artomov on 05.01.2014.
 *
 * Переписать алгоритмы с использованием коллекций.
 *
 */

public class Main {
    public static void main(String[] args) {
        //
        // create first 6 phone models (leftArray):
        ArrayList leftArray = new ArrayList(6);
        leftArray.add(new Phone.Builder().vendor("LG").model("A100").build());
        leftArray.add(new Phone.Builder().vendor("LG").model("A101").build());
        leftArray.add(new Phone.Builder().vendor("LG").model("A102").build());
        leftArray.add(new Phone.Builder().vendor("LG").model("A103").screenSize(22).build());
        leftArray.add(new Phone.Builder().vendor("LG").model("A104").build());
        leftArray.add(new Phone.Builder().vendor("LG").model("A105").build());
        //
        // create second 6 phone models (rightArray):
        ArrayList rightArray = new ArrayList(6);
        rightArray.add(new Phone.Builder().vendor("SONY").model("SE15").build());
        rightArray.add(new Phone.Builder().vendor("SONY").model("SE16").screenSize(17).build());
        rightArray.add(new Phone.Builder().vendor("SONY").model("SE17").build());
        rightArray.add(new Phone.Builder().vendor("LG").model("A103").screenSize(22).build()); // <-- DUPLICATE !
        rightArray.add(new Phone.Builder().vendor("APPLE").model("iPhone5").build());
        rightArray.add(new Phone.Builder().vendor("APPLE").model("iPhone6").build());

        // create resource delegate:
        ArrayHelperResource resource = new ArrayHelperResource();

        System.out.println("LEFT ARRAY:");
        resource.println(leftArray);

        System.out.println();
        System.out.println("RIGHT ARRAY:");
        resource.println(rightArray);

        System.out.println();
        System.out.println("MERGE:");
        ArrayHelper AH1 = new ArrayHelper(resource);
        ArrayList merged = AH1.merge(leftArray, rightArray);
        resource.println(merged);
    }
}
