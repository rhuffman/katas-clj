(ns katas-clj.roman-numerals)

(defn divisible-by? [n divisor]
  (zero? (rem n divisor)))

(def symbols [{ :value 10 :symbol "X"}
              { :value 5  :symbol "V"}
              { :value 1  :symbol "I"}
              ])

(defn next-symbol [n]
  (first (filter #(>= n (:value %)) symbols)))

(defn roman [n]
  (if (zero? n)
    ""
    (let [sym (next-symbol n)]
      (str (:symbol sym) (apply str (lazy-seq (roman (- n (:value sym)))))))))
