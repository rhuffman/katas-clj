(ns katas-clj.binary-search-test
  (:require [clojure.test :refer :all]
            [clojure.test.tap :refer :all]
            [katas-clj.binary-search :refer :all]))

(deftest test-search
  (are [vec value expected] (= expected (search vec value))
                            [] 100 nil
                            [100] 100 0
                            [100 101] 100 0
  ))

(run-tests)
