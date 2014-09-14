(ns katas-clj.fizzbuzz)

; My first (possibly naive) implmentation: just a sequence
; of if-then-else statements
(defn fizzbuzz-1 [n]
  (if (= (rem n 15) 0)
    "fizzbuzz"
    (if (= (rem n 5) 0)
      "buzz"
      (if (= (rem n 3) 0)
        "fizz"
        n))))

; Ah-ha! There's a better way to test for zero
(defn fizzbuzz-2 [n]
  (if (zero? (rem n 15))
    "fizzbuzz"
    (if (zero? (rem n 5))
      "buzz"
      (if (zero? (rem n 3))
        "fizz"
        n))))

; Now use the cond macro
(defn fizzbuzz-3 [n]
  (cond
    (zero? (rem n 15)) "fizzbuzz"
    (zero? (rem n 5)) "buzz"
    (zero? (rem n 3)) "fizz"
    :else n))
