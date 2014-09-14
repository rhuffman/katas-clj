(ns katas-clj.prime-factors)

(defn prime-factors-1 [n]
  (assert (> n 0))
  (let [primes []]
    (cond
      (= n 1) [1]
      (= n 2) [2]
      (> n 2) (if (even? n) (conj primes 2 (/ n 2)) (conj primes n))
      :else primes)))