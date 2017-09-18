package cs340.byu.com.stringprocessor;

import com.shared.IStringProcessor;
import com.shared.IntPasser;
import com.shared.StringPasser;

//Singleton
public class StringProcessorProxy implements IStringProcessor {

    private static StringProcessorProxy proxy;

    private StringProcessorProxy(){
    }

    public static StringProcessorProxy getInstance(){
        if(proxy == null){
            proxy = new StringProcessorProxy();
        }
        return proxy;
    }

    public String toLowerCase(String input){
        StringPasser editString = new StringPasser();
        editString.setChangeString(input);
        StringPasser returned = ClientCommunicator
                .getInstance()
                .sendRequest("/lowercase", editString, StringPasser.class);
        if(returned == null){
            return null;
        }
        return returned.getChangeString();
    }

    public String trim(String input){
        StringPasser editString = new StringPasser();
        editString.setChangeString(input);
        StringPasser returned = ClientCommunicator
                .getInstance()
                .sendRequest("/trim", editString, StringPasser.class);
        if(returned == null){
            return null;
        }
        return returned.getChangeString();
    }

    public Integer parseInteger(String input) throws NumberFormatException{
        StringPasser editString = new StringPasser();
        editString.setChangeString(input);
        IntPasser returned = ClientCommunicator
                .getInstance()
                .sendRequest("/parseInt", editString, IntPasser.class);
        if(returned == null){
            return null;
        }
        return returned.getParsedInt();
    }

}
