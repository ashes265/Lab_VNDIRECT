package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class SearchFileNIOExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Charset charset=Charset.forName("utf-8");
        File file=new File("D:\\University\\OJT\\FileIO\\io_sample.txt");
        
        Pattern pattern=Pattern.compile("s\\S",Pattern.CASE_INSENSITIVE);
        FileInputStream stream=new FileInputStream(file);
        FileChannel channel=stream.getChannel();
        ByteBuffer bytes=channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        CharBuffer chars=charset.decode(bytes);
        Matcher matcher=pattern.matcher(chars);
        if(matcher.find()){
            System.out.println("Found at "+Integer.toString(matcher.start()));
            System.out.println("Value "+chars.subSequence(matcher.start(), matcher.end())+"");
        }else{
            System.out.println("Not found");
        }
    }
}
