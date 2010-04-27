(ns roman-numerals-test
  (:use clojure.test roman-numerals))

;TDD is very much a decision of where to start
;The first test you write will greatly impact your direction

(deftest roman-to-arabic-single-digits
         (is (= 1 (roman-to-arabic "I")))
         (is (= 5 (roman-to-arabic "V")))
         (is (= 10 (roman-to-arabic "X")))
         (is (= 50 (roman-to-arabic "L")))
         (is (= 100 (roman-to-arabic "C")))
         (is (= 500 (roman-to-arabic "D")))
         (is (= 1000 (roman-to-arabic "M")))
         )

(deftest addition-digits
         (is (= 2 (roman-to-arabic "II")))
         (is (= 3 (roman-to-arabic "III")))
         (is (= 1601 (roman-to-arabic "MDCI")))
         )

(deftest with-subtraction
         (is (= 24 (roman-to-arabic "XXIV")))
         (is (= 1967 (roman-to-arabic "MCMLXVII")))
         (is (= 999 (roman-to-arabic "CMXCIX")))
         (is (= 1444 (roman-to-arabic "MCDXLIV")))
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

(deftest arabic-to-roman-single-digits
         (is (= "I" (arabic-to-roman 1)))
         (is (= "V" (arabic-to-roman 5)))
         (is (= "X" (arabic-to-roman 10)))
         (is (= "L" (arabic-to-roman 50)))
         (is (= "C" (arabic-to-roman 100)))
         (is (= "D" (arabic-to-roman 500)))
         (is (= "M" (arabic-to-roman 1000)))
         )


(deftest arabic-to-roman-results-in-roman-addition
         (is (= "II" (arabic-to-roman 2)))
         (is (= "III" (arabic-to-roman 3)))
         (is (= "VI" (arabic-to-roman 6)))
         (is (= "MDCI" (arabic-to-roman 1601)))
         )

(deftest arabic-to-roman-results-in-roman-sub
         (is (= "IV" (arabic-to-roman 4)))
         (is (= "XXIV" (arabic-to-roman 24)))
         (is (= "MCMLXVII" (arabic-to-roman 1967)))
         (is (= "CMXCIX" (arabic-to-roman 999)))
         (is (= "MCDXLIV" (arabic-to-roman 1444)))
         )

(run-tests 'roman-numerals-test)
