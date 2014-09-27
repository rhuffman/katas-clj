(ns katas-clj.binary-search-test
  (:require [clojure.test :refer :all]
            [clojure.test.tap :refer :all]
            [katas-clj.binary-search :refer :all]))

(deftest test-search
  (are [vec value expected] (= expected (binary-search vec value))
                            [] 100 nil

                            [100] 100 0
                            [100] 99 nil
                            [100] 101 nil

                            [100 101] 99 nil
                            [100 101] 100 0
                            [100 101] 101 1
                            [100 101] 102 nil

                            [100 101 102] 99 nil
                            [100 101 102] 100 0
                            [100 101 102] 101 1
                            [100 101 102] 102 2
                            [100 101 102] 104 nil
                            ))


(defn add-random
  "Adds a random integer between 1 and 10 to x. Allows me to create a sorted
  vector of n (more or less) random vaues like this: (take n (iterate add-random 1))"
  [x]
  (+ x (int (+ 1 (* 10 (rand))))))

(deftest test-big-vector
  ; Create vector with one million sorted integers. Pick a value out of it, then
  ; search for that value
  (let [size 1000000
        vector (vec (take size (iterate add-random 1)))
        expected-index 87432
        value (get vector expected-index)
        actual (binary-search vector value)]
    (is (= expected-index actual))))

(run-tests)
