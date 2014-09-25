(ns katas-clj.bowling)

(defn strike?
  "Returns true if the specified frame was a strike"
  [frame]
  (= 10 (:roll-1 frame)))

(defn frame-total
  "Given the cumulative total of the game before a frame and the next three rolls, calculate
  the total after the frame."
  [total three-rolls]
  (let [roll-1 (get three-rolls 0)
        roll-2 (get three-rolls 1)
        roll-3 (get three-rolls 2)]
    (cond
      (= 10 roll-1) (+ total roll-1 roll-2 roll-3)
      (= 10 (+ roll-1 roll-2)) (+ total roll-1 roll-2 roll-3)
      :else (+ total roll-1 roll-2))))

(defn frame
  "Given a frame number, the total before the frame, and the remaining rolls, return a frame."
  [frame-number total three-rolls]
  {:roll-1 (get three-rolls 0)
   :roll-2 (if (and (< frame-number 10) (= 10 (get three-rolls 0))) nil (get three-rolls 1))
   :roll-3 (if (= 10 frame-number) (get three-rolls 2) nil)
   :total (frame-total total three-rolls)})

(defn next-pins
  "Given the previous frame and the pin-counts used to calculate it, return the pin-counts needed
  to create the next frame."
  [frame pin-counts]
  (let [roll-1 (:roll-1 frame)]
    (cond
      (= roll-1 nil) pin-counts           ; No frames so far: just use all the pin-counts
      (= roll-1 10) (subvec pin-counts 1) ; Last frame was a strike. Lop off the first pin-count
      :else (subvec pin-counts 2))))      ; Otherwise lop off the first two pin-counts

(defn score
  "Takes a sequence of pin counts thrown on successive rolls by a single player during a
  game of bowling. Returns a sequence of 10 maps representing the frames. Each map contains
  these values:
  :roll-1   Pins on the first roll of the frame
  :roll-2   Pins on the second roll of the frame (nil if roll1 is a strike)
  :roll-3   Pins on the third roll. Only populated in the 10th frame, if that frame is closed.
  :total    Cumlative score for the game at the end of the frame"
  ([pin-counts]
   (score [] pin-counts))

  ([frames pin-counts]
   ; Number of frames created so far tells us what frame we are currently calculating
   ; Total is zero if this is the first frame, :total from the previous frame otherwise
  (let [frame-count (.length frames)
        total (if (zero? frame-count) 0 (:total (last frames)))]

    ; If we have 10 frames already, we must be done. Otherwise, calculate the next frame,
    ; add it to the list of frames, then invoke recursively.
    (if (= frame-count 10)
      frames
      (let [pin-counts (next-pins (last frames) pin-counts)]
        (recur (conj frames (frame (inc frame-count) total pin-counts)) pin-counts))))))

