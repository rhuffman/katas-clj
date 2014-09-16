(ns katas-clj.prime-factors)

(defn prime-factors [n]
    (if (odd? n)
      (if (> n 1) [n] [])
      (cons 2 (prime-factors (/ n 2)))))

(defn prime-factors-1 [n]
  (assert (> n 0))
  (let [primes []]
    (cond
      (= n 1) [1]
      (= n 2) [2]
      (odd? n) [n]
      :else (prime-factors n))))

