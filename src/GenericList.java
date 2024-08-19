import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public T find(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public List<T> getAll() {
        return items;
    }
}
