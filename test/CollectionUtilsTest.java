import junit.framework.TestCase;
import java.util.ArrayList;

public class CollectionUtilsTest extends TestCase {

    public void testPrintln() throws Exception {
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
        // create resource delegate:
        ArrayHelperResource resource = new ArrayHelperResource();
        //
        // result:
        CollectionUtils AH = new CollectionUtils(resource);
        AH.println(leftArray);
    }

    public void testMerge() throws Exception {
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
        //
        // create resource delegate:
        ArrayHelperResource resource = new ArrayHelperResource();
        //
        // result:
        CollectionUtils AH = new CollectionUtils(resource);
        ArrayList merged = AH.merge(leftArray, rightArray);
        AH.println(merged);
    }
}