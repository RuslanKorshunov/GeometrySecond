package by.epam.geometrysecond.reader;

import by.epam.geometrysecond.validator.FileValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointReader
{
    private static final String DEFAULT_FILE_PATH ="src/main/resources/points.txt";

    public List<String> read(String filePath) throws WorkWithFileException
    {
        List<String> lines;
        if(!FileValidator.existFile(filePath) || !FileValidator.canReadFile(filePath))
        {
            filePath=DEFAULT_FILE_PATH;
        }
        if(!FileValidator.existFile(filePath) || !FileValidator.canReadFile(filePath))
        {
            throw new WorkWithFileException("The default file didn't exist or couldn't be read");
        }
        try
        {
            Stream<String> lineStream=Files.newBufferedReader(Paths.get(filePath)).lines();
            lines=lineStream.collect(Collectors.toList());
        }
        catch(IOException e)
        {
            throw new WorkWithFileException("There was a problem reading from the file "+filePath, e);
        }
        if(lines.isEmpty())
        {
            throw new WorkWithFileException("The file is empty");
        }
        return lines;
    }
}