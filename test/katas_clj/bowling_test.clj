(ns katas-clj.bowling-test
  (:require [clojure.test :refer :all]
            [clojure.test.tap :refer :all]
            [katas-clj.bowling :refer :all]))

(deftest test-strike
  (are [frame expected] (= expected (strike? frame))
                        nil false
                        [10 nil nil] true
                        [1 9 nil] false
                        [1 nil nil] false
                        ))

(deftest test-spare
  (are [frame expected] (= expected (spare? frame))
                        nil false
                        [10 nil nil] false
                        [1 9 nil] true
                        ))

(deftest test-complete
  (are [frame expected] (= expected (complete? frame))
                        nil true
                        [10 nil nil] true
                        [1 9 nil] true
                        [1 0 nil] true
                        [1 nil nil] false
                        ))

(defn compare-seq [expected actual]
  (let [same (= 0 (compare expected actual))]
    (do
      (if (not same) (printf "Expected %s but was %s%n" expected actual))
      same)))

(deftest test-frame
  (are [total next-three expected] (compare-seq expected (frame total next-three))
                                   0 [8 1 10] [8 1 9]       ; open, first frame
                                   8 [8 1 10] [8 1 17]      ; open, frame after the first
                                   0 [8 2 7] [8 2 17]       ; spare, first frame
                                   9 [1 9 10] [1 9 29]      ; spare, frame after the first
                                   0 [10 2 8] [10 nil 20]   ; strike, first frame
                                   9 [10 10 10] [10 nil 38] ; strike, frame after the first
                                   ))

;(deftest bowling-test
;  (are [pin-counts expected] (zero? (compare expected (score pin-counts)))
;                             [1 4 4 5 6 4 5 5 10 0 1 7 3 6 4 10 2 8 6]
;                             [[1 4 5]
;                              [4 5 14]
;                              [6 4 29]
;                              [5 5 49]
;                              [10 nil 60]
;                              [0 1 61]
;                              [7 3 77]
;                              [6 4 97]
;                              [10 nil 117]
;                              [2 8 6]]))


(run-tests)
