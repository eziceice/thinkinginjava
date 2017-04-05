package Enum19;

/**
 * Created by Ryan on 2017/3/23.
 */
public enum EnumExample {
    NORTH(POSITION.WESTPOSITION.class),
    WEST(POSITION.SOUTHPOSITION.class),
    EAST(POSITION.SOUTHPOSITION.class),
    SOUTH(POSITION.WESTPOSITION.class);

    public interface POSITION {
        enum WESTPOSITION implements POSITION {
            WESTNORTH, WESTEAST, WESTSOUTH;
        }
        enum SOUTHPOSITION implements POSITION {
            SOUTHWEST, SOUTHEAST, SOUTHNORTH;
        }
    }

    POSITION[] positions;

    private EnumExample(Class<? extends POSITION> kind) {
        positions = kind.getEnumConstants();
    }

    public POSITION randomSelection() {
        return Enums.random(positions);
    }
}
