(ns katas-clj.binary-search)

(defn search-subvector
  ([v value start-index]
   (let [length (.length v)
         half (int (/ length 2))
         vec-value (get v half)]
     (cond
       (= 0 length) nil
       (= 1 length) (if (= value vec-value) start-index nil)
       (= value vec-value) (+ start-index half)
       (< value vec-value) (search-subvector (subvec v 0 half) value start-index)
       (> value vec-value) (search-subvector (subvec v half) value (+ start-index half))))))

(defn search
  "Returns the index of the specified value within the sorted vector v. If the vector
  does not contain the value, returns nil"
  ([v value]
   (search-subvector v value 0)))
