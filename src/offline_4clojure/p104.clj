;; Write Roman Numerals - Medium
;; This is the inverse of <a href='92'>Problem 92</a>, but much easier. Given an integer smaller than 4000, return the corresponding roman numeral in uppercase, adhering to the <a href='http://www.numericana.com/answer/roman.htm#valid'>subtractive principle</a>.
;; tags - strings:math
;; restricted - 
(ns offline-4clojure.p104
  (:use clojure.test))

(def __
  (fn [n]
    (let [roman-digit
          (fn [n digit]
            (let [chars {1 "I"
                         5 "V"
                         10 "X"
                         50 "L"
                         100 "C"
                         500 "D"
                         1000 "M"}
                  icon (chars digit)
                  half (chars (* 5 digit))
                  next-icon (chars (* 10 digit))
                  n-icon (apply str (repeat n icon))]
              (if (not next-icon)
                (apply str (repeat n icon))
                (cond
                 (< n 4) n-icon
                 (= n 4) (str icon half)
                 (< 4 n 9) (str half (representation (- n 5) digit))
                 (> n 8) (str icon next-icon)
                 :else ""))))]
      (str (roman-digit (quot n 1000) 1000)
           (roman-digit (quot (rem n 1000) 100) 100)
           (roman-digit (quot (rem n 100) 10) 10)
           (roman-digit (rem n 10) 1)))))

(defn -main []
  (are [soln] soln
(= "I" (__ 1))
(= "XXX" (__ 30))
(= "IV" (__ 4))
(= "CXL" (__ 140))
(= "DCCCXXVII" (__ 827))
(= "MMMCMXCIX" (__ 3999))
(= "XLVIII" (__ 48))
))
