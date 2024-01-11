package common.builder;

public interface DifBuilder<T> {
    /**
     * build a product.
     *
     * @return the constructed product
     */
    T build();
}
