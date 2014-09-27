(ns katas-clj.binary-search)

(defn binary-search-subvector
  "Searches a sorted subvector of another vector for a specific value. The start-index parameter
  should be the index of the subvector within its outer vector, and the returned value is the
  index of value within the outer vector. For instance, if the outer vector is [10 20 30 40],
  then (search-subvector 40 [30 40] 2) will return 3."
  ([subvector value start-index]
   (let [length (.length subvector)
         half (int (/ length 2))
         vec-value (get subvector half)]
     (cond
       (= 0 length) nil
       (= 1 length) (if (= value vec-value) start-index nil)
       (= value vec-value) (+ start-index half)
       (< value vec-value) (recur (subvec subvector 0 half) value start-index)
       (> value vec-value) (recur (subvec subvector half) value (+ start-index half))))))

(defn binary-search
  "Returns the index of the specified value within the sorted vector v. If the vector
  does not contain the value, returns nil"
  ([v value]
   (binary-search-subvector v value 0)))
