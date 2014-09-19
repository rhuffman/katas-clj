(ns katas-clj.roman-numerals)

(defn divisible-by? [n divisor]
  (zero? (rem n divisor)))

(defn roman [n]
  (cond (zero? n) nil
  (divisible-by? n 5) (str "V" (lazy-seq (roman (- n 5))))
  :else (apply str (repeat n "I"))))
