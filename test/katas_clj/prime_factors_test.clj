(ns katas-clj.prime-factors-test
  (:require [clojure.test :refer :all]
            [katas-clj.prime-factors :refer :all]))

; Map of test data. Key is input to the function being tested;
; value is ; the expected output
(def test-data [[1 [1]]
                [2 [2]]
                [3 [3]]
                [4 [2 2]]
                [5 [5]]
                [6 [2 3]]
                [7 [7]]
                [8 [2 2 2]]
                ])

; Array of functions to test
(def test-functions [prime-factors-1])

; Takes a function as input, invokes the function
; on each key in test-data, and compares the output to the
; expected value in test-data
(defn run [test-function]
  (doseq [[input expected] test-data]
    (let [actual (test-function input)]
          (is (= actual expected)))))

; Iterate the list of functions, testing each in turn
(deftest all-functions-test
  (doseq [test-function test-functions]
    (run test-function)))






