(ns katas-clj.prime-factors)

(defn prime-factors [n]
    (if (even? n)
      (cons 2 (prime-factors (/ n 2)))
      (if (> n 1) [n] [])))

(defn prime-factors-1 [n]
  (assert (> n 0))
      (if (= n 1) [1]
      (prime-factors n)))

