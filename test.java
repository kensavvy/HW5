public void put(K key, V value) {
    if lookup(key) {
        return;
    }

    for (i = 0; i < CAPACTIY; i++) {
        if (table1[hash1(key)] is empty) {
            table1[hash1(key)] = key;
            return;
        }

        swap(key, table1[hash1(key)]);

        if (table2[hash2(key)] is empty) {
            table2[hash2(key)] = key;
            return;
        }

        swap(key, table2[hash2(key)]);
    }
    
    rehash();
    put(key);
    
}
