(ns attack.compat
  (:require [cljs.reader :as reader]))

(defn compat-read-string [val]
  (reader/read-string val))

(defn hex-to-int [hex-str]
  (let [l (length hex-str)
        mults (hex-multipliers l)
        hex-digits (reverse (map hex-digit-to-int hex-str))
        parts (zip mults hex-digits)
        vals (map (fn [[a b]] (* a b)))
        sum (reduce + vals))
    vals))

(defn zip [[a & as]
           [b & bs]]
  (if (or (nil? a) (nil? b))
    '()
    (cons '(a b) (zip as bs))))

(defn length [str]
  (.-length str))

(defn hex-multipliers [len]
  (map (partial pow 16) (range 0 len)))

(defn pow [base exp]
  (.pow js/Math base exp))

(defn hex-digit-to-int [hex-dig]
  (case hex-dig
    "F" 15
    "E" 14
    "D" 13
    "C" 12
    "B" 11
    "A" 10
    "9" 9
    "8" 8
    "7" 7
    "6" 6
    "5" 5
    "4" 4
    "3" 3
    "2" 2
    "1" 1
    "0" 0))