package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }



    public String calculate(List<String> part){
        StringBuilder answer = new StringBuilder();
        for (String word : part){
            if (answer.length() == 0){
                answer.append(word);
            }else {
                //Recorre las palabras y las divide para buscar coincidencias
                for(int IteratorString = 0; IteratorString < word.length(); IteratorString++){
                    String finder = answer.substring(IteratorString);
                    //Si hay coincidencia lo divide
                    String split[] = word.split(finder);
                    if (split.length == 2){
                            answer.append(split[1]);
                            break;
                    }
                }
            }
        }
        return answer.toString();
    }
}
