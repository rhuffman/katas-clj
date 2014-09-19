(ns katas-clj.prime-factors-test
  (:require [clojure.test :refer :all]
            [katas-clj.prime-factors :refer :all]))

; Map of test data. Key is input to the function being tested;
; value is ; the expected output
(def test-data [[1 []]
                [2 [2]]
                [3 [3]]
                [4 [2 2]]
                [5 [5]]
                [6 [2 3]]
                [7 [7]]
                [8 [2 2 2]]
                [9 [3 3]]
                [10 [2 5]]
                [11 [11]]
                [12 [2 2 3]]
                [13 [13]]
                [14 [2 7]]
                [15 [3 5]]
                [16 [2 2 2 2]]
                ])

; Array of functions to test
(def test-functions [prime-factors-1])

; Takes a function as input, invokes the function
; on each key in test-data, and compares the output to the
; expected value in test-data
(defn run [test-function]
  (doseq [[input expected] test-data]
    (is (= (test-function input) expected))))

; Iterate the list of functions, invoking (run fn) for each in turn
(deftest all-functions-test
  (doseq [test-function test-functions]
    (run test-function)))

; Test that a very large number doesn't blow the stack
(deftest large-number-test
  (doseq [test-function test-functions]
    (test-function (- (long (Math/pow 2 32)) 1))))

