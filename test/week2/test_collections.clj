(ns week2.test-collections
  (:use midje.sweet
        week2.collections))

(fact "doublificate"
      (doublificate {"a" 1 "b" 7}) => {"a" 1, "double-a" 2
                                       "b" 7 "double-b" 14})

(facts "halve"
       (halve [1 2 3 4])   => (just (just 1 2) (just 3 4))
       (halve [1 2 3 4 5]) => (just (just 1 2 3) (just 4 5)))

(facts "first-five-positives"
       (first-five-positives [1 3 -2 3 2 0 10 -1 42]) => (just 1 3 3 2 10)
       (first-five-positives [1 -2 9 -4 -5])          => (just 1 9))

(fact "snip"
      (snip [1 4 2 :snip 8 2 9]) => (just (just 1 4 2) (just 8 2 9)))
