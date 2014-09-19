(ns katas-clj.prime-factors)

(defn divisible-by? [n divisor]
  (= 0 (rem n divisor)))

(defn prime-factors-1
  ([n]
   (assert (> n 0))
   (prime-factors-1 n 2 []))
  ([n divisor factors-so-far]
   (cond
     (= n 1) factors-so-far
     (divisible-by? n divisor) (recur (/ n divisor) divisor (conj factors-so-far divisor))
     :else (recur n (inc divisor) factors-so-far))))

