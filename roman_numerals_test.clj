(ns roman-numerals-test
  (:use clojure.test roman-numerals))

;TDD is very much a decision of where to start
;The first test you write will greatly impact your direction

(deftest convert-single-digits
         (is (= 1 (convert "I")))
         (is (= 5 (convert "V")))
         (is (= 10 (convert "X")))
         (is (= 50 (convert "L")))
         (is (= 100 (convert "C")))
         (is (= 500 (convert "D")))
         (is (= 1000 (convert "M")))
         )

(deftest addition-digits
         (is (= 2 (convert "II")))
         (is (= 3 (convert "III")))
         (is (= 1601 (convert "MDCI")))
         )

(deftest with-subtraction
         (is (= 24 (convert "XXIV")))
         (is (= 1967 (convert "MCMLXVII")))
         (is (= 999 (convert "CMXCIX")))
         (is (= 1444 (convert "MCDXLIV")))
         )

(deftest replace-subtractives-test
        (is (= "IIII"   (replace-subtractives "IV")))
        (is (= "XIIII"  (replace-subtractives "XIV")))
        (is (= "VIIII"  (replace-subtractives "IX")))
        (is (= "XXXX"   (replace-subtractives "XL")))
        (is (= "LXXXX"  (replace-subtractives "XC")))
        (is (= "CCCC"   (replace-subtractives "CD")))
        (is (= "DCCCC"  (replace-subtractives "CM")))
         )


(run-tests 'roman-numerals-test)
