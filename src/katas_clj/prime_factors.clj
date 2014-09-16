(ns katas-clj.prime-factors)

(defn prime-factors-for-even [n]
  (let [primes []]
    (cond
      (and (odd? n) (> n 1)) [n]
      (odd? n) []
      :else (cons 2 (prime-factors-for-even (/ n 2))))))

(defn prime-factors-1 [n]
  (assert (> n 0))
  (let [primes []]
    (cond
      (= n 1) [1]
      (= n 2) [2]
      (odd? n) [n]
      :else (prime-factors-for-even n))))

