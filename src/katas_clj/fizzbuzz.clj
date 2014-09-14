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
  n)

