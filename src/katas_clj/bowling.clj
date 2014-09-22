(ns katas-clj.bowling)

(defn strike? [frame]
  (= 10 (get frame 0)))

(defn spare? [frame]
  (let [roll-1 (get frame 0)
        roll-2 (get frame 1)]
    (and
      (not (nil? roll-2))
      (= 10 (+ roll-1 roll-2))
      )))

(defn complete? [frame]
  (or
    (nil? frame)
    (strike? frame)
    (not (nil? (get frame 1)))
    ))

(defn frame-total
  "Given the total before a frame, the first roll for the frame and the two rolls after that,
  returns the total after the frame."
  [total three-rolls]

  (let [roll-1 (get three-rolls 0)
        roll-2 (get three-rolls 1)
        roll-3 (get three-rolls 2)]
    (cond
      (= 10 roll-1) (+ total roll-1 roll-2 roll-3)
      (= 10 (+ roll-1 roll-2)) (+ total roll-1 roll-2 roll-3)
      :else (+ total (reduce + (take 2 three-rolls))))))

(defn frame [total pin-counts]
  (let [[roll-1 roll-2] (take 2 pin-counts)]
    [roll-1                               ; set first roll of frame to roll-1
     (if (= 10 roll-1) nil roll-2)        ; set second roll: if strike, set to nil; otherwise, set to roll-2
     (frame-total total pin-counts)]))    ; set cumulative total

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

