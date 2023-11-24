package entity;

import java.util.List;

public interface CollectionFactory {
    Collection create(List<String> items);
}
