package segmentedfilesystem;

import static org.junit.Assert.*;

import org.junit.Test;
import segmentedfilesystem.fileHandler.sortFile;
/**
 * This is just a stub test file. You should rename it to
 * something meaningful in your context and populate it with
 * useful tests.
 */
public class testing {

    @Test
    public void testingComparison(){
      byte[] testArray = {1,2,3,4,5,6,7};
      sortFile sort = new fileSorter();
      assertEquals((int)772, sorter.getPackageNumber(testArray));
      assertEquals((int)((testArray[2] << 8)|testArray[3]),(int)772);
    }

    @Test
    public void testingDoctype(){
      byte[] main = {2,3,4,6};
      ReceiverPackagers catcher = new ReceiverPackagers();
      assertEquals(1, catcher.endOfLine(min));

      byte[] notinit {5,3,4,6};
      assertEquals(2, catcher.endOfLine(notinit));

      byte[] hasone = {3,3,4,6};
      assertEquals(3, catcher.endOfLine(hasone));
    }
}
