import java.util.ArrayList;

/**
 * Created by Artomov on 19.12.2014.
 */

public class CollectionUtilsResource {
    //
    // print Phone[] array:
    //
    public void println(ArrayList phones) {
        System.out.println(phones.toString());
    }
    //
    // returns merged leftArray and duplicates from (leftArray, rightArray):
    //
    public ArrayList merge(ArrayList leftArray, ArrayList rightArray) {
        ArrayList result = new ArrayList();
        result.add(leftArray);
        for (int i = 0; i < leftArray.size(); i++)
            for (int j = 0; j < rightArray.size(); j++) {
                Object element = rightArray.get(j);
                if (element.equals(leftArray.get(i))) {
                    result.add(element);
                }
            }
        return result;
    }
}
