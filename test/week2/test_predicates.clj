(ns week2.test-predicates
  (:use midje.sweet
        week2.predicates))


(facts "generic doublificate"
       (generic-doublificate 1)      => 2
       (generic-doublificate [1 2])  => (just [2 4])
       (generic-doublificate {})     => nil?
       (generic-doublificate [])     => nil?
       (generic-doublificate {:a 1}) => true)

(facts "empty-string?"
       (empty-string? " \t\n\t ") => true
       (empty-string? "  \t a")   => false
       (empty-string? "")         => true)
