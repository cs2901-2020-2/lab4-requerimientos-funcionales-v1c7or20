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
        for (String item : part){
            if (Answer.length() == 0){
                Answer += item;
            }else {
                for(int IteradorString = 0; IteradorString < item.length(); IteradorString++){
                    String Buscador = Answer.substring(IteradorString);
                    String split[] = item.split(Buscador);
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
