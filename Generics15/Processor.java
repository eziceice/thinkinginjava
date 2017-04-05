package Generics15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/2/20.
 */
interface Processor<T,E extends Exception,F extends Exception> {
}


class ProcessroRunner<T, E extends Exception, F extends Exception> extends ArrayList<Processor<T,E,F>> {
    List<T> processAll() throws E,F {
        return new ArrayList<T>();
    }

}
