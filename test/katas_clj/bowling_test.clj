(ns katas-clj.bowling-test
  (:require [clojure.test :refer :all]
            [clojure.test.tap :refer :all]
            [katas-clj.bowling :refer :all]))

(deftest bowling-test
  (are [pin-counts expected] (zero? (compare expected (score pin-counts)))
                             [1 4 4 5 6 4 5 5 10 0 1 7 3 6 4 10 2 8 6]
                             [[1 4 5]
                              [4 5 14]
                              [6 4 29]
                              [5 5 49]
                              [10 nil 60]
                              [0 1 61]
                              [7 3 77]
                              [6 4 97]
                              [10 nil 117]
                              [2 8 6]]))


(run-tests)
