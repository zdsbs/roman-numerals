(ns roman-numerals
  (:require [clojure.contrib.str-utils2 :as s]))

(defn convert-single-digit [roman]
  (cond 
    (= \I roman) 1
    (= \V roman) 5
    (= \X roman) 10
    (= \L roman) 50
    (= \C roman) 100
    (= \D roman) 500
    (= \M roman) 1000
    :else roman)
  )

(defn replace-subtractives [roman]
  (let [swappers [["IV" "IIII"] 
                  ["IX" "VIIII"]
                  ["XL" "XXXX"]
                  ["XC" "LXXXX"]
                  ["CD" "CCCC"]
                  ["CM" "DCCCC"]]
        swapper (fn [in [old new]] (s/replace in old new))]
        (reduce swapper roman swappers)))
        
(defn convert [roman]
  (reduce + (map convert-single-digit (replace-subtractives roman))))

