(ns katas-clj.bowling-test
  (:require [clojure.test :refer :all]
            [clojure.test.tap :refer :all]
            [katas-clj.bowling :refer :all]))

(deftest test-strike
  (are [frame expected] (= expected (strike? frame))
                        {:roll-1 10 :roll-2 nil} true
                        {:roll-1 1 :roll-2 9} false
                        ))

(defn compare-coll [expected actual]
  (let [same (.equals expected actual)]
    (do
      (if (not same) (printf "Expected %s but was %s%n" expected actual))
      same)))

(deftest test-frame
  (are [frame-number total next-three expected]
    (compare-coll expected (frame frame-number total next-three))

    ; open, first frame
    1 0 [8 1 10] {:roll-1 8 :roll-2 1 :roll-3 nil :total 9}

    ; open, middle frame
    2 8 [8 1 10] {:roll-1 8 :roll-2 1 :roll-3 nil :total 17}

    ; open, last frame
    10 8 [8 1] {:roll-1 8 :roll-2 1 :roll-3 nil :total 17}

    ; spare, first frame
    1 0 [8 2 7] {:roll-1 8 :roll-2 2 :roll-3 nil :total 17}

    ; spare, middle frame
    4 9 [1 9 10] {:roll-1 1 :roll-2 9 :roll-3 nil :total 29}

    ; spare, last frame
    10 9 [1 9 10] {:roll-1 1 :roll-2 9 :roll-3 10 :total 29}

    ; strike, first frame
    1 0 [10 2 8] {:roll-1 10 :roll-2 nil :roll-3 nil :total 20}

    ; strike, middle frame
    7 9 [10 10 10] {:roll-1 10 :roll-2 nil :roll-3 nil :total 39}

    ; strike, last frame
    10 152 [10 6 4] {:roll-1 10 :roll-2 6 :roll-3 4 :total 172}

    ))

(deftest bowling-test
  (are [pin-counts expected] (compare-coll expected (score pin-counts))
                             [1 4 4 5 6 4 5 5 10 0 1 7 3 6 4 10 2 8 6]
                             [{:roll-1 1  :roll-2 4   :roll-3 nil :total 5  }
                              {:roll-1 4  :roll-2 5   :roll-3 nil :total 14 }
                              {:roll-1 6  :roll-2 4   :roll-3 nil :total 29 }
                              {:roll-1 5  :roll-2 5   :roll-3 nil :total 49 }
                              {:roll-1 10 :roll-2 nil :roll-3 nil :total 60 }
                              {:roll-1 0  :roll-2 1   :roll-3 nil :total 61 }
                              {:roll-1 7  :roll-2 3   :roll-3 nil :total 77 }
                              {:roll-1 6  :roll-2 4   :roll-3 nil :total 97 }
                              {:roll-1 10 :roll-2 nil :roll-3 nil :total 117}
                              {:roll-1 2  :roll-2 8   :roll-3 6   :total 133}]))


(run-tests)
