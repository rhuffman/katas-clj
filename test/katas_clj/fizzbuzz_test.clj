(ns katas-clj.fizzbuzz-test
  (:require [clojure.test :refer :all]
            [katas-clj.fizzbuzz :refer :all]))

(def test-data {1 1
                2 2
                3 "fizz"
                4 4
                5 "buzz"
                6 "fizz"
                10 "buzz"
                15 "fizzbuzz"})

(defn run [fizzbuzz]
  (doseq [[input expected] test-data]
    (is (= (fizzbuzz input) expected))))

(deftest fizzbuzz-1-test
  (run fizzbuzz-1))

(deftest fizzbuzz-2-test
  (run fizzbuzz-2))

