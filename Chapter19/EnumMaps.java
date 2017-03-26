package Chapter19;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Ryan on 2017/3/23.
 */
public class EnumMaps {
    interface Command {
        void action();
    }

    enum Call {
        BEDROOM {
            String getInfo() {
                return "BedRoom";
            }
        }, BATHROOM {
            @Override
            String getInfo() {
                return "BathRoom";
            }
        }, KITCHEN {
            @Override
            String getInfo() {
                return "Kitchen";
            }
        };
        abstract String getInfo();



    }


    public static void main(String[] args) {
        EnumMap<Call, Command> enumMap = new EnumMap<Call, Command>(Call.class);
        enumMap.put(Call.BEDROOM, () -> System.out.println("BEDROOM"));
        enumMap.put(Call.BATHROOM, () -> System.out.println("BATHROOM"));
        enumMap.put(Call.KITCHEN, () -> System.out.println("KITCHEN"));

        enumMap.get(Call.BATHROOM).action();


        for(Map.Entry<Call,Command> c: enumMap.entrySet()) {
            c.getValue().action();
        }
    }
}
