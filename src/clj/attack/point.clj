(ns attack.point)

(defn point [x y]
  [x y])

(defn point-add [[x1 y1] [x2 y2]]
  [(+ x1 x2) (+ y1 y2)])