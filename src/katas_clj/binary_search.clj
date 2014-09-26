(ns katas-clj.binary-search)

(defn search
  ([v value]
  (search v value 0))
  ([v value start-index]
   (cond
     (= 0 (.length v)) nil
     (= 1 (.length v)) (if (= value (get v 0)) start-index nil)
     :else
     (let [half (/ (.length v) 2)
           vec-value (get v half) ]
       (cond
         (= value vec-value) (+ start-index half)
         (< value vec-value) (search (subvec v 0 half) value start-index)
         (> value vec-value) (search (subvec v half) value (+ start-index half)))))))
