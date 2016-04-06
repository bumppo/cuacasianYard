package caucasianYard.matcher;


import junit.framework.Assert;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ModelMatcher<T, R> {
    protected Function<T, R> entityConverter;
    protected Class<T> entityClass;

    public ModelMatcher(Function<T, R> entityConverter, Class<T> entityClass) {
        this.entityConverter = entityConverter;
        this.entityClass = entityClass;
    }

    public void assertEquals (T expected, T actual){
        Assert.assertEquals(entityConverter.apply(expected), entityConverter.apply(actual));
    }

    public void assertCollectionEquals (Collection<T> expected, Collection<T> actual){
        Assert.assertEquals(map(expected, entityConverter), map(actual, entityConverter));
    }

    public static <S, T> List<T> map(Collection<S> collection, Function<S, T> converter) {
        return collection.stream().map(converter).collect(Collectors.toList());
    }
}
