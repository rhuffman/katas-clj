(ns katas-clj.roman-numerals-test
  (:require [clojure.test :refer :all]
            [clojure.test.tap :refer :all]
            [katas-clj.roman-numerals :refer :all]))


(deftest roman-test
  (are [input expected] (= expected (roman input))
                        0      ""
                        1      "I"
                        2      "II"
                        3      "III"
                        5      "V"
                        10     "X"
                        20     "XX"
                        30     "XXX"
                        50     "L"
                        100    "C"
                        200    "CC"
                        300    "CCC"
                        500    "D"
                        1000   "M"
                        2000   "MM"
                        3000   "MMM"
                        ))


(run-tests)

