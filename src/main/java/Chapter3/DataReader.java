package Chapter3;

import java.util.List;
import java.io.IOException;

public interface DataReader<T> {
    List<T> readData(String sourcePath) throws IOException;
}


