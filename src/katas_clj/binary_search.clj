(ns katas-clj.binary-search)

(defn search
  ([v value]
   (if (= 0 (.length v)) nil (search v value 0)))
  ([v value start-index]
   (let [length (.length v)
         half (int (/ length 2))
         vec-value (get v half)]
     (cond
       (= 0 length) nil
       (= 1 length) (if (= value vec-value) start-index nil)
       (= value vec-value) (+ start-index half)
       (< value vec-value) (search (subvec v 0 half) value start-index)
       (> value vec-value) (search (subvec v half) value (+ start-index half))))))
