package com.zyz.algorithm.collection.hashmap;

/**
 * This is Description
 *
 * @author yunzhen.zhang
 * @date 2021/10/25
 */
public interface MyMap<K, V> {

    int size();

    V put(K k, V v);

    V get(K k);

    V remove(K k);




    interface Entry<K,V>{

        K getKey();

        V getValue();
    }
}
