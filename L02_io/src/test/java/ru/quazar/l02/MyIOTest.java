import org.junit.Assert;
import org.junit.Test;
import ru.quazar.l02.HomeWork02;

public class MyIOTest {

    @Test
    public void sourceFileNotFound() {
        Assert.assertNotNull("homework_02_input.txt", HomeWork02.file2Stream());
    }

    @Test
    public void targetFileNotFound() {
        Assert.assertNotNull("homework_02_output.txt", HomeWork02.file2Stream());
    }

}