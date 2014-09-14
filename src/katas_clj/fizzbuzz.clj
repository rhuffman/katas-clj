(ns katas-clj.fizzbuzz)

(defn fizzbuzz1 [n]
  (if (= (rem n 15) 0)
    "fizzbuzz"
    (if (= (rem n 5) 0)
      "buzz"
      (if (= (rem n 3) 0)
        "fizz"
        n))))

(fizzbuzz1 1)
