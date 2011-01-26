(ns week2.test-collections
  (:use midje.sweet
        week2.collections))

(fact "doublificate"
      (doublificate {"a" 1 "b" 7}) => {"a" 1, "double-a" 2
                                       "b" 7 "double-b" 14})
