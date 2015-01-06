import junit.framework.TestCase;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class CollectionUtilsTest extends TestCase {

    public void testMerge() throws Exception {
        //
        // create first 6 phone models (leftArray):
        ArrayList leftArray = new ArrayList(6);
        Phone phone1 = new Phone.Builder().vendor("LG").model("A100").build();
        Phone phone2 = new Phone.Builder().vendor("LG").model("A101").build();
        Phone phone3 = new Phone.Builder().vendor("LG").model("A102").build();
        Phone phone4 =new Phone.Builder().vendor("LG").model("A103").screenSize(22).build();
        Phone phone5 =new Phone.Builder().vendor("LG").model("A104").build();
        Phone phone6 = new Phone.Builder().vendor("LG").model("A105").build();

         Phone phone11 =new Phone.Builder().vendor("SONY").model("SE15").build();
         Phone phone12 =new Phone.Builder().vendor("SONY").model("SE16").screenSize(17).build();
         Phone phone13 =new Phone.Builder().vendor("SONY").model("SE17").build();
         Phone phone14 =new Phone.Builder().vendor("LG").model("A103").screenSize(22).build();
         Phone phone15 =new Phone.Builder().vendor("APPLE").model("iPhone5").build();
         Phone phone16 =new Phone.Builder().vendor("APPLE").model("iPhone6").build();




        leftArray.add(phone1);
        leftArray.add(phone2);
        leftArray.add(phone3);
        leftArray.add(phone4);
        leftArray.add(phone5);
        leftArray.add(phone6);
        //
        // create second 6 phone models (rightArray):
        ArrayList rightArray = new ArrayList(6);
        rightArray.add(phone11);
        rightArray.add(phone12);
        rightArray.add(phone13);
        rightArray.add(phone14);// <-- DUPLICATE !
        rightArray.add(phone15);
        rightArray.add(phone16);

        //
        // create resource delegate:
        CollectionUtilsResource resource =mock(CollectionUtilsResource.class);
        //
        // result:
        Validator mockedValidator = mock(Validator.class);
        when(mockedValidator.validate( phone1)).thenReturn(true);
        when(mockedValidator.validate( phone2)).thenReturn(true);
        when(mockedValidator.validate( phone3)).thenReturn(true);
        when(mockedValidator.validate( phone4)).thenReturn(true);
        when(mockedValidator.validate( phone5)).thenReturn(true);
        when(mockedValidator.validate( phone6)).thenReturn(true);
        when(mockedValidator.validate( phone11)).thenReturn(true);
        when(mockedValidator.validate( phone12)).thenReturn(true);
        when(mockedValidator.validate( phone13)).thenReturn(true);
        when(mockedValidator.validate( phone14)).thenReturn(true);
        when(mockedValidator.validate( phone15)).thenReturn(true);
        when(mockedValidator.validate( phone16)).thenReturn(true);





        CollectionUtils AH = new CollectionUtils(resource, mockedValidator);
        ArrayList expected = new ArrayList();
        expected.addAll(leftArray);
        expected.add(phone14);

        ArrayList merged = AH.merge(leftArray, rightArray);

        AH.println(merged);

        assertEquals(expected, merged);


//        Phone validatedPhone = new Phone.Builder().vendor("LG").model("A103").screenSize(22).build();
//
//        ;
//
//
//
//        assertEquals(true, mockedValidator.validate(validatedPhone));



    }
}