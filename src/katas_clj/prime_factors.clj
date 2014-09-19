(ns katas-clj.prime-factors)

(defn divisible-by? [n divisor]
  (= 0 (rem n divisor)))

(defn add-factors [n divisor factors-so-far]
  (cond
    (= n 1) (reverse factors-so-far)
    (divisible-by? n divisor) (recur (/ n divisor) divisor (cons divisor factors-so-far))
    :else (recur n (inc divisor) factors-so-far)))

(defn prime-factors-1 [n]
  (assert (> n 0))
  (add-factors n 2 []))

