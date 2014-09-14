(ns katas-clj.fizzbuzz-test
  (:require [clojure.test :refer :all]
            [katas-clj.fizzbuzz :refer :all]))

(def test-data {1 1 2 2 3 "fizz" 4 4 5 "buzz" 6 "fizz" 10 "buzz" 15 "fizzbuzz"})

(deftest fizzbuzz1-test
  (doseq [[input expected] test-data]
     (is (= (fizzbuzz1 input) expected))
    )
  )
