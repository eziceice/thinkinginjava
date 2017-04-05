package AccessPermission6;

/**
 * Created by Ryan on 2017/1/20.
 */
public class ConnectionManager {
    private static Connection[] connections = {Connection.getConnection()};


    public static void main(String[] args) {
        controlConnection();
        controlConnection();
    }

    public static Connection controlConnection(){
        if(connections[0] != null){
            connections[0] = null;
            System.out.println("has");
            return Connection.getConnection();
        } else {
            System.out.println("no");
            System.out.println();
            return null;
        }
    }


    static class Connection{

        private static Connection connection = new Connection();
        private Connection() {
        }

        public static Connection getConnection(){
            return connection;
        }
    }

}


