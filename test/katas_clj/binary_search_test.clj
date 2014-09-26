(ns katas-clj.binary-search-test
  (:require [clojure.test :refer :all]
            [clojure.test.tap :refer :all]
            [katas-clj.binary-search :refer :all]))

;(deftest test-search
;  (are [vec value expected] (= expected (search vec value))
;                            [] 100 nil
;                            [100] 100 0
;                            [100 101] 100 0
;                            [100 101] 101 1
;                            [100 101 102 103] 102 2
;                            [100 101 102 104] 104 3
;                            ))

(defn add-random [x]
  (+ x (int (* 10 (rand)))))

(deftest test-big-vector
  (let [vector (vec (take 5000 (iterate add-random 1)))
        size (.length vector)
        idx 4323
        value (get vector idx)
        actual (search vector value)]
    (is (= idx actual))))


(run-tests)
