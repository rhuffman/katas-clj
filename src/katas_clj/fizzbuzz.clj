(ns katas-clj.fizzbuzz)

(defn fizzbuzz-1 [n]
  (if (= (rem n 15) 0)
    "fizzbuzz"
    (if (= (rem n 5) 0)
      "buzz"
      (if (= (rem n 3) 0)
        "fizz"
        n))))

(defn fizzbuzz-2 [n]
  (if (zero? (rem n 15))
    "fizzbuzz"
    (if (zero? (rem n 5))
      "buzz"
      (if (zero? (rem n 3))
        "fizz"
        n))))

(defn fizzbuzz-3 [n]
  (cond
    (zero? (rem n 15)) "fizzbuzz"
    (zero? (rem n 5)) "buzz"
    (zero? (rem n 3)) "fizz"
    :else n))
