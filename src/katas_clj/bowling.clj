(ns katas-clj.bowling)

(defn frame-total
  "Given the total before a frame, the first roll for the frame and the next two rolls,
  returns the total after the frame."
  [total three-rolls]

  (assert (= 3 (.length three-rolls)))

  (let [roll-1 (get three-rolls 0)
        roll-2 (get three-rolls 1)
        roll-3 (get three-rolls 2)]
    (cond
      (= 10 roll-1) (+ total roll-1 roll-2 roll-3)
      (= 10 (+ roll-1 roll-2)) (+ total roll-1 roll-2 roll-3)
      :else (+ total (reduce + (take 2 three-rolls))))))

(defn frame [total three-rolls]
  [(get three-rolls 0)
   (if (= 10 (get three-rolls 0)) nil (get three-rolls 1))
   (frame-total total three-rolls)])

;; Takes a sequence of pin counts thrown on successive
;; rolls by a single player during a game of bowling.
;; Returns a sequence of 10 maps, one per frame,
;; that contain these values:
;;   :roll1        Pins on the first roll of the frame
;;   :roll2        Pins on the second roll of the frame
;;                 (nil if roll1 is a strike)
;;   :cumulative   Cumlative score for the game at the
;;                 end of the frame
(defn score [pin-counts]
  (pin-counts))
