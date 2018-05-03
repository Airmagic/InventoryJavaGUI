import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import java.io.IOException;

// This is to read and write to the json file from the API
public class Config {
    public static void configObjectMapper() {

        Unirest.setObjectMapper(new ObjectMapper() {

            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper =
                    new com.fasterxml.jackson.databind.ObjectMapper();


//            This is reading from the json fil and making it readible for the program to use
            @Override
            public <I> I readValue(String s, Class<I> aClass) {
                try {
                    return jacksonObjectMapper.readValue(s, aClass);
                } catch (IOException e) {
                    System.err.println(e);
//                    The function is looking for something ot be returned
//                    my exception handler returns just a file error string
                    return readValue("File Error", aClass);
//                    throw new RuntimeException(e);  // todo improve error handling
                }
            }

//            This is writing to the Json file
            @Override
            public String writeValue(Object o) {
                try{
                    return jacksonObjectMapper.writeValueAsString(o);
                } catch(JsonProcessingException e) {
                    System.err.println(e);
//                    this returns a string saying there is a problem and the error
                    return "Json problem: "+ e;
//                    throw new RuntimeException(e);  //todo improve error handling
                }
            }
        });
    }
}
