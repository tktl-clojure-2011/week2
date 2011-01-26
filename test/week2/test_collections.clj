(ns week2.test-collections
  (:use midje.sweet
        week2.collections))

(fact "doublificate"
      (doublificate {"a" 1 "b" 7}) => {"a" 1, "double-a" 2
                                       "b" 7 "double-b" 14})

(facts "halve"
       (halve [1 2 3 4])   => (just (just 1 2) (just 3 4))
       (halve [1 2 3 4 5]) => (just (just 1 2 3) (just 4 5)))
