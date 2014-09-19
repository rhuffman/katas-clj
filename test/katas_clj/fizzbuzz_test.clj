(ns katas-clj.fizzbuzz-test
  (:require [clojure.test :refer :all]
            [katas-clj.fizzbuzz :refer :all]))

; Map of test data. Key is input to the fizzbuzz function; value is
; the expected output from the fizzbuzz function
(def test-data {1 1
                2 2
                3 "fizz"
                4 4
                5 "buzz"
                6 "fizz"
                10 "buzz"
                15 "fizzbuzz"})

; Array of fizzbuzz functions to test
(def fizzbuzz-fns [fizzbuzz-1
                   fizzbuzz-2
                   fizzbuzz-3])

; Take a fizzbuzz function as input. Run the fizzbuzz function
; on each key in test-data and compare the output to the
; expected value
(defn run [fizzbuzz]
  (doseq [[input expected] test-data]
    (is (= (fizzbuzz input) expected))))

; Iterate the list of fizzbuzz functions, testing each in turn
(deftest fizzbuzz-test
  (doseq [fizzbuzz fizzbuzz-fns]
     (run fizzbuzz)))

(run-tests)
