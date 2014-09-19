(ns katas-clj.roman-numerals-test
  (:require [clojure.test :refer :all]
            [katas-clj.roman-numerals :refer :all]))

(def test-data [[1 "I"]
                [ 2 "II"]
                [ 3 "III"]
                [ 4 "IV"]
                [ 5 "V"]
                ])

(deftest roman-test
  (doseq [[input expected] test-data]
    (printf "(roman %d) == '%s'%n" input (roman input))
    (is (.equals (roman input) expected))))
