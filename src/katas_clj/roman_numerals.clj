(ns katas-clj.roman-numerals)

(defn divisible-by? [n divisor]
  (zero? (rem n divisor)))

(def symbols [
               { :value 1000 :symbol "M"}
               { :value 900  :symbol "CM"}
               { :value 500  :symbol "D"}
               { :value 400  :symbol "CD"}
               { :value 100  :symbol "C"}
               { :value 90   :symbol "XC"}
               { :value 50   :symbol "L"}
               { :value 40   :symbol "XL"}
               { :value 10   :symbol "X"}
               { :value 9    :symbol "IX"}
               { :value 5    :symbol "V"}
               { :value 4    :symbol "IV"}
               { :value 1    :symbol "I"}
              ])

(defn next-symbol [n]
  (first (filter #(>= n (:value %)) symbols)))

(defn roman [n]
  (if (zero? n)
    ""
    (let [sym (next-symbol n)]
      (str (:symbol sym) (apply str (lazy-seq (roman (- n (:value sym)))))))))
