(ns katas-clj.roman-numerals-test
  (:require [clojure.test :refer :all]
            [clojure.test.tap :refer :all]
            [katas-clj.roman-numerals :refer :all]))


(deftest roman-test
  (are [input expected] (= expected (roman input))
                        0 ""
                        1 "I"
                        2 "II"
                        3 "III"
                        5 "V"))


(run-tests)

