package controllers;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertThat;

public class FileControllerTest {

  FileController textController;

  @Before
  public void setupTestData() throws FileNotFoundException {
    String fileName = "src/test/resources/testFile.txt";
    textController = new FileController(fileName);
  }

  @Test
  public void shouldGetTexLines() throws FileNotFoundException {
    String fileName = "src/test/resources/testFileLines.txt";
    textController = new FileController(fileName);
    assertThat(textController.getFileLines(), CoreMatchers.hasItems("LINE1", "LINE2"));
  }

//  @Test
//  public void shouldProcessFileInstruction() throws FileNotFoundException {
//    String fileName = "src/test/resources/testFile.txt";
//    textController = new FileController(fileName);
//    assertThat(
//        textController.processFile(),
//        CoreMatchers.hasItems("9", "5", "13", "22", "NO SUCH ROUTE", "2", "3", "9", "9", "7"));
//  }
}
