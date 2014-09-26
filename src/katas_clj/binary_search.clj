(ns katas-clj.binary-search)

(defn search
  ([vec value]
  (search vec value 0))
  ([vec value start-index]
  (cond
    (= 0 (.length vec)) nil
    (= 1 (.length vec)) (if (= value (get vec 0)) start-index nil)
    )))