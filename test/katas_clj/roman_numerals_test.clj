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
                        6      "VI"
                        7      "VII"
                        8      "VIII"
                        10     "X"
                        11     "XI"
                        12     "XII"
                        13     "XIII"
                        15     "XV"
                        16     "XVI"
                        17     "XVII"
                        18     "XVIII"
                        20     "XX"
                        21     "XXI"
                        28     "XXVIII"
                        30     "XXX"
                        37     "XXXVII"
                        50     "L"
                        51     "LI"
                        58     "LVIII"
                        70     "LXX"
                        78     "LXXVIII"
                        100    "C"
                        101    "CI"
                        120    "CXX"
                        138    "CXXXVIII"
                        150    "CL"
                        188    "CLXXXVIII"
                        200    "CC"
                        230    "CCXXX"
                        288    "CCLXXXVIII"
                        300    "CCC"
                        322    "CCCXXII"
                        500    "D"
                        501    "DI"
                        888    "DCCCLXXXVIII"
                        1000   "M"
                        1100   "MC"
                        1776   "MDCCLXXVI"
                        1888   "MDCCCLXXXVIII"
                        2000   "MM"
                        2888   "MMDCCCLXXXVIII"
                        3000   "MMM"
                        3888   "MMMDCCCLXXXVIII"
                        ))


(run-tests)

