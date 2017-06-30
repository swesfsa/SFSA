package misc;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.List;

/**
 * Created by tmonn on 29.06.2017.
 */
public abstract class Subject {
    /**
     * @associates <{misc.IObserver}>
     */

    protected List<IObserver> observerList;

    public void attach(IObserver observer) {
        observerList.add(observer);
    }

    public void detach(IObserver observer) {
        observerList.remove(observer);
    }

    public List<IObserver> getObserverList () {
        return observerList;
    }
    public abstract void notifyObservers();
}
