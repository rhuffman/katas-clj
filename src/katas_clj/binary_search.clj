(ns katas-clj.binary-search)

(defn search
  ([vec value]
  (search vec value 0))
  ([vec value start-index]
  (cond
    (= 0 (.length vec)) nil
    (= 1 (.length vec)) (if (= value (get vec 0)) start-index nil)
    :else
    (let [half (/ (.length vec) 2)
          vec-value (get vec half) ]
      (cond
        (= value vec-value) (+ start-index half)
        (< value vec-value) (search (subvec vec 0 half) value start-index)
        (> value vec-value) (search (subvec vec half) value (+ start-index half)))))))
