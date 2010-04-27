(ns roman-numerals
  (:require [clojure.contrib.str-utils2 :as s]))

(defn roman-to-arabic-single-digit [roman]
  (condp = roman
    \I 1
    \V 5
    \X 10
    \L 50
    \C 100
    \D 500
    \M 1000
    roman)
  )

(defn get-closest-num [arabic]
  (some #(if (<= % arabic) % false) [1000 900 500 400 100 90 50 40 10 9 5 4 1])
  )

(defn arabic-to-roman-single-digit [arabic]
  (condp = arabic
    1 "I"
    4 "IV"
    5 "V"
    9 "IX"
    10 "X"
    40 "XL"
    50 "L"
    90 "XC"
    100 "C"
    400 "CD"
    500 "D"
    900 "CM"
    1000 "M"
  ))

(defn replace-subtractives [roman]
  (let [swappers [["IV" "IIII"] 
                  ["IX" "VIIII"]
                  ["XL" "XXXX"]
                  ["XC" "LXXXX"]
                  ["CD" "CCCC"]
                  ["CM" "DCCCC"]]
        swapper (fn [in [old new]] (s/replace in old new))]
        (reduce swapper roman swappers)))
        
(defn roman-to-arabic [roman]
  (reduce + (map roman-to-arabic-single-digit (replace-subtractives roman))))

(defn arabic-to-roman [arabic]
  (loop [arabic-num arabic
       roman ""]
        (let [closest-num (get-closest-num arabic-num)]
          (if (= 0 arabic-num)
            roman
            (recur (- arabic-num closest-num) (str roman (arabic-to-roman-single-digit closest-num)))))))


