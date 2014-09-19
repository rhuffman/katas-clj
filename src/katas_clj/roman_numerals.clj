(ns katas-clj.roman-numerals)

(defn divisible-by? [n divisor]
  (zero? (rem n divisor)))

(defn roman [n]
  (cond (zero? n) ""
  (divisible-by? n 5) (str "V" (apply str (lazy-seq (roman (- n 5)))))
  :else (apply str (repeat n "I"))))

