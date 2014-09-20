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

;; Finds the next symbol to be added to our Roman numeral. It does
;; this by searching the list of symbols linearly for the first one
;; whose value is less than or equal to n. For instance, if n is 970,
;; then the next symbol in our roman numeral should be "CM" because
;; 900 is less than or equal to 970.
(defn next-symbol [n]
  (first (filter #(<= (:value %) n) symbols)))

;; Returns the Roman numeral representation for a given value
(defn roman [n]
  (if (zero? n)
    ""
    (let [sym (next-symbol n)]  ; Finds the next symbol to put in the result
      ;; Now concatenate that symbol to the lazy sequence found by substracting
      ;; the value of the symbolf from n
      (str (:symbol sym) (apply str (lazy-seq (roman (- n (:value sym)))))))))
