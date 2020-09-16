package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }



    public String calculate(List<String> part){
        String Answer = "";
        for (String word : part){
            if (Answer.length() == 0){
                Answer += word;
            }else {
                //Recorre las palabras y las divide para buscar coincidencias
                for(int IteratorString = 0; IteratorString < word.length(); IteratorString++){
                    String Finder = Answer.substring(IteratorString);
                    //Si hay coincidencia lo divide
                    String split[] = word.split(Finder);
                    if (split.length == 2){
                            Answer += split[1];
                            break;
                    }
                }
            }
        }
        return Answer;
    }
}
