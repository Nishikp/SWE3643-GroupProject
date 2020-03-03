import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkeletonFilesTestFails {

    private SkeletonFiles test = new SkeletonFiles();

    @Test
    public void incorrectSpell () {
        String[] checkString = {"Kennesaw State University"};
        String fail0 = "Kenessaw";
        String[] incorrect = test.searchSchoolsByName(fail0);

        assertArrayEquals(checkString, incorrect);
    }

    @Test
    public void charSub() {
        String[] checkString = {"Kennesaw State University"};
        String fail1 = "K3nn3saw";
        String[] character = test.searchSchoolsByName (fail1);

        assertArrayEquals(checkString, character);
    }

    @Test
    public void specialChar() {
        String[] checkString = {"Kennesaw State University"};
        String fail2 = "Kennes@w";
        String[] special = test.searchSchoolsByName (fail2);

        assertArrayEquals(checkString, special);
    }

    @Test
    public void nonExistent () {
        String[] checkString = {"Kennesaw State University, Georgia State University, Georgia Tech, Chattahoochee Tech College"};
        int fail3 = 30005;
        String[] nonExist = test.searchSchoolsByZip (fail3);

        assertArrayEquals(checkString, nonExist);
    }
}
