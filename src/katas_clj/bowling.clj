(ns katas-clj.bowling)

(defn strike? [frame]
  (= 10 (:roll-1 frame)))

(defn frame-total
  "Given the total before a frame and the next three rolls, calculate the total
  after the frame."
  [total three-rolls]

  (let [roll-1 (get three-rolls 0)
        roll-2 (get three-rolls 1)
        roll-3 (get three-rolls 2)]
    (cond
      (= 10 roll-1) (+ total roll-1 roll-2 roll-3)
      (= 10 (+ roll-1 roll-2)) (+ total roll-1 roll-2 roll-3)
      :else (+ total (reduce + (take 2 three-rolls))))))

(defn frame [frame-number total three-rolls]
  {:roll-1 (get three-rolls 0)
   :roll-2 (if (and (< frame-number 10) (= 10 (get three-rolls 0))) nil (get three-rolls 1))
   :roll-3 (if (= 10 frame-number) (get three-rolls 2) nil)
   :total (frame-total total three-rolls)})

(defn score-frames [frames pin-counts]
  (let [frame-count (.length frames)
        total (if (zero? frame-count) 0 (:total (last frames)))]
    (if (= frame-count 10)
      frames
      (let [pin-counts (if (= 0 frame-count) pin-counts (if (strike? (last frames)) (subvec pin-counts 1) (subvec pin-counts 2)))]
        (recur (frames (conj frames frame((inc frame-count) total pin-counts))) pin-counts)))))

;; Takes a sequence of pin counts thrown on successive
;; rolls by a single player during a game of bowling.
;; Returns a sequence of 10 maps, one per frame,
;; that contain these values:
;;   :roll1        Pins on the first roll of the frame
;;   :roll2        Pins on the second roll of the frame
;;                 (nil if roll1 is a strike)
;;   :cumulative   Cumlative score for the game at the
;;                 end of the frame
(defn score [pin-counts] (score-frames [] pin-counts))

