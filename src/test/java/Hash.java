import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hash {


    @Test
    public void test_hashMarathon() {
        String[] participant = new String[] {"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[] {"stanko", "ana", "mislav"};

        System.out.println(hashMarathon(participant, completion));
    }



    public String hashMarathon(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> participantMap = new HashMap();

        Arrays.stream(participant)
                .forEach( it ->
                    participantMap.put(
                            it,
                            participantMap.getOrDefault(it, -1) + 1
                    )
                );

        Arrays.stream(completion)
                .forEach( it -> participantMap.put(it, participantMap.get(it)-1) );


        for( Map.Entry<String, Integer> elem : participantMap.entrySet() ){
            if(elem.getValue() != 0) answer = elem.getKey();
        }

        return answer;
    }
}
