import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Artomov on 18.12.2014.
 *
 */

public class CollectionUtils {
    //
    // resource for delegating:
    private final ArrayHelperResource resource;
    //
    //
    public CollectionUtils(ArrayHelperResource resource) {
        this.resource = resource;
    }
    //
    // delegate 'println':
    public void println(ArrayList phones) {
        resource.println(phones);
    }
    //
    // delegate 'merge':
    public ArrayList merge(ArrayList leftArray, ArrayList rightArray) {
        return resource.merge(leftArray, rightArray);
    }
}