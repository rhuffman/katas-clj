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

;; This implementation comes from a StackOverflow thread:
;; http://stackoverflow.com/questions/9556393/clojure-tail-recursion-with-prime-factors
;; Wish I had the chops to come up with this
(defn prime-factors-2
  ([n] (prime-factors-2 n 2))
  ([n candidate]
   (cond (<= n 1) ()
     (zero? (rem n candidate)) (cons candidate (lazy-seq (prime-factors-2 (/ n candidate)
                                                           candidate)))
     :else (recur n (inc candidate)))))


